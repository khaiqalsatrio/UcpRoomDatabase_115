package com.example.ucp2_115.Data.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.ucp2_115.Data.entity.MataKuliah
import kotlinx.coroutines.flow.Flow

@Dao
interface MatakuliahDao {

    @Insert
    suspend fun insertMatakuliah(
        mataKuliah: MataKuliah
    )

    @Query("SELECT * FROM matakuliah ORDER BY nama ASC")
    fun getAllMataKuliah(): Flow<List<MataKuliah>>

    @Query("SELECT * FROM matakuliah WHERE kode = :kode")
    fun getMataKuliah(kode: String): Flow<MataKuliah>

    @Delete
    suspend fun deleteMataKuliah(mataKuliah: MataKuliah)

    @Update
    suspend fun updateMataKuliah(mataKuliah: MataKuliah)
}