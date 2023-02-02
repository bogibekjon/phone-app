package uz.data.phoneapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import uz.data.phoneapp.R
import uz.data.phoneapp.model.Phone

class PhoneAdapter(val phones: ArrayList<Phone>) :
    RecyclerView.Adapter<PhoneAdapter.PhoneViewHolder>() {


    var itemClickListener: ((Phone) -> Unit)? = null
    var itemLongClickListener: ((Phone) -> Unit)? = null

    fun submitList(list: ArrayList<Phone>) {
        phones.clear()
        phones.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_phone, parent, false)
        return PhoneViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
        val phone = phones[position]

        holder.tvPhoneName.text = phone.name

        holder.cvItem.setOnClickListener {
            itemClickListener?.invoke(phone)
        }

        holder.cvItem.setOnLongClickListener {
            itemLongClickListener?.invoke(phone)
            true
        }


    }

    override fun getItemCount(): Int {
        return phones.size
    }

    class PhoneViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvPhoneName = view.findViewById<TextView>(R.id.tvPhoneName)
        val cvItem = view.findViewById<CardView>(R.id.cv_item)
    }
}