package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCal.setOnClickListener {
            calculateBmi()
        }


    }

    fun calculateBmi() {

        if(editTextHeight.text.isEmpty()) {
            editTextHeight.setError(getString(R.string.error))
           return
        }

        if(editTextWeight.text.isBlank()) {
            editTextWeight.setError(getString(R.string.error))
            return
        }

        val cal_weight : Float = editTextWeight.text.toString().toFloat()
        val cal_heigh : Float = editTextHeight.text.toString().toFloat()

        val cal_bmi = cal_weight / cal_heigh.pow(2)

        bmiText.text = getString(R.string.bmi) + "${cal_bmi}"

            if (cal_bmi < 18.5) {
                imageButton.setImageResource(R.drawable.under)
                statusText.text = getString(R.string.status) + getString(R.string.underweight)
            } else if (cal_bmi > 18.5 && cal_bmi < 24.9) {
                imageButton.setImageResource(R.drawable.normal)
                statusText.text = getString(R.string.status) + getString(R.string.normal)
            } else if (cal_bmi > 25) {
                imageButton.setImageResource(R.drawable.over)
                statusText.text = getString(R.string.status) + getString(R.string.overweight)
            }

    }

    fun resetOutput(view: View){
        editTextWeight.text.clear()
        editTextHeight.text.clear()

    }

}
