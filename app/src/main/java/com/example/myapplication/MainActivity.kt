package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutBMI: LinearLayout = findViewById(R.id.layout_bmi)
        val layoutBMR: LinearLayout = findViewById(R.id.layout_bmr)
        val layoutBFP: LinearLayout = findViewById(R.id.layout_bfp)
        val layoutWHR: LinearLayout = findViewById(R.id.layout_whr)


        // Set click listener
        layoutBMI.setOnClickListener {
            startActivity(Intent(this, BMI::class.java))
        }
        layoutBMR.setOnClickListener{
            startActivity(Intent(this,BMR::class.java))
        }
        layoutBFP.setOnClickListener {
            startActivity(Intent(this, BFP::class.java))
        }
        layoutWHR.setOnClickListener{
            startActivity(Intent(this,WHR::class.java))
        }
    }

}
