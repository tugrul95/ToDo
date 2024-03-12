package com.example.task7.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.task7.data.entity.Yapilacaklar
import com.example.task7.room.YapilacaklarDao

@Database(entities = [Yapilacaklar::class], version=  1)
abstract class VeriTabani: RoomDatabase() {
    abstract fun getYapilacaklarDao(): YapilacaklarDao
}