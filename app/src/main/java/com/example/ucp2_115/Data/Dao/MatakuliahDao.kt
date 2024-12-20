package com.example.ucp2_115.Data.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.ucp2_115.Data.entity.Matakuliah
import kotlinx.coroutines.flow.Flow

@Dao
interface MatakuliahDao {

    @Insert
    suspend fun insertMatakuliah(
        mataKuliah: Matakuliah
    )

    @Query("SELECT * FROM matakuliah ORDER BY nama ASC")
    fun getAllMtk(): Flow<List<Matakuliah>>

    @Query("SELECT * FROM matakuliah WHERE kode = :kode")
    fun getMatakuliah(kode: String): Flow<Matakuliah>

    @Delete
    suspend fun deleteMatakuliah(matakuliah: Matakuliah)

    @Update
    suspend fun updateMatakuliah(matakuliah: Matakuliah)
}