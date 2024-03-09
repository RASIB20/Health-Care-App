package com.example.myapplication
import android.content.Intent
import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class BMI : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bmi);

        var age: Int = 0;
        var height: Double = 0.0;
        var weight: Double = 0.0;
        var gender: String = "";
        var height_scale: String = "";
        var weight_scale: String = "";



        val submitButton:Button = findViewById(R.id.submit);
        val radioGroup1 : RadioGroup = findViewById(R.id.radioGroupGender);
        val radioGroup2 : RadioGroup = findViewById(R.id.radioGroupHeight);
        val radioGroup3 : RadioGroup = findViewById(R.id.radioGroupWeight);
        val age_text_input:TextInputEditText = findViewById(R.id.textInputEditText);
        val height_text_input:TextInputEditText = findViewById(R.id.textInputEditText2);
        val weight_text_input:TextInputEditText = findViewById(R.id.textInputEditText3);

        radioGroup1.setOnCheckedChangeListener { _, checkedId ->
            val radioButton: RadioButton = findViewById(checkedId)
            gender = radioButton.text.toString()
        }
        radioGroup2.setOnCheckedChangeListener { _, checkedId ->
            val radioButton: RadioButton = findViewById(checkedId)
            height_scale = radioButton.text.toString();
        }
        radioGroup3.setOnCheckedChangeListener { _, checkedId ->
            val radioButton: RadioButton = findViewById(checkedId)
            weight_scale = radioButton.text.toString()
        }

        submitButton.setOnClickListener {
            val heightString = height_text_input.text.toString();
            val weightString = weight_text_input.text.toString();
            if(heightString.isNotEmpty()){
                if(height_scale == "Cm"){
                    height = heightString.toDouble();
                    height/=100;
                }else if(height_scale == "Inches"){
                    height = heightString.toDouble() * 2.54;
                    height /=100;
                }
            }else{
                Toast.makeText(this, "Enter Height", Toast.LENGTH_SHORT).show()
            }

            if(weightString.isNotEmpty()){
                if(weight_scale == "Kgs"){
                    weight = weightString.toDouble();
                }else if(weight_scale == "lbs"){
                    weight = heightString.toDouble() * 2.2;
                }
            }else{
                Toast.makeText(this, "Enter Weight", Toast.LENGTH_SHORT).show()
            }

            var bmi_lvl:Double =weight/(height*height);
            var result1:TextView = findViewById(R.id.resultText)

            if(bmi_lvl < 18.5){
                var result:TextView = findViewById(R.id.resultText2)
                result.text = "Under Weight";
            } else if(bmi_lvl>=18.5 && bmi_lvl <= 25){
                var result:TextView = findViewById(R.id.resultText2)
                result.text = "Healthy Weight";
            }else if(bmi_lvl>=25 && bmi_lvl <= 30){
                var result:TextView = findViewById(R.id.resultText2)
                result.text = "Over Weight";
            }else if(bmi_lvl>30){
                var result:TextView = findViewById(R.id.resultText2)
                result.text = "Obeese";
            }
        }
    }


}