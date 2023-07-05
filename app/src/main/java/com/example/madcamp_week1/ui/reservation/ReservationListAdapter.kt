package com.example.madcamp_week1.ui.reservation

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.madcamp_week1.R
import com.example.madcamp_week1.db.reservationRoom.ReservationEntity
import com.google.gson.Gson

//class ReservationListAdapter(private var list: MutableList<ReservationData>): RecyclerView.Adapter<ReservationListAdapter.ListItemViewHolder>() {
class ReservationListAdapter(private var list: MutableList<ReservationEntity>): RecyclerView.Adapter<ReservationListAdapter.ListItemViewHolder>() {
    inner class ListItemViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView!!) {
        private val context = itemView!!.context

        var iv_restaurant : ImageView = itemView!!.findViewById(R.id.iv_restaurant)
        var tv_restaurant_name : TextView = itemView!!.findViewById(R.id.tv_restaurant_name)
        var ll_friends_list : LinearLayout = itemView!!.findViewById(R.id.ll_friends_list)

        fun bind(item: ReservationEntity, position: Int) {
            if(item.friends!!.size >= 4) {
                for(i: Int in 0 .. 1) {
                    val textView = TextView(context)
                    textView.setText(item.friends[i].name)
                    textView.textSize = 12f
                    textView.setTextColor(Color.parseColor("#E45477"))
                    textView.setBackgroundResource(R.drawable.circular_dynamic)
                    textView.setPadding(16, 8, 16, 8)
                    textView.id = i

                    val param : LinearLayout.LayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                    param.marginStart = 4
                    param.marginEnd = 4

                    textView.layoutParams = param
                    ll_friends_list.addView(textView)
                }
                val textView: TextView = TextView(context)
                textView.setText("외 ${item.friends.size - 2} 명")
                textView.textSize = 12f
                textView.setTextColor(Color.parseColor("#E45477"))
                textView.setBackgroundResource(R.drawable.circular_dynamic)
                textView.setPadding(16, 8, 16, 8)

                val param : LinearLayout.LayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                param.marginStart = 8
                param.marginEnd = 8

                textView.layoutParams = param
                ll_friends_list.addView(textView)
            } else {
                for(i: Int in 0 until item.friends.size) {
                    val textView: TextView = TextView(context)
                    textView.setText(item.friends[i].name)
                    textView.textSize = 12f
                    textView.setTextColor(Color.parseColor("#E45477"))
                    textView.setBackgroundResource(R.drawable.circular_dynamic)
                    textView.setPadding(16, 8, 16, 8)
                    textView.id = i

                    val param : LinearLayout.LayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                    param.marginStart = 8
                    param.marginEnd = 8

                    textView.layoutParams = param
                    ll_friends_list.addView(textView)
                }
            }

//            iv_restaurant.setImageResource(context.resources.getIdentifier(item.restaurant!!.photoName, "drawable", context.packageName))
            Glide.with(context)
                .load(Uri.parse(item.restaurant!!.photoName))
                .centerCrop()
                .into(iv_restaurant)
            tv_restaurant_name.text = item.restaurant!!.name

            val customJson = Gson().toJson(item.friends)

            // click event listener for detailed reservation page here
            itemView.setOnClickListener {
                Intent(context, ReservationDetailActivity::class.java).apply {
                    putExtra("rsid", item.rsid)
                    putExtra("restaurantName", item.restaurant.name)
                    putExtra("restaurantPhoto", item.restaurant.photoName)
                    putExtra("restaurantPhone", item.restaurant.phoneNumber)
                    putExtra("restaurantAddress", item.restaurant.address)
                    putExtra("contacts", customJson)

                    putExtra("date", item.date)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { context.startActivity(this) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.reservation_item_list, parent, false)
        return ListItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.bind(list[position], position)
    }
}