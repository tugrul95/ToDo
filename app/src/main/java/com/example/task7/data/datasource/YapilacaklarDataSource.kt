package com.example.task7.data.datasource

import com.example.task7.data.entity.Yapilacaklar
import com.example.task7.room.YapilacaklarDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class YapilacaklarDataSource(var yapilacaklarDao: YapilacaklarDao) {
    suspend fun kaydet(yapilacakText: String) {
        val yeniYapilacak = Yapilacaklar(0,yapilacakText)
        yapilacaklarDao.kaydet(yeniYapilacak)
    }

    suspend fun guncelle(yapilacakID: Int, yapilacakText: String) {
        val guncellenenYapilacak = Yapilacaklar(yapilacakID, yapilacakText)
        yapilacaklarDao.guncelle(guncellenenYapilacak)
    }

    suspend fun sil(yapilacakID: Int) {
        val silinenYapilacak = Yapilacaklar(yapilacakID,"")
        yapilacaklarDao.sil(silinenYapilacak)
    }

    suspend fun yapilacaklariYukle(): List<Yapilacaklar> = withContext(Dispatchers.IO){
        return@withContext yapilacaklarDao.yapilacaklariYukle()
    }

    suspend fun ara(aramaKelimesi: String): List<Yapilacaklar> = withContext(Dispatchers.IO){
        return@withContext yapilacaklarDao.ara(aramaKelimesi)
    }
}