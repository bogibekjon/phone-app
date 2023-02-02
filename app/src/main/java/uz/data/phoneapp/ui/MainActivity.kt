package uz.data.phoneapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.data.phoneapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        binding.apply {
            bPhones.setOnClickListener {
                val intent = Intent(this@MainActivity, PhonesActivity::class.java)
                startActivity(intent)
            }
            bAddPhone.setOnClickListener {
                val intent=Intent(this@MainActivity,AddPhoneActivity::class.java)
                startActivity(intent)
            }
        }
    }
}