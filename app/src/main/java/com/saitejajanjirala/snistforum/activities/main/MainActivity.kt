package com.saitejajanjirala.snistforum.activities.main

import android.Manifest
import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.saitejajanjirala.snistforum.MyApplication
import com.saitejajanjirala.snistforum.R
import com.saitejajanjirala.snistforum.activities.admin.AdminLogin
import com.saitejajanjirala.snistforum.activities.login.LoginActivity
import com.saitejajanjirala.snistforum.activities.upload.UploadActivity
import com.saitejajanjirala.snistforum.base.ViewModelProviderFactory
import com.saitejajanjirala.snistforum.fragments.downloads.DownloadFragment
import com.saitejajanjirala.snistforum.fragments.home.HomeFragment
import com.saitejajanjirala.snistforum.utils.Keys

class MainActivity : AppCompatActivity() {
    private lateinit var navigationView: NavigationView
    private lateinit var toolBar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private var activeFragment: Fragment? = null
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        setUpViewModel()
        setListeners()
        navigationView.setCheckedItem(R.id.nav_home)
        if(!checkPermission()){
            requestPermission()
        }
        showHome()
    }

    private fun initView() {
        navigationView = findViewById(R.id.navigation_view)
        toolBar = findViewById(R.id.tool_bar)
        drawerLayout = findViewById(R.id.drawer_layout)
        setSupportActionBar(toolBar)
        supportActionBar?.title = ""
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val toggle = ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun setListeners() {
        mainViewModel.status.observe(this@MainActivity, Observer { status ->
            if (!status) {
                val alertDialog = AlertDialog
                    .Builder(this@MainActivity)
                    .setCancelable(false)
                    .setTitle("Message")
                    .setMessage("You have to login as an admin inorder to upload")
                    .setNegativeButton("cancel") { text, listener ->
                    }
                    .setPositiveButton("okay") { text, listener ->
                    }
                    .show()
                val button: Button = alertDialog
                    .getButton(AlertDialog.BUTTON_POSITIVE)
                button.setOnClickListener {
                    alertDialog.dismiss()
                    val intent = Intent(
                        this@MainActivity,
                        AdminLogin::class.java
                    )
                    startActivityForResult(intent, Keys.ADMIN_REQUEST_CODE)
                }
            } else {
                showUploads()
            }
        })

        navigationView.run {
            itemIconTintList = null
            setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.nav_home -> {
                        supportActionBar?.title = "Home"
                        showHome()
                        true
                    }
                    R.id.nav_upload -> {
                        if (checkPermission()) {
                            mainViewModel.fetchAdminStatus()
                        } else {
                            requestPermission()
                        }
                        true
                    }
                    R.id.nav_logout -> {
                        val alertDialog = AlertDialog
                            .Builder(this@MainActivity)
                            .setCancelable(false)
                            .setTitle("Logout")
                            .setMessage("Do you want to logout?")
                            .setNegativeButton("no") { text, listener ->
                            }
                            .setPositiveButton("yes") { text, listener ->
                            }
                            .show()
                        val button: Button = alertDialog
                            .getButton(AlertDialog.BUTTON_POSITIVE)
                        button.setOnClickListener {
                            FirebaseAuth.getInstance().signOut()
                            mainViewModel.clearAdminStatus()
                            mainViewModel.clearStatus.observe(
                                this@MainActivity,
                                Observer { clearstatus ->
                                    if (clearstatus != null && clearstatus) {
                                        val intent = Intent(
                                            this@MainActivity,
                                            LoginActivity::class.java
                                        )
                                        startActivity(intent)
                                        finish()
                                    }
                                })
                            alertDialog.dismiss()
                        }
                        true
                    }
                    R.id.nav_download -> {
                        if(checkPermission()) {
                            showDownloads()
                        }
                        else{
                            requestPermission()
                        }
                        true
                    }
                    else -> false
                }
                drawerLayout.closeDrawer(navigationView, true)
                return@setNavigationItemSelectedListener true
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        drawerLayout.openDrawer(navigationView, true)
        return true
    }

    private fun showHome() {
        if (activeFragment is HomeFragment) return
        supportActionBar?.title = "Home"
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        var fragment = supportFragmentManager.findFragmentByTag(HomeFragment.TAG) as HomeFragment?

        if (fragment == null) {
            fragment = HomeFragment.newInstance()
            fragmentTransaction.add(R.id.container, fragment, HomeFragment.TAG)
        } else {
            fragmentTransaction.show(fragment)
        }

        if (activeFragment != null) fragmentTransaction.hide(activeFragment as Fragment)

        fragmentTransaction.commit()

        activeFragment = fragment
    }

    private fun showDownloads() {
        if (activeFragment is DownloadFragment) return
        supportActionBar?.title = "Downloads"
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        var fragment = supportFragmentManager
            .findFragmentByTag(DownloadFragment.TAG) as DownloadFragment?

        if (fragment == null) {
            fragment = DownloadFragment.newInstance()
            fragmentTransaction.add(R.id.container, fragment, DownloadFragment.TAG)
        } else {
            fragmentTransaction.show(fragment)
        }

        if (activeFragment != null) fragmentTransaction.hide(activeFragment as Fragment)

        fragmentTransaction.commit()

        activeFragment = fragment
    }

    private fun showUploads() {
        val intent = Intent(this@MainActivity, UploadActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }

    private fun setUpViewModel() {
        val app = application as MyApplication
        mainViewModel = ViewModelProviders.of(
            this,
            ViewModelProviderFactory(
                app.getSharedPrefInstance(),
                app.getCompositeDisposable(),
                app.getDatabaseService()
            )
        ).get(MainViewModel::class.java)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Keys.ADMIN_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            showUploads()
        }
    }

    private fun checkPermission(): Boolean {
        val result = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        val result2 = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
        return result == PackageManager.PERMISSION_GRANTED && result2 == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ),
            123
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            123 -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED
            ) {
                Toast.makeText(
                    this@MainActivity,
                    "Click again to open",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "Permissions denied",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}