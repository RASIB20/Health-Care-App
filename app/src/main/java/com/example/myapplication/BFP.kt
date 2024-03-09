package com.example.myapplication
import kotlin.math.log10
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text

class BFP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bfp)

         var height: Double = 0.0
        var waist: Double = 0.0
        var neck: Double = 0.0
        var gender: String = ""
        var heightScale: String = ""
        var waistScale: String = ""
        var neckScale: String = ""

        val submitButton: Button = findViewById(R.id.submit)
        val heightString: TextInputEditText = findViewById(R.id.height_input)
        val waistString: TextInputEditText = findViewById(R.id.waist_input)
        val neckString: TextInputEditText = findViewById(R.id.neck_input)

        val radioGroup1: RadioGroup = findViewById(R.id.gender)
        val radioGroup2: RadioGroup = findViewById(R.id.heightScale)
        val radioGroup3: RadioGroup = findViewById(R.id.waistScale)
        val radioGroup4: RadioGroup = findViewById(R.id.neckScale)

        radioGroup1.setOnCheckedChangeListener { _, checkedId ->
            gender = findViewById<RadioButton>(checkedId).text.toString()
        }

        radioGroup2.setOnCheckedChangeListener { _, checkedId ->
            heightScale = findViewById<RadioButton>(checkedId).text.toString()
        }

        radioGroup3.setOnCheckedChangeListener { _, checkedId ->
            waistScale = findViewById<RadioButton>(checkedId).text.toString()
        }

        radioGroup4.setOnCheckedChangeListener { _, checkedId ->
            neckScale = findViewById<RadioButton>(checkedId).text.toString()
        }

        submitButton.setOnClickListener {
            if (heightString.text.isNullOrEmpty() || waistString.text.isNullOrEmpty() || neckString.text.isNullOrEmpty() ||
                gender.isEmpty() || heightScale.isEmpty() || waistScale.isEmpty() || neckScale.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }

            if(heightScale == "Cm"){
                height = heightString.text.toString().toDouble()* 2.54
            }else{
                height = heightString.text.toString().toDouble()
            }
            if(waistScale == "Cm"){
                waist = waistString.text.toString().toDouble()* 2.54
            }else{
                waist = waistString.text.toString().toDouble()
            }
            if(neckScale == "Cm"){
                neck = neckString.text.toString().toDouble()* 2.54
            }else{
                neck = neckString.text.toString().toDouble()
            }

            val result: TextView = findViewById(R.id.resultText)
            val result1: TextView = findViewById(R.id.resultText2)
            result.visibility =View.VISIBLE
            result1.visibility = View.VISIBLE

            if (gender == "Male") {
                val finalValue: Double = 86.010 * log10(waist + neck) - 70.041 * log10(height) + 36.76
                val valueFormatted = String.format("%.2f", finalValue)
                result1.text = valueFormatted
            } else if (gender == "Female") {
                val finalValue: Double = 163.205 * log10(waist - neck) - 97.684 * log10(height) + 78.387
                val valueFormatted = String.format("%.2f", finalValue)
                result1.text = valueFormatted
            } else {
                Toast.makeText(this, "Please select gender", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
