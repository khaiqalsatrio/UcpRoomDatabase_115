package com.example.ucp2_115.Data.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.ucp2_115.Data.entity.Dosen
import kotlinx.coroutines.flow.Flow

@Dao
interface DosenDao {

    @Insert
    suspend fun insertDosen(
        dosen: Dosen
    )

    @Query("SELECT * FROM dosen ORDER BY nama ASC")
    fun getAllDosen(): Flow<List<Dosen>>

    @Query("SELECT * FROM dosen WHERE nidn = :nidn")
    fun getDosen(nidn: String): Flow<Dosen>

}