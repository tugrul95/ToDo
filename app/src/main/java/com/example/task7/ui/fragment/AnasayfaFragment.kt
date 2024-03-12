package com.example.task7.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task7.R
import com.example.task7.databinding.FragmentAnasayfaBinding
import com.example.task7.ui.adapter.YapilacaklarAdapter
import com.example.task7.ui.viewmodel.AnasayfaViewModel
import com.example.task7.utils.gecis
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.rv.layoutManager = LinearLayoutManager(requireContext())
        viewModel.yapilacaklarListesi.observe(viewLifecycleOwner) {
            val yapilacaklarAdapter = YapilacaklarAdapter(requireContext(), it, viewModel)
            binding.rv.adapter = yapilacaklarAdapter
        }

        binding.fab.setOnClickListener {
            Navigation.gecis(it, R.id.yapilacakKayitGecis)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                ara(query)
                return false
            }
        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun ara(aramaKelimesi: String) {
        viewModel.ara(aramaKelimesi)
    }

    override fun onResume() {
        super.onResume()
        viewModel.yapilacaklariYukle()
    }
}