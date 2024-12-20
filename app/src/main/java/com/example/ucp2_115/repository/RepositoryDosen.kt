package com.example.ucp2_115.repository

import com.example.ucp2_115.Data.entity.Dosen
import kotlinx.coroutines.flow.Flow

interface RepositoryDosen {
    suspend fun insertDosen(dosen: Dosen)
    //getAllDosen
    fun getAllDsn(): Flow<List<Dosen>>
    //getDosen
    fun getDosen(nidn: String): Flow<Dosen>
}