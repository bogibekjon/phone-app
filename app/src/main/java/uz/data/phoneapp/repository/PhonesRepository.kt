package uz.data.phoneapp.repository

import android.app.Application
import uz.data.phoneapp.data.local.PhoneDao
import uz.data.phoneapp.data.local.PhonesDatabase
import uz.data.phoneapp.model.Phone

class PhonesRepository {

    lateinit var phoneDao: PhoneDao

    constructor(application: Application) {
        val db = PhonesDatabase.getInstance(application)
        phoneDao = db.getPhoneDao()
    }

    fun savePhone(phone: Phone) {
        phoneDao.savePhone(phone)
    }

    fun loadPhones() = phoneDao.getAllPhones()

    fun getPhoneById(id: Long) = phoneDao.getPhoneById(id)

    fun deletePhone(phone: Phone){
        phoneDao.deletePhone(phone)
    }

}