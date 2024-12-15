package com.dwan.roomdatabase.dependenciesinjection

import android.content.Context
import com.dwan.roomdatabase.data.database.KrsDatabase
import com.dwan.roomdatabase.repository.LocalRepositoryMhs
import com.dwan.roomdatabase.repository.RepositoryMhs

interface InterfaceContainerApp {
    val repositoryMhs: RepositoryMhs // Mengelola data mahasiswa
}

class ContainerApp(private val context: Context) : InterfaceContainerApp {
    override val repositoryMhs: RepositoryMhs by lazy {
        LocalRepositoryMhs(KrsDatabase.getDatabase(context).mahasiswaDao())
    }
}