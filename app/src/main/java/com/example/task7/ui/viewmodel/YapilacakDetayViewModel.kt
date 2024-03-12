package com.example.task7.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.task7.data.repo.YapilacaklarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class YapilacakDetayViewModel @Inject constructor(var yrepo: YapilacaklarRepository): ViewModel() {
    fun guncelle(yapilacakID: Int, yapilacakText: String) {
        CoroutineScope(Dispatchers.Main).launch {
            yrepo.guncelle(yapilacakID, yapilacakText)
        }
    }
}