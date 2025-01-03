package com.example.ucp2_115.dependenciesinjection

import android.content.Context
import com.example.ucp2_115.Data.Database.KrsDatabase
import com.example.ucp2_115.repository.LocalRepositoryDosen
import com.example.ucp2_115.repository.LocalRepositoryMatakuliah
import com.example.ucp2_115.repository.RepositoryDosen
import com.example.ucp2_115.repository.RepositoryMatakuliah

// Interface untuk Dependency Injection
interface InterfaceContainerApp {
    val repositoryDosen: RepositoryDosen
    val repositoryMatakuliah: RepositoryMatakuliah
}

// Implementasi InterfaceContainerApp
class ContainerApp(private val context: Context) : InterfaceContainerApp {

    // Inisialisasi RepositoryDosen menggunakan DAO yang relevan
    override val repositoryDosen: RepositoryDosen by lazy {
        LocalRepositoryDosen(KrsDatabase.getDatabase(context).dosenDao())
    }

    // Inisialisasi RepositoryMatakuliah menggunakan DAO yang relevan
    override val repositoryMatakuliah: RepositoryMatakuliah by lazy {
        LocalRepositoryMatakuliah(KrsDatabase.getDatabase(context).matakuliahDao())
    }
}

