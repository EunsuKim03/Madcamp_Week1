package com.example.madcamp_week1.ui.reservation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.madcamp_week1.R
import com.example.madcamp_week1.db.ReservationData

class ReservationListAdapter(private var list: MutableList<ReservationData>): RecyclerView.Adapter<ReservationListAdapter.ListItemViewHolder>() {
    inner class ListItemViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView!!) {
        private val context = itemView!!.context

        var iv_restaurant : ImageView = itemView!!.findViewById(R.id.iv_restaurant)
        var tv_restaurant_name : TextView = itemView!!.findViewById(R.id.tv_restaurant_name)
        var ll_friends_list : LinearLayout = itemView!!.findViewById(R.id.ll_friends_list)

        fun bind(item: ReservationData, position: Int) {
            if(item.contacts.size >= 4) {
                for(i: Int in 0 .. 1) {
                    val textView: TextView = TextView(context)
                    textView.setText(item.contacts[i].name)
                    textView.textSize = 12f
                    textView.id = i

                    val param : LinearLayout.LayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                    param.marginStart = 8
                    param.marginEnd = 8

                    textView.layoutParams = param
                    ll_friends_list.addView(textView)
                }
                val textView: TextView = TextView(context)
                textView.setText("외 ${item.contacts.size - 2} 명")
                textView.textSize = 12f

                val param : LinearLayout.LayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                param.marginStart = 8
                param.marginEnd = 8

                textView.layoutParams = param
                ll_friends_list.addView(textView)
            } else {
                for(i: Int in 0 until item.contacts.size) {
                    val textView: TextView = TextView(context)
                    textView.setText(item.contacts[i].name)
                    textView.textSize = 12f
                    textView.id = i

                    val param : LinearLayout.LayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                    param.marginStart = 8
                    param.marginEnd = 8

                    textView.layoutParams = param
                    ll_friends_list.addView(textView)
                }
            }

            iv_restaurant.setImageResource(context.resources.getIdentifier(item.restaurant.photoName, "drawable", context.packageName))
            tv_restaurant_name.text = item.restaurant.name

            // click event listener for detailed reservation page here
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