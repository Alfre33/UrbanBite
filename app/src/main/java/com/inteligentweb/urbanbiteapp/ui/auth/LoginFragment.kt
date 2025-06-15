package com.inteligentweb.urbanbiteapp.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.inteligentweb.urbanbiteapp.R
import com.inteligentweb.urbanbiteapp.databinding.LoginFragmentBinding


class LoginFragment : Fragment() {

    // ViewBinding
    private var _binding: LoginFragmentBinding? = null
    private val binding get() = _binding!!

    // Si en el futuro necesitas lógica, déjalo; si no, puedes eliminarlo
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LoginFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navegar de Login → Register
        binding.tvRegisterLink.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_register)
        }

        // Ejemplo: en Forgot password podrías navegar a un diálogo o fragment
        binding.tvForgot.setOnClickListener {
            // findNavController().navigate(R.id.action_login_to_forgot)
        }

        // Aquí iría la llamada real a FirebaseAuth:
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val pass  = binding.etPassword.text.toString().trim()
            // viewModel.login(email, pass)  … o directamente:
            // FirebaseAuth.getInstance().signInWithEmailAndPassword(email, pass)…
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
