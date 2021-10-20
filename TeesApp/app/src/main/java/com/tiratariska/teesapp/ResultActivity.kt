package com.tiratariska.teesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    companion object {
        const val RESULT_CODE = 200
        const val EXTRA_COLOR = "extra_color"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        btn_result.setOnClickListener {
            if (radioGroup.checkedRadioButtonId != 0) {
                var value = "#fff"
                when (radioGroup.checkedRadioButtonId) {
                    R.id.rad_merah -> value = "#FF0000"
                    R.id.rad_biru -> value = "#6495ED"
                    R.id.rad_kuning -> value = "#FFFF00"
                    R.id.rad_hijau -> value = "#008000"
                }
                Log.d("selected color", value.toString())
                val result = Intent()
                result.putExtra(EXTRA_COLOR, value)
                setResult(200, result)
                finish()
            }
        }
    }
}