package com.example.madcamp_week1.ui.contact

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.madcamp_week1.R

class ContactListAdapter(private var list: MutableList<TestData>): RecyclerView.Adapter<ContactListAdapter.ListItemViewHolder> () {
    inner class ListItemViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView!!) {
        var tv_name: TextView = itemView!!.findViewById(R.id.tv_contactName)
        var tv_phoneNum: TextView = itemView!!.findViewById(R.id.tv_contactPhone)

        fun bind(data: TestData, position: Int) {
            tv_name.text = data.getName()
            tv_phoneNum.text = data.getPhoneNumber()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item_list, parent, false)
        return ListItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.bind(list[position], position)
    }
}