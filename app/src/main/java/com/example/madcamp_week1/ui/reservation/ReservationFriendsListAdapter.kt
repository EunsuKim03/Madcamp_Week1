package com.example.madcamp_week1.ui.reservation

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.madcamp_week1.R
import com.example.madcamp_week1.db.ContactData
import com.example.madcamp_week1.ui.contact.ContactDetailActivity

class ReservationFriendsListAdapter(private var list: MutableList<ContactData>): RecyclerView.Adapter<ReservationFriendsListAdapter.ListItemViewHolder>() {
    inner class ListItemViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView!!) {
        private val context = itemView!!.context

        var tv_rsv_detail_friend_name: TextView = itemView!!.findViewById(R.id.tv_rsv_detail_friend_name)
        var tv_rsv_detail_friend_phone: TextView = itemView!!.findViewById(R.id.tv_rsv_detail_friend_phone)

        fun bind(item: ContactData, position: Int) {
            tv_rsv_detail_friend_name.text = item.name
            tv_rsv_detail_friend_phone.text = item.phoneNumber

            itemView.setOnClickListener {
                Intent(context, ContactDetailActivity::class.java).apply {
                    putExtra("contactData", item)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { context.startActivity(this) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.reservation_detail_friends_item_list, parent, false)
        return ListItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.bind(list[position], position)
    }
}