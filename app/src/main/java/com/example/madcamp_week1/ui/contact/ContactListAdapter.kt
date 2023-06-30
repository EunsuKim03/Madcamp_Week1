package com.example.madcamp_week1.ui.contact

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.madcamp_week1.R
import com.example.madcamp_week1.db.ContactData

class ContactListAdapter(private var list: MutableList<ContactData>): RecyclerView.Adapter<ContactListAdapter.ListItemViewHolder> () {
    inner class ListItemViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView!!) {
        private val context = itemView!!.context

        var tv_name: TextView = itemView!!.findViewById(R.id.tv_contactName)
        var tv_phoneNum: TextView = itemView!!.findViewById(R.id.tv_contactPhone)

        fun bind(item: ContactData, position: Int) {
            tv_name.text = item.name
            tv_phoneNum.text = item.phoneNumber

            itemView.setOnClickListener {

                Intent(context, ContactDetailActivity::class.java).apply {
                    putExtra("contactData", item)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { context.startActivity(this) }
            }
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