package com.saitejajanjirala.snistforum.activities.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.SpannableString
import android.text.TextWatcher
import android.text.style.UnderlineSpan
import android.view.View
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.saitejajanjirala.snistforum.R
import com.saitejajanjirala.snistforum.activities.main.MainActivity
import com.saitejajanjirala.snistforum.activities.otp.OtpActivity
import com.saitejajanjirala.snistforum.utils.Keys
import com.saitejajanjirala.snistforum.utils.Network
import com.saitejajanjirala.snistforum.utils.Toaster
import java.util.concurrent.TimeUnit


class LoginActivity : AppCompatActivity() {
    private lateinit var loginBtn: MaterialButton
    private lateinit var numberText: EditText
    private lateinit var progressLayout: RelativeLayout
    var isValid = false
    private lateinit var firebaseAuth: FirebaseAuth
    private var verificationId: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
        firebaseAuth = FirebaseAuth.getInstance()
        numberText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                val txt = numberText.text.toString()
                isValid = txt != null && txt != "" && txt.trim().length == 10
                setBgForButton()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val txt = numberText.text.toString()
                isValid = txt != null && txt != "" && txt.trim().length == 10
                setBgForButton()
            }
        })
        loginBtn.setOnClickListener {
            if (isValid) {
                progressLayout.visibility = View.VISIBLE
                if (Network.isNetworkConnected(this)) {
                    sendOtp("+91${numberText.text.toString()}")
                } else {
                    progressLayout.visibility = View.GONE
                    Toaster.show(this, getString(R.string.no_internet_connection))
                }
            }
        }
    }

    private fun initView() {
        loginBtn = findViewById(R.id.bt_login)
        numberText = findViewById(R.id.mobile_edit_text)
        progressLayout = findViewById(R.id.progress_layout)
    }

    private fun setBgForButton() {
        if (isValid) {
            loginBtn.background = ContextCompat.getDrawable(this, R.drawable.enable_bg)
        } else {
            loginBtn.background = ContextCompat.getDrawable(this, R.drawable.disable_bg)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Keys.OTP_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            var code=""
            if(data!=null){
                code= data.getStringExtra(Keys.OTP_VALUE)!!
            }
            isValid=false
            progressLayout.visibility=View.VISIBLE
            val credential=PhoneAuthProvider.getCredential(verificationId,code)
            firebaseAuth.signInWithCredential(credential)
                .addOnSuccessListener {
                    progressLayout.visibility=View.GONE
                    startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                    finish()
                }
                .addOnFailureListener {
                    progressLayout.visibility=View.GONE
                    Toaster.show(this,it.message!!)
                }
        }
    }

    private fun sendOtp(number: String) {
        val options = PhoneAuthOptions.newBuilder(firebaseAuth)
            .setPhoneNumber(number)
            .setTimeout(30L, TimeUnit.SECONDS)
            .setActivity(this)
            .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                override fun onCodeSent(
                    verificationId: String,
                    forceResendingToken: PhoneAuthProvider.ForceResendingToken
                ) {
                    this@LoginActivity.verificationId = verificationId
                    progressLayout.visibility=View.GONE
                    Toaster.show(this@LoginActivity, "otp sent to $number")
                    val intent = Intent(this@LoginActivity, OtpActivity::class.java)
                    startActivityForResult(intent, Keys.OTP_REQUEST_CODE)

                }

                override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {
                    progressLayout.visibility=View.GONE
                }

                override fun onVerificationFailed(e: FirebaseException) {
                    Toaster.show(this@LoginActivity, e.message!!.toString())
                    progressLayout.visibility=View.GONE
                }
            })
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }
}