package com.example.agenda

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agenda.Recycler.Adapter.Adapter.ContactAdapter
import com.example.agenda.Recycler.Adapter.ContactProvider
import com.example.agenda.databinding.FragmentListaBinding


class ListaFragment : Fragment() {
    private var _binding: FragmentListaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListaBinding.inflate(inflater, container,false)
            return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val manager = LinearLayoutManager(this.context)
            //Coloca cada item en una rejilla
            //val manager = GridLayoutManager(this, 2)
            val decoration = DividerItemDecoration(this.context, manager.orientation)
            binding.recycler.layoutManager = manager
            binding.recycler.addItemDecoration(decoration)
            binding.recycler.adapter = ContactAdapter(ContactProvider.personLista)


    }
}