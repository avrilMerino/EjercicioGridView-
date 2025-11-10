package com.example.ejerciciogridview
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class PersonasAdapter(
    private val ctx: Context,
    private val personas: List<Persona>
) : BaseAdapter() {

    override fun getCount() = personas.size          // cuántos ítems hay
    override fun getItem(position: Int) = personas[position] // ítem por posición
    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // 1) Reusar vista si existe (scroll más eficiente) o inflar una nueva
        val view = convertView ?: LayoutInflater.from(ctx)
            .inflate(R.layout.item_persona, parent, false)

        // 2) Obtener el modelo a pintar
        val p = getItem(position)

        // 3) Referencias a vistas del item y asignarles datos
        val img = view.findViewById<ImageView>(R.id.imgAvatar)
        val tNombre = view.findViewById<TextView>(R.id.txtNombre)
        val tApellidos = view.findViewById<TextView>(R.id.txtApellidos)
        val tCiclo = view.findViewById<TextView>(R.id.txtCiclo)

        // 4) Lógica de avatar según sexo
        img.setImageResource(if (p.sexo.equals("M", true)) R.drawable.mujer else R.drawable.hombre)

        // 5) Texto de las vistas
        tNombre.text = p.nombre
        tApellidos.text = p.apellidos
        tCiclo.text = p.ciclo

        // 6) Devolver la vista que el GridView dibujará en esa celda
        return view
    }
}