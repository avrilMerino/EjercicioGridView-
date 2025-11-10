package com.example.ejerciciogridview

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityModulos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modulos)

        // 1) Referencias
        val root = findViewById<LinearLayout>(R.id.rootModulos)
        val img = findViewById<ImageView>(R.id.imgAlumno)
        val tTitulo = findViewById<TextView>(R.id.txtTitulo)
        val tMods = findViewById<TextView>(R.id.txtModulos)
        val btn = findViewById<Button>(R.id.btnVolver)

        // 2) Recibir extras del Intent
        val nombre = intent.getStringExtra("nombre") ?: ""
        val apellidos = intent.getStringExtra("apellidos") ?: ""
        val sexo = (intent.getStringExtra("sexo") ?: "H").uppercase()
        val ciclo = (intent.getStringExtra("ciclo") ?: "ASIR").uppercase()

        // 3) Avatar según sexo (usa tus drawables hombre/mujer)
        img.setImageResource(if (sexo == "M") R.drawable.mujer else R.drawable.hombre)

        // 4) Fondo según ciclo (colores del enunciado)
        when (ciclo) {
            "ASIR" -> root.setBackgroundColor(Color.parseColor("#b675ff"))
            "DAW"  -> root.setBackgroundColor(Color.parseColor("#ff5436"))
            "DAM"  -> root.setBackgroundColor(Color.parseColor("#c1ff65"))
        }

        // 5) Título con nombre completo + ciclo
        tTitulo.text = "$nombre $apellidos — $ciclo"

        // 6) Módulos distintos por ciclo
        val modulos = when (ciclo) {
            "ASIR" -> listOf("Implantación de SO", "Administración de Redes", "Seguridad")
            "DAW"  -> listOf("Programación", "Entornos de Desarrollo", "Despliegue Web")
            else   -> listOf("Programación", "Acceso a Datos", "Interfaces", "Servicios y Procesos")
        }
        tMods.text = modulos.joinToString("\n• ", prefix = "• ")

        // 7) Botón volver: cierra esta Activity y regresa a la anterior
        btn.setOnClickListener { finish() }
    }
}
