package com.example.agenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agenda.Recycler.Adapter.Adapter.ContactAdapter
import com.example.agenda.Recycler.Adapter.ContactProvider
import com.example.agenda.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.opLista -> {
                    Navigation.findNavController(binding.navigationView)
                        .navigate(R.id.listaFragment)
                    true
                }
                R.id.opNewContacto -> {
                    Navigation.findNavController(binding.navigationView)
                        .navigate(R.id.newContactFragment)
                    true
                }
                R.id.opUpdate -> {
                    Navigation.findNavController(binding.navigationView)
                        .navigate(R.id.updateFragment)
                    true
                }
                R.id.opDelete->{
                    Navigation.findNavController(binding.navigationView)
                        .navigate(R.id.deleteFragment)
                    true
                }
                else -> false
            }
        }
    }


}