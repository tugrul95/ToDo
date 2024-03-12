package com.example.task7.data.entity

import android.annotation.SuppressLint
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "toDos")
data class Yapilacaklar(@SuppressLint("KotlinNullnessAnnotation")
                        @PrimaryKey(autoGenerate = true)
                        @ColumnInfo(name = "id") @NotNull var yapilacakID: Int,
                        @SuppressLint("KotlinNullnessAnnotation")
                        @ColumnInfo(name = "name") @NotNull var yapilacakText: String
) : Serializable