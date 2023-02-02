package uz.data.phoneapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import uz.data.phoneapp.adapter.PhoneAdapter
import uz.data.phoneapp.databinding.ActivityPhonesBinding
import uz.data.phoneapp.model.Phone
import uz.data.phoneapp.repository.PhonesRepository

class PhonesActivity : AppCompatActivity() {
    lateinit var phones: ArrayList<Phone>
    lateinit var repository: PhonesRepository
    lateinit var binding: ActivityPhonesBinding
    lateinit var adapter:PhoneAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhonesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        repository = PhonesRepository(application)
        loadPhones()
        adapter = PhoneAdapter(phones)
        binding.apply {
            rvPhones.adapter = adapter
            rvPhones.layoutManager = GridLayoutManager(this@PhonesActivity, 1)
        }
        adapter.itemClickListener = {
            val intent = Intent(this@PhonesActivity, DetailActivity::class.java)
            intent.putExtra("phone", it)
            startActivity(intent)
        }
        adapter.itemLongClickListener = {
            showConfirmDialog(it)
        }

    }

    private fun showConfirmDialog(phone: Phone) {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Confirm delete")
        alertDialog.setMessage("Are you sure?")
        alertDialog.setPositiveButton("Yes") { dialog, which ->
            repository.deletePhone(phone)
            loadPhones()
            adapter.submitList(phones)
            dialog.cancel()
        }
        alertDialog.setNegativeButton("Cancel") { dialog, which ->
            dialog?.cancel()
        }
        alertDialog.show()
    }


    private fun loadPhones() {
        phones = repository.loadPhones() as ArrayList<Phone>
    }
}