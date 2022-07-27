package com.example.agenda

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import com.example.agenda.databinding.FragmentListaBinding
import com.example.agenda.databinding.FragmentUpdateBinding


class UpdateFragment : Fragment() {
    private var _binding: FragmentUpdateBinding? = null
    private val binding get() = _binding!!
    private lateinit var friendsDBHelper : mySQLiteHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUpdateBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        friendsDBHelper = mySQLiteHelper(this.requireContext())
        binding.btnUpdate.setOnClickListener {
            if (binding.etID.text.isNotBlank() &&
                binding.etNombre.text.isNotBlank() &&
                binding.etApellidos.text.isNotBlank() &&
                binding.etEmail.text.isNotBlank()&&
                    binding.etTelefono.text.isNotBlank()){
                friendsDBHelper.updateData(
                    binding.etID.text.toString(),
                    binding.etNombre.text.toString(),
                    binding.etApellidos.text.toString(),
                    binding.etEmail.text.toString(),
                    binding.etTelefono.text.toString())
                binding.etID.text.clear()
                binding.etNombre.text.clear()
                binding.etApellidos.text.clear()
                binding.etEmail.text.clear()
                binding.etTelefono.text.clear()
//                hideKeyBoard()
                toast("¡Guardado!")

            } else {
                toast("No permitido campos vacíos", Toast.LENGTH_LONG)
            }
        }
    }
//    fun hideKeyBoard() {
//        val imm = getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
//        imm.hideSoftInputFromWindow(binding.constraint.windowToken, 0)
//    }
}