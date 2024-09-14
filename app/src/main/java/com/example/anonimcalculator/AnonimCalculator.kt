package com.example.anonimcalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AnonimCalculator : AppCompatActivity() {

    private lateinit var numA: EditText
    private lateinit var numB: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.anonim_calculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        numA = findViewById(R.id.numA)
        numB = findViewById(R.id.numB)

    }

    private fun returnActivity(number: Int) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("num", number.toString())
        setResult(RESULT_OK, intent)
        finish()
    }

    fun sumBTN(view: View) {
        returnActivity(numA.text.toString().toInt() + numB.text.toString().toInt())
    }

    fun diffBTN(view: View) {
        returnActivity(numA.text.toString().toInt() - numB.text.toString().toInt())
    }

    fun mulBTN(view: View) {
        returnActivity(numA.text.toString().toInt() * numB.text.toString().toInt())
    }

    fun divBTN(view: View) {
        returnActivity(numA.text.toString().toInt() / numB.text.toString().toInt())
    }
}