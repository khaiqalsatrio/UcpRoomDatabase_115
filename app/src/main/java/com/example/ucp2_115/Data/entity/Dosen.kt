package com.example.ucp2_115.Data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dosen")
data class Dosen(
    @PrimaryKey
    val nidn: String,
    val nama: String,
    val jenisKelamin: String,
)
