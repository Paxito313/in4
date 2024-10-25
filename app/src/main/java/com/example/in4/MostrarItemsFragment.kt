package com.example.in4.ui.mostraritems

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.in4.databinding.FragmentMostrarItemsBinding
import com.example.in4.viewmodel.RealEstateViewModel
import com.example.in4.viewmodel.RealEstateViewModelFactory

class MostrarItemsFragment : Fragment() {

    private var _binding: FragmentMostrarItemsBinding? = null
    private val binding get() = _binding!!
    private val realEstateViewModel: RealEstateViewModel by viewModels {
        RealEstateViewModelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMostrarItemsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RealEstateAdapter()
        binding.recyclerViewItems.adapter = adapter
        binding.recyclerViewItems.layoutManager = LinearLayoutManager(context)

        realEstateViewModel.realEstateList.observe(viewLifecycleOwner) { items ->
            items?.let { adapter.submitList(it) }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
