package com.example.agenda.Recycler.Adapter.Adapter

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.agenda.Recycler.Adapter.Contact
import com.example.agenda.databinding.ItemPersonBinding

class ContactViewHolder (view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemPersonBinding.bind(view)
    fun render(persons: Contact){
        binding.tvId.text = persons.id
        binding.tvName.text = persons.Nombre
        binding.tvApellidos.text = persons.Apellidos
        binding.tvEmail.text = persons.Email
        binding.tvTelefono.text = persons.Telefono

    }
}