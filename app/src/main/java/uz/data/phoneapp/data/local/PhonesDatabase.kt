package uz.data.phoneapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.data.phoneapp.model.Phone

@Database([Phone::class], version = 1)
abstract class PhonesDatabase : RoomDatabase() {

    abstract fun getPhoneDao(): PhoneDao

    companion object {
        private var DB_INSTANCE: PhonesDatabase? = null

        fun getInstance(context: Context): PhonesDatabase {
            if (DB_INSTANCE == null) {
                DB_INSTANCE =
                    Room.databaseBuilder(
                        context.applicationContext,
                        PhonesDatabase::class.java,
                        "telefonlar_bazasi")
                        .allowMainThreadQueries()
                        .build()
            }
            return DB_INSTANCE!!
        }
    }
}