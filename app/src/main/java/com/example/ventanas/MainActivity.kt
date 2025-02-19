package com.example.ventanas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var nom: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        nom = findViewById<EditText>(R.id.editTextNombre)
        btnclick()
    }

    fun btnclick() {
        val botonInicio = findViewById<Button>(R.id.botonInicio)
        botonInicio.setOnClickListener {
            val ventana2 = Intent(this, MainActivity2::class.java)
            ventana2.putExtra("nombre", nom.text.toString())
            startActivity(ventana2)
        }
    }
}