package com.dwan.roomdatabase.repository

import com.dwan.roomdatabase.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

interface RepositoryMhs {
    suspend fun insertMhs(mahasiswa: Mahasiswa) // insertMhs

    // getAllMhs
    fun getAllMhs(): Flow<List<Mahasiswa>> // Mengembalikan data dalam list secara real-time

    // getMhs
    fun getMhs(nim: String): Flow<Mahasiswa> // Mengambil data mahasiswa berdasarkan NIM

    // deleteMhs
    suspend fun deleteMhs(mahasiswa: Mahasiswa)

    // updateMhs
    suspend fun updateMhs(mahasiswa: Mahasiswa)
}