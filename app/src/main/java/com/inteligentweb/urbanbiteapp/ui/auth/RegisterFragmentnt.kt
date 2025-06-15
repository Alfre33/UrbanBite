package com.inteligentweb.urbanbiteapp.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.inteligentweb.urbanbiteapp.R
import com.inteligentweb.urbanbiteapp.databinding.RegisterFragmentntBinding

class RegisterFragment : Fragment() {

    private var _binding: RegisterFragmentntBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RegisterFragmentntViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = RegisterFragmentntBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navegar de Register → Login
        binding.tvLoginLink.setOnClickListener {
            findNavController().navigate(R.id.action_register_to_login)
        }

        // Lógica de registro con FirebaseAuth:
        binding.btnRegister.setOnClickListener {
            val email = binding.etEmailReg.text.toString().trim()
            val pass  = binding.etPasswordReg.text.toString().trim()
            val confirm = binding.etConfirmReg.text.toString().trim()
            if (pass == confirm) {
                // FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, pass)…
            } else {
                // Mostrar error de contraseñas no coinciden
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
