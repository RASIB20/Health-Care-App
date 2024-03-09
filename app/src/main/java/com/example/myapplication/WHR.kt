package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class WHR : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.whr)

        var hipCircumference: Double = 0.0
        var waistCircumference: Double = 0.0
        var hipCircumference_scale: String = ""
        var waistCircumference_scale: String = ""

        val submitButton: Button = findViewById(R.id.submit)
        val radioGroup1: RadioGroup = findViewById(R.id.waistScale)
        val radioGroup2: RadioGroup = findViewById(R.id.hipScale)
        val hip_text_input: TextInputEditText = findViewById(R.id.textInputEditText)
        val waist_text_input: TextInputEditText = findViewById(R.id.textInputEditText2)

        radioGroup1.setOnCheckedChangeListener { _, checkedId ->
            val button: RadioButton = findViewById(checkedId)
            waistCircumference_scale = button.text.toString()
        }
        radioGroup2.setOnCheckedChangeListener { _, checkedId ->
            val button: RadioButton = findViewById(checkedId)
            hipCircumference_scale = button.text.toString()
        }

        submitButton.setOnClickListener {
            val result: TextView = findViewById(R.id.resultText)
            val result2: TextView = findViewById(R.id.resultText2)
            result.visibility = View.VISIBLE

            if (hipCircumference_scale == "Inches") {
                hipCircumference = (hip_text_input.text.toString()).toDouble() * 2.54
            } else {
                hipCircumference = (hip_text_input.text.toString()).toDouble()
            }
            if (waistCircumference_scale == "Inches") {
                waistCircumference = (waist_text_input.text.toString()).toDouble() * 2.54
            } else {
                waistCircumference = (waist_text_input.text.toString()).toDouble()
            }

            if (hipCircumference != 0.0 && waistCircumference != 0.0) {
                val value = (waistCircumference / hipCircumference)
                val valueFormatted = String.format("%.2f", value)
                result2.text = valueFormatted

            } else {
                Toast.makeText(this, "Please enter valid values", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

