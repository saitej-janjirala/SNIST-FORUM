package com.saitejajanjirala.snistforum.activities.splash

import android.R.attr.delay
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.saitejajanjirala.snistforum.R
import com.saitejajanjirala.snistforum.activities.login.LoginActivity
import com.saitejajanjirala.snistforum.activities.main.MainActivity


class SplashActivity : AppCompatActivity() {
    private lateinit var splashLogo: ImageView
    private lateinit var splashTitle:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initView()
        startAnimations()
        Handler().postDelayed({
            if(FirebaseAuth.getInstance().currentUser!=null){
                startActivity(Intent(this@SplashActivity,MainActivity::class.java))
            }
            else{
                startActivity(Intent(this@SplashActivity,LoginActivity::class.java))
            }
            finish()
        },3500)
    }
    private fun initView(){
        splashLogo=findViewById(R.id.splash_logo)
        splashTitle=findViewById(R.id.splash_title)
    }
    private fun startAnimations(){
        splashLogo.startAnimation(AnimationUtils
            .loadAnimation(this,R.anim.image_rotation))
        val animation=AlphaAnimation(0f,1f)
        animation.duration=2500
        animation.fillAfter=true
        splashTitle.startAnimation(animation)
    }

}