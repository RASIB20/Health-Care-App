package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class BMR : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bmr)

        var age: Int = 0
        var height: Double = 0.0
        var weight: Double = 0.0
        var gender: String = ""
        var height_scale: String = ""
        var weight_scale: String = ""

        val submitButton: Button = findViewById(R.id.submit);
        val radioGroup1 : RadioGroup = findViewById(R.id.radioGroupGender);
        val radioGroup2 : RadioGroup = findViewById(R.id.radioGroupHeight);
        val radioGroup3 : RadioGroup = findViewById(R.id.radioGroupWeight);
        val age_text_input: TextInputEditText = findViewById(R.id.textInputEditText);
        val height_text_input: TextInputEditText = findViewById(R.id.textInputEditText2);
        val weight_text_input: TextInputEditText = findViewById(R.id.textInputEditText3);

        submitButton.setOnClickListener {
            val result: TextView = findViewById(R.id.resultText);
            val result2: TextView = findViewById(R.id.resultText2);
            result.visibility = View.VISIBLE
            result2.visibility = View.VISIBLE

            val age_text_input: TextInputEditText = findViewById(R.id.textInputEditText);
            val height_text_input: TextInputEditText = findViewById(R.id.textInputEditText2);
            val weight_text_input: TextInputEditText = findViewById(R.id.textInputEditText3);

            radioGroup1.setOnCheckedChangeListener { _, checkedId ->
                val radioButton: RadioButton = findViewById(checkedId)
                gender = radioButton.text.toString()
            }
            radioGroup2.setOnCheckedChangeListener { _, checkedId ->
                val radioButton: RadioButton = findViewById(checkedId)
                height_scale = radioButton.text.toString()
            }
            radioGroup3.setOnCheckedChangeListener { _, checkedId ->
                val radioButton: RadioButton = findViewById(checkedId)
                weight_scale = radioButton.text.toString()
            }

            age = (age_text_input.text.toString()).toInt();

            if(height_scale == "Inches"){
                height = (height_text_input.text.toString()).toDouble() * 2.54;
            }else{
                height = (height_text_input.text.toString()).toDouble()
            }
            if(weight_scale == "lbs"){
                weight = (weight_text_input.text.toString()).toDouble() * 2.2;
            }else{
                weight = (weight_text_input.text.toString()).toDouble()
            }
            if(gender == "Male"){
               result2.text = (calculateBMRForMen(weight,height,age)).toString()
            }
            else if(gender == "Female"){
                result2.text = (calculateBMRForWomen(weight,height,age)).toString()
            }
        }
        submitButton.setOnClickListener {
        }
    }
    fun calculateBMRForWomen(weight: Double, height: Double, age: Int): Double {
        return 10 * weight + 6.25 * height - 5 * age - 161
    }
    fun calculateBMRForMen(weight: Double, height: Double, age: Int): Double {
        return 10 * weight + 6.25 * height - 5 * age + 5
    }
}