package com.example.agenda

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.agenda.databinding.FragmentListaBinding
import com.example.agenda.databinding.FragmentNewContactBinding


class NewContactFragment : Fragment() {
    private var _binding: FragmentNewContactBinding? = null
    private val binding get() = _binding!!
    private lateinit var friendsDBHelper : mySQLiteHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewContactBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        friendsDBHelper = mySQLiteHelper(this.requireContext())
        binding.btnAAdir.setOnClickListener {
            if (binding.etNombre.text.isNotBlank() &&
                binding.etApellidos.text.isNotBlank() &&
                binding.etEmail.text.isNotBlank()&&
                    binding.etTelefono.text.isNotBlank()){
                friendsDBHelper.updateData(binding.etNombre.text.toString().toInt(),
                    binding.etApellidos.text.toString(),
                    binding.etEmail.text.toString(),
                    binding.etTelefono.text.toString())
                binding.etNombre.text.clear()
                binding.etApellidos.text.clear()
                binding.etEmail.text.clear()
                binding.etTelefono.text.clear()

                toast("¡Modificado!")

            } else {
                toast("No permitido campos vacíos", Toast.LENGTH_LONG)
            }
        }
    }

}


