package com.example.ejerciciogridview
import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
    private lateinit var grid: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        grid = findViewById(R.id.gridView)

        val datos = listOf(
            Persona("Miguel",  "López Sánchez", "H", "ASIR"),
            Persona("Juan",    "Pérez Pérez",   "H", "DAW"),
            Persona("María",   "Martínez Fernández",   "M", "DAM"),
            Persona("Antonio", "González García",   "H", "DAM"),
            Persona("Ana",     "Díaz Torres",   "M", "ASIR")
        )

        grid.adapter = PersonasAdapter(this, datos)

        grid.onItemClickListener = AdapterView.OnItemClickListener { _, _, pos, _ ->
            val p = datos[pos]
            val intent = Intent(this, ActivityModulos::class.java).apply {
                putExtra("nombre", p.nombre)
                putExtra("apellidos", p.apellidos)
                putExtra("sexo", p.sexo)
                putExtra("ciclo", p.ciclo)
            }
            startActivity(intent)
        }
    }
}