package com.example.task7.data.repo

import com.example.task7.data.datasource.YapilacaklarDataSource
import com.example.task7.data.entity.Yapilacaklar

class YapilacaklarRepository(var yds: YapilacaklarDataSource) {
    suspend fun kaydet(yapilacakText: String) = yds.kaydet(yapilacakText)
    suspend fun guncelle(yapilacakID: Int, yapilacakText: String) = yds.guncelle(yapilacakID, yapilacakText)
    suspend fun sil(yapilacakID: Int) = yds.sil(yapilacakID)
    suspend fun yapilacaklariYukle(): List<Yapilacaklar> = yds.yapilacaklariYukle()
    suspend fun ara(aramaKelimesi: String): List<Yapilacaklar> = yds.ara(aramaKelimesi)
}