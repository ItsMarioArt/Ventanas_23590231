package com.example.ventanas

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mensaje = findViewById<TextView>(R.id.nombreMessage)
        val botonRegresar = findViewById<Button>(R.id.botonRegresar)

        // Corrección: Recuperar el nombre con la clave correcta
        val nombre = intent.getStringExtra("nombre")

        // Mostrar el nombre en el TextView
        if (nombre != null) {
            mensaje.text = "¡Hola, $nombre!"
        } else {
            mensaje.text = "No se recibió ningún nombre"
        }

        // Conectar el botón con el método regresar
        botonRegresar.setOnClickListener {
            finish()
        }
    }

    fun regresar(view: View) {
        finish()
    }
}