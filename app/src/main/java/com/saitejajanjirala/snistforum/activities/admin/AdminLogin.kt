package com.saitejajanjirala.snistforum.activities.admin

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.firestore.FirebaseFirestore
import com.saitejajanjirala.snistforum.R
import com.saitejajanjirala.snistforum.MyApplication
import com.saitejajanjirala.snistforum.base.ViewModelProviderFactory
import com.saitejajanjirala.snistforum.utils.Network
import com.saitejajanjirala.snistforum.utils.Toaster

class AdminLogin : AppCompatActivity() {
    private lateinit var adminEmail:EditText
    private lateinit var adminPassword:EditText
    private lateinit var adminLogin: Button
    private lateinit var progressLayout: RelativeLayout
    private lateinit var adminViewModel: AdminViewModel
    private var eMail=""
    private var passWord=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.title="Login as Admin"
        initView()
        setUpViewModel()
        setListeners()
    }
    private fun initView(){
        adminEmail=findViewById(R.id.admin_email)
        adminLogin=findViewById(R.id.admin_login)
        adminPassword=findViewById(R.id.admin_password)
        progressLayout = findViewById(R.id.progress_layout)
    }
    private fun setListeners(){
        adminViewModel.errror.observe(this, Observer {
            Toaster.show(applicationContext,"$it")
        })
        adminViewModel.status.observe(this, Observer {status->
            if(status){
                setResult(Activity.RESULT_OK)
                finish()
                progressLayout.visibility=View.GONE
                adminLogin.alpha=1f
                adminLogin.isEnabled=true
            }
        })
        adminLogin.setOnClickListener {
            eMail=adminEmail.text.toString()
            passWord=adminPassword.text.toString()
            if(!eMail.isNullOrBlank() && !passWord.isNullOrEmpty()){
                if(Network.isNetworkConnected(this)){
                    progressLayout.visibility=View.VISIBLE
                    adminLogin.alpha=0.2f
                    adminLogin.isEnabled=false
                    val db= FirebaseFirestore.getInstance()
                    val docRef=db.document("admin/admin1")
                    docRef.get()
                        .addOnSuccessListener {
                            val actualMap=it.data
                            Log.i("data","$it")
                            val userMap=HashMap<String,String>()
                            userMap["username"] = eMail
                            userMap["password"] = passWord
                            actualMap?.let {
                                if(actualMap.equals(userMap)){
                                    adminViewModel.setStatus(true)
                                }
                                else{
                                    Toaster.show(this,"no Admin found with these credentials")
                                    adminLogin.alpha=1f
                                    adminLogin.isEnabled=true
                                }
                            }?: Toaster.show(this, "no admin found")
                            progressLayout.visibility=View.GONE
                        }
                        .addOnFailureListener {
                            Toaster.show(this,
                                it.message?:"some unexpected error occured")
                            progressLayout.visibility=View.GONE
                            adminLogin.alpha=1f
                            adminLogin.isEnabled=true
                        }
                }
                else{
                    Toaster.show(this,getString(R.string.no_internet_connection))
                }
            }
            else{
                Toaster.show(this,"enter the details properly")
            }
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun setUpViewModel() {
        val app=application as MyApplication
        adminViewModel = ViewModelProviders.of(
            this,
            ViewModelProviderFactory(
                app.getSharedPrefInstance(),
                app.getCompositeDisposable(),
                app.getDatabaseService())
        ).get(AdminViewModel::class.java)
    }


}