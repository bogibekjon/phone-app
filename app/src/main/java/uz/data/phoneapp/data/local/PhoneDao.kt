package uz.data.phoneapp.data.local

import androidx.room.*
import uz.data.phoneapp.model.Phone

@Dao
interface PhoneDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePhone(phone: Phone)

    @Query("SELECT * FROM phones")
    fun getAllPhones(): List<Phone>

    @Query("SELECT * FROM phones WHERE id=:id")
    fun getPhoneById(id: Long): Phone

    @Delete
    fun deletePhone(phone: Phone)
}