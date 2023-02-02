package uz.data.phoneapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.data.phoneapp.databinding.ActivityAddPhoneBinding
import uz.data.phoneapp.model.Phone
import uz.data.phoneapp.repository.PhonesRepository

class AddPhoneActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddPhoneBinding
    lateinit var repository: PhonesRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPhoneBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        repository = PhonesRepository(application)
        binding.apply {
            bAdd.setOnClickListener {
                val name = etName.text.toString()
                val feature = etFeature.text.toString()
                val phone = Phone(name = name, description = feature)
                repository.savePhone(phone)
                finish()
            }
        }
    }
}