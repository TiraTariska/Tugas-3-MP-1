package com.tiratariska.teesapp

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    companion object {
        const val REQUEST_CODE = 100
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_profile = findViewById<Button>(R.id.btn_profile)
        val btn_product = findViewById<Button>(R.id.btn_product)
        val btn_parcel = findViewById<Button>(R.id.btn_parcel)
        val btn_implicit = findViewById<Button>(R.id.btn_implicit)
        val btn_result = findViewById<Button>(R.id.btn_result)

        btn_profile.setOnClickListener {
            val profileIntent = Intent(this@MainActivity, ProfileActivity::class.java)
            startActivity(profileIntent)
        }
        btn_product.setOnClickListener {
            val productIntent = Intent(this@MainActivity, ProductActivity::class.java)
            startActivity(productIntent)
        }
        btn_parcel.setOnClickListener {
            val parcelIntent = Intent(this@MainActivity, ParcelActivity::class.java)
            startActivity(parcelIntent)
        }
        btn_implicit.setOnClickListener {
            val phoneNumber = "089671323344"
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:$phoneNumber"))
            intent.putExtra("sms_body", "Hallo Tira Tariska")
            startActivity(intent)
        }
        btn_result.setOnClickListener {
            val intent = Intent(this@MainActivity, ResultActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == 200){
            val color = data?.getStringExtra(ResultActivity.EXTRA_COLOR)
            Log.d("Color", color.toString())
            view_result.setBackgroundColor(Color.parseColor(color))
        }
    }
}