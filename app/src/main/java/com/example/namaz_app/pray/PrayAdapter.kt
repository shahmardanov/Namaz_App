package com.alijan.demo.ui.pray

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alijan.demo.data.model.Namaz
import com.example.namaz_app.databinding.ItemPrayBinding

class PrayAdapter : RecyclerView.Adapter<PrayAdapter.PrayViewHolder>() {

    private val prayList = ArrayList<Namaz>()

    inner class PrayViewHolder(val itemPrayBinding: ItemPrayBinding) :
        RecyclerView.ViewHolder(itemPrayBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrayViewHolder {
        val view = ItemPrayBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PrayViewHolder(view)
    }

    override fun getItemCount(): Int = prayList.size

    override fun onBindViewHolder(holder: PrayViewHolder, position: Int) {
        val currentItem = prayList[position]
        holder.itemPrayBinding.item = currentItem

    }

    fun updateList(newList: List<Namaz>) {
        prayList.clear()
        prayList.addAll(newList)
        notifyDataSetChanged()
    }

}