package com.example.ucp2_115.Data.Dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.ucp2_115.Data.entity.Dosen

@Dao
interface DosenDao {

    @Insert
    suspend fun insertDosen(
        dosen: Dosen
    )

}