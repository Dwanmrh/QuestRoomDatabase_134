package com.dwan.roomdatabase.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dwan.roomdatabase.data.dao.MahasiswaDao
import com.dwan.roomdatabase.data.entity.Mahasiswa

// Database Room
@Database(entities = [Mahasiswa::class], version = 1, exportSchema = false) // Menggunakan entitas tabel Mahasiswa
abstract class KrsDatabase: RoomDatabase() { // Kelas turunan dari RoomDatabase

    // Mendefinisikan fungsi untuk mengakses data Mahasiswa
    abstract fun mahasiswaDao(): MahasiswaDao

    companion object {
        @Volatile // Mendefinisikan bahwa nilai variabel Instance selalu sama di semua thread
        private var Instance: KrsDatabase? = null // Menyimpan satu2 nya instance database yang digunakan

        fun getDatabase(context: Context): KrsDatabase { // Membuat / mendapatkan instance database room
            return (Instance ?: synchronized(this) { // Mengecek apakah instance sudah dibuat sebelumnya
                Room.databaseBuilder( // Fungsi untuk membuat database room
                    context,
                    KrsDatabase::class.java, // Class Database
                    name = "KrsDatabase" // Nama database
                )
                    .build().also { Instance = it } // Membuat database baru dan menyimpan ke instance
            })
        }
    }
}