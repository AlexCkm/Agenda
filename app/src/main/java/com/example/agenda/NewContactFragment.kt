package com.example.agenda

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.agenda.databinding.FragmentListaBinding
import com.example.agenda.databinding.FragmentNewContactBinding


class NewContactFragment : Fragment() {
    private var _binding: FragmentNewContactBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewContactBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }


}