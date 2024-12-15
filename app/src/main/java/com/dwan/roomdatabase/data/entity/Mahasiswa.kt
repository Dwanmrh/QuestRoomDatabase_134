package com.dwan.roomdatabase.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mahasiswa") // Menandai kelas entitas database room
data class Mahasiswa(
    @PrimaryKey // Menandai kolom dari tabel database
    val nim: String,
    val nama: String,
    val alamat: String,
    val jenisKelamin: String,
    val kelas: String,
    val angkatan: String

)
