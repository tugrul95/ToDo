package com.example.task7.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.example.task7.R
import com.example.task7.databinding.FragmentYapilacakKayitBinding
import com.example.task7.ui.viewmodel.YapilacakKayitViewModel
import com.google.android.material.internal.ViewUtils.hideKeyboard
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class YapilacakKayitFragment : Fragment() {
    private lateinit var binding: FragmentYapilacakKayitBinding
    private lateinit var viewModel: YapilacakKayitViewModel
    @SuppressLint("RestrictedApi")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentYapilacakKayitBinding.inflate(inflater, container, false)

        binding.buttonKaydet.setOnClickListener {
            val yapilacakText = binding.editTextYapilacak.text.toString()
            kaydet(yapilacakText)
            hideKeyboard(it)
            Snackbar.make(it, "Not yapılacaklar listesine eklendi.", Snackbar.LENGTH_SHORT)
                .setBackgroundTint(ContextCompat.getColor(requireContext(), R.color.favColor))
                .setActionTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                .setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                .show()
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: YapilacakKayitViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun kaydet(yapilacakText: String) {
        viewModel.kaydet(yapilacakText)
    }

}