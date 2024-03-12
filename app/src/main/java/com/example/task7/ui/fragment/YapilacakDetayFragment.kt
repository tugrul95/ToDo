package com.example.task7.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.task7.R
import com.example.task7.databinding.FragmentYapilacakDetayBinding
import com.example.task7.ui.viewmodel.YapilacakDetayViewModel
import com.google.android.material.internal.ViewUtils
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class YapilacakDetayFragment : Fragment() {
    private lateinit var binding: FragmentYapilacakDetayBinding
    private lateinit var viewModel: YapilacakDetayViewModel
    @SuppressLint("RestrictedApi")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentYapilacakDetayBinding.inflate(inflater, container, false)

        val bundle: YapilacakDetayFragmentArgs by navArgs()
        val gelenYapilacak = bundle.yapilacak

        binding.editTextYapilacak.setText(gelenYapilacak.yapilacakText)

        binding.buttonGuncelle.setOnClickListener {
            val yapilacakText = binding.editTextYapilacak.text.toString()
            guncelle(gelenYapilacak.yapilacakID, yapilacakText)
            ViewUtils.hideKeyboard(it)
            Snackbar.make(it, "Yapılacak notu güncellendi.", Snackbar.LENGTH_SHORT)
                .setBackgroundTint(ContextCompat.getColor(requireContext(), R.color.favColor))
                .setActionTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                .setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                .show()
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: YapilacakDetayViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun guncelle(yapilacakID: Int, yapilacakText: String) {
        viewModel.guncelle(yapilacakID,yapilacakText)
    }

}