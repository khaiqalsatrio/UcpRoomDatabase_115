package com.example.ucp2_115.Data.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ucp2_115.Data.Dao.DosenDao
import com.example.ucp2_115.Data.Dao.MatakuliahDao
import com.example.ucp2_115.Data.entity.Dosen
import com.example.ucp2_115.Data.entity.Matakuliah

@Database(entities = [Dosen::class, Matakuliah::class], version = 1, exportSchema = false)
abstract class KrsDatabase : RoomDatabase() {

    abstract fun dosenDao() : DosenDao
    abstract fun matakuliah() : MatakuliahDao

    companion object {
        @Volatile
        private var Instance : KrsDatabase? = null

        fun getDatabase(context: Context): KrsDatabase {
            return (Instance ?: synchronized(this){
                Room.databaseBuilder(
                    context,
                    KrsDatabase::class.java,
                    "KrsDatabase",
                )
                    .build().also { Instance }
            })
        }
    }
}