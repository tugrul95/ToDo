package com.example.task7.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.task7.data.entity.Yapilacaklar
import com.example.task7.data.repo.YapilacaklarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var yrepo: YapilacaklarRepository): ViewModel() {
    var yapilacaklarListesi = MutableLiveData<List<Yapilacaklar>>()

    init {
        yapilacaklariYukle()
    }

    fun sil(yapilacakID: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            yrepo.sil(yapilacakID)
            yapilacaklariYukle()
        }
    }

    fun yapilacaklariYukle() {
        CoroutineScope(Dispatchers.Main).launch {
            yapilacaklarListesi.value = yrepo.yapilacaklariYukle()
        }
    }

    fun ara(aramaKelimesi: String) {
        CoroutineScope(Dispatchers.Main).launch {
            yapilacaklarListesi.value = yrepo.ara(aramaKelimesi)
        }
    }
}