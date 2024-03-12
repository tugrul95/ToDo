package com.example.task7.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.task7.data.entity.Yapilacaklar

@Dao
interface YapilacaklarDao {
    @Query("SELECT * FROM toDos")
    suspend fun yapilacaklariYukle(): List<Yapilacaklar>

    @Insert
    suspend fun kaydet(yapilacak: Yapilacaklar)

    @Update
    suspend fun guncelle(yapilacak: Yapilacaklar)

    @Delete
    suspend fun sil(yapilacak: Yapilacaklar)

    @Query("SELECT * FROM toDos WHERE name like '%' || :aramaKelimesi || '%' ")
    suspend fun ara(aramaKelimesi: String): List<Yapilacaklar>
}