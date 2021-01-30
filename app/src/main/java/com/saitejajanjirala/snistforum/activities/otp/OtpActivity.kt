package com.saitejajanjirala.snistforum.activities.otp

import `in`.aabhasjindal.otptextview.OTPListener
import `in`.aabhasjindal.otptextview.OtpTextView
import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.ktx.Firebase
import com.saitejajanjirala.snistforum.R
import com.saitejajanjirala.snistforum.utils.Keys
import com.saitejajanjirala.snistforum.utils.Toaster
import java.util.concurrent.TimeUnit

class OtpActivity : AppCompatActivity() {
    private lateinit var otpView: EditText
    private lateinit var verifyButton: MaterialButton
    private var isValid = false
    private  var userCode:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)
        initView()
        setListeners()
    }

    private fun initView() {
        otpView = findViewById(R.id.otp_view)
        verifyButton = findViewById(R.id.btn_verify)
    }

    private fun setListeners() {
        otpView.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                val txt = otpView.text.toString()
                isValid = txt != null && txt != "" && txt.trim().length == 6
                userCode=txt
                setBgForButton()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val txt = otpView.text.toString()
                isValid = txt != null && txt != "" && txt.trim().length == 6
                userCode=txt
                setBgForButton()
            }
        })
        verifyButton.setOnClickListener {
            if(isValid){
                val intent=Intent()
                intent.putExtra(Keys.OTP_VALUE,userCode)
                setResult(Activity.RESULT_OK,intent)
                finish()
            }
        }
    }
    private fun setBgForButton(){
        if(isValid){
            verifyButton.background= ContextCompat.getDrawable(this,R.drawable.enable_bg)
        }
        else{
            verifyButton.background= ContextCompat.getDrawable(this,R.drawable.disable_bg)
        }
    }

}