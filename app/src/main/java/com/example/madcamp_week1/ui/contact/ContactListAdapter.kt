package com.example.madcamp_week1.ui.contact

import android.content.Intent
import android.net.Uri
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.madcamp_week1.R
import com.example.madcamp_week1.db.ContactData
import com.example.madcamp_week1.db.contactRoom.ContactEntity

//class ContactListAdapter(private var list: MutableList<ContactData>): RecyclerView.Adapter<ContactListAdapter.ListItemViewHolder> () {
class ContactListAdapter(private var list: MutableList<ContactEntity>): RecyclerView.Adapter<ContactListAdapter.ListItemViewHolder> () {
    inner class ListItemViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView!!) {
        private val context = itemView!!.context

        var tv_name: TextView = itemView!!.findViewById(R.id.tv_contactName)
        var tv_phoneNum: TextView = itemView!!.findViewById(R.id.tv_contactPhone)
        var iv_contactProfile: ImageView = itemView!!.findViewById(R.id.iv_contactProfile)

        fun bind(item: ContactEntity, position: Int) {
            tv_name.text = item.name
            tv_phoneNum.text = item.phoneNumber
            // if in drawable
            if(item.photoName == "") {
                iv_contactProfile.setImageResource(context.resources.getIdentifier("ic_contact_profile", "drawable", context.packageName))
            } else {
//                iv_contactProfile.setImageResource(context.resources.getIdentifier(item.photoName, "drawable", context.packageName))
                println("\n\n\nherehere: ${item.photoName}\n\n\n")
                Glide.with(context)
                    .load(Uri.parse(item.photoName))
                    .error(R.drawable.ic_contact_profile)
                    .into(iv_contactProfile)
            }

            itemView.setOnClickListener {
                Intent(context, ContactDetailActivity::class.java).apply {
//                    putExtra("contactData", item)
                    putExtra("name", item.name)
                    putExtra("photoName", item.photoName)
                    putExtra("phoneNumber", item.phoneNumber)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
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