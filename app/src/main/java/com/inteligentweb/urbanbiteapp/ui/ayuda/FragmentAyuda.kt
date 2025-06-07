package com.inteligentweb.urbanbiteapp.ui.ayuda

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.inteligentweb.urbanbiteapp.R
import com.inteligentweb.urbanbiteapp.databinding.FragmentAyudaBinding



class FragmentAyuda : Fragment() {

    private var _binding: FragmentAyudaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val ayudaViewModel =
            ViewModelProvider(this).get(FragmentAyudaViewModel::class.java)

        _binding = FragmentAyudaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textAyuda
        ayudaViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}