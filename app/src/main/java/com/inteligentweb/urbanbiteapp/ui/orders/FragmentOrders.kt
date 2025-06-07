package com.inteligentweb.urbanbiteapp.ui.orders

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
import com.inteligentweb.urbanbiteapp.databinding.FragmentConfiguracionBinding
import com.inteligentweb.urbanbiteapp.databinding.FragmentOrdersBinding
import com.inteligentweb.urbanbiteapp.ui.ayuda.FragmentAyudaViewModel
import com.inteligentweb.urbanbiteapp.ui.configuracion.FragmentConfiguracionViewModel

class FragmentOrders : Fragment() {
    private var _binding: FragmentOrdersBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val ordersViewModel =
            ViewModelProvider(this).get(FragmentOrdersViewModel::class.java)

        _binding = FragmentOrdersBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textOrders
        ordersViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}