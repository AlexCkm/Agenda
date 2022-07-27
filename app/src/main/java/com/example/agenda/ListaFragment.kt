package com.example.agenda

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agenda.Recycler.Adapter.Adapter.ContactAdapter
import com.example.agenda.Recycler.Adapter.Contact
import com.example.agenda.Recycler.Adapter.ContactProvider
import com.example.agenda.databinding.FragmentListaBinding


class ListaFragment : Fragment() {
    private var _binding: FragmentListaBinding? = null
    private val binding get() = _binding!!
    private lateinit var friendsDBHelper : mySQLiteHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListaBinding.inflate(inflater, container,false)
            return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        friendsDBHelper = mySQLiteHelper(requireContext())
        val manager = LinearLayoutManager(this.context)
            //Coloca cada item en una rejilla
            //val manager = GridLayoutManager(this, 2)
            val decoration = DividerItemDecoration(this.context, manager.orientation)
            binding.recycler.layoutManager = manager
            binding.recycler.addItemDecoration(decoration)
            binding.recycler.adapter = ContactAdapter(sqliteToList())
    }

    fun sqliteToList(): MutableList<Contact>{
        val lista = mutableListOf<Contact>()
        // Abro la base de datos en modo LECTURA
        val db : SQLiteDatabase = friendsDBHelper.readableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM friends", null)

        // Compruebo si hay algún registro
        if (cursor.moveToFirst()) {
            do {
                lista.add(
                    Contact(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                    )
                )
            } while (cursor.moveToNext())
        }
        cursor.close()
        return lista
    }
}