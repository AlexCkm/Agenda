package com.example.agenda.Recycler.Adapter.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agenda.R
import com.example.agenda.Recycler.Adapter.Contact

class ContactAdapter(private val personLista: List<Contact>) : RecyclerView.Adapter<ContactViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        // En vez de tener que recojer el contexto como parámetro lo puedo
        // coger de cualquiera de las vistas del layout
        val layoutInflater = LayoutInflater.from(parent.context)
        return ContactViewHolder(layoutInflater.inflate(R.layout.item_person, parent, false))
    }
    //Va a pasar por cada uno de lo item y va a llamar a la función render()
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val item = personLista[position]
        holder.render(item)
    }

    //Devuelve el tamaño de la lista
    override fun getItemCount(): Int = personLista.size
}
