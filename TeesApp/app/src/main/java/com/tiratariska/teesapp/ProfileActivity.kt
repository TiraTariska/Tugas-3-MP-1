package com.tiratariska.teesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val follow_count = findViewById<TextView>(R.id.lbl_follow_count)
        val btn_follow = findViewById<TextView>(R.id.btn_follow)

        btn_follow.setOnClickListener {
            btn_follow.text = "Following"
            follow_count.text = "2.079"
        }
    }
}