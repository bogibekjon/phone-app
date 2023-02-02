package uz.data.phoneapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.data.phoneapp.databinding.ActivityDetailBinding
import uz.data.phoneapp.model.Phone

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        val phone = intent.getSerializableExtra("phone") as Phone
        binding.apply {
            tvName.text = phone.name
            tvPhoneAbout.text = phone.description
            ivBack.setOnClickListener {
                finish()
            }
        }
    }
}