package com.dwan.roomdatabase.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.dwan.roomdatabase.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

@Dao // Data Access Object
interface MahasiswaDao { // Akses ke tabel Mahasiswa di database

    // fungsi get all data
    @Query("SELECT * FROM mahasiswa")
    fun getAllMahasiswa(): Flow<List<Mahasiswa>> // Data diperbarui secara real-time

    // get Mahasiswa
    @Query("SELECT * FROM mahasiswa WHERE nim = :nim")
    fun getMahasiswa(nim: String): Flow<Mahasiswa> // Data diambil berdasarkan NIM

    // Delete Mahasiswa
    @Delete
    suspend fun deleteMahasiswa(mahasiswa: Mahasiswa) // Suspend digunakan dengan coroutine

    // Update Mahasiswa
    @Update
    suspend fun updateMahasiswa(mahasiswa: Mahasiswa) // Memperbarui data di tabel

    @Insert
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)
}
