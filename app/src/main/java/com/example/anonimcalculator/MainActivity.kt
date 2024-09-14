package com.example.anonimcalculator

import android.content.Intent
import android.os.Bundle
import android.text.style.BulletSpan
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var textTV: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textTV = findViewById(R.id.textTV)
        button = findViewById(R.id.button)

    }

    fun buttonClick(view: View) {
        val intent = Intent(this, AnonimCalculator::class.java)
        launchSomeActivity.launch(intent)
    }

    private val launchSomeActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val num = result.data!!.getStringExtra("num")
            textTV.text = num
            //Toast.makeText(this, "$num", Toast.LENGTH_LONG).show()
        }else
        {
            Toast.makeText(this, "Exeption", Toast.LENGTH_LONG).show()
        }
    }
}