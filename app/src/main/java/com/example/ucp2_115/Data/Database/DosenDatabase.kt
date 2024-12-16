import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ucp2_115.Data.Dao.DosenDao
import com.example.ucp2_115.Data.entity.Dosen
import com.example.ucp2_115.Data.entity.MataKuliah

@Database(entities = [Dosen::class], [MataKuliah::class], version = 1, exportSchema = false)
abstract class DosenDatabase : RoomDatabase() {

    abstract fun DosenDao(): DosenDao

    companion object {
        @Volatile
        private var instance: DosenDatabase? = null

        fun getDatabase(context: Context): DosenDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    DosenDatabase::class.java,
                    "DosenDatabse"
                )
                    .build()
                    .also { instance = it }
            }
        }
    }
}