package com.example.ucp2_115.Data.repository

import com.example.ucp2_115.Data.Dao.MatakuliahDao
import com.example.ucp2_115.Data.entity.Matakuliah
import kotlinx.coroutines.flow.Flow

class LocalRepositoryMatakuliah(
    private val matakuliahDao: MatakuliahDao
) : RepositoryMatakuliah {
    override suspend fun insertMtk(matakuliah: Matakuliah) {
        matakuliahDao.insertMatakuliah(matakuliah)
    }

    override fun getAllMtk(): Flow<List<Matakuliah>> {
        return matakuliahDao.getAllMtk()
    }

    override fun getMatakuliah(kode: String): Flow<Matakuliah> {
        return matakuliahDao.getMatakuliah(kode)
    }

    override suspend fun deleteMtk(matakuliah: Matakuliah) {
        matakuliahDao.deleteMatakuliah(matakuliah)
    }

    override suspend fun updateMtk(matakuliah: Matakuliah) {
        matakuliahDao.updateMatakuliah(matakuliah)
    }
}