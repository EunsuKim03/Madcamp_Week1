package com.example.madcamp_week1.ui.reservation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madcamp_week1.R
import com.example.madcamp_week1.db.reservationRoom.ReservationEntity
import com.google.android.material.card.MaterialCardView

//class ReservationCardListAdapter(private var list: MutableList<Pair<String, List<ReservationData>>>): RecyclerView.Adapter<ReservationCardListAdapter.ListItemViewHolder>() {
class ReservationCardListAdapter(private var list: MutableList<Pair<String, List<ReservationEntity>>>): RecyclerView.Adapter<ReservationCardListAdapter.ListItemViewHolder>() {
    inner class ListItemViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView!!) {
        private val context = itemView!!.context

        var tv_rsv_card_date: TextView = itemView!!.findViewById(R.id.tv_rsv_card_date)
        var mcv_rsv_card_container: MaterialCardView = itemView!!.findViewById(R.id.mcv_rsv_card_container)
        var ib_more_rsv_list: ImageButton = itemView!!.findViewById(R.id.ib_more_rsv_list)
        var rl_rsv_items_by_date: LinearLayout = itemView!!.findViewById(R.id.rl_rsv_items_by_date)
        var rcv_reservation_list: RecyclerView = itemView!!.findViewById(R.id.rcv_reservation_list)


        fun bind(item: Pair<String, List<ReservationEntity>>, position: Int) {
            var resDate = item.first
            val resarr = resDate.split("/")
            tv_rsv_card_date.text = "${resarr[0]}년 ${resarr[1].toInt()}월 ${resarr[2].toInt()}일"

            var arr = ArrayList<ReservationEntity>()

            item.second.forEach { arr.add(it) }

            rcv_reservation_list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            rcv_reservation_list.setHasFixedSize(true)
            rcv_reservation_list.addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
            rcv_reservation_list.adapter = ReservationListAdapter(arr)

            itemView.setOnClickListener {
                // another rcv + change arrow button
                if(rl_rsv_items_by_date.visibility == View.VISIBLE) {
                    rl_rsv_items_by_date.visibility = View.GONE
                    ib_more_rsv_list.animate().apply {
                        duration = 200
                        rotation(0f)
                    }
                } else {
                    rl_rsv_items_by_date.visibility = View.VISIBLE
                    ib_more_rsv_list.animate().apply {
                        duration = 200
                        rotation(180f)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.reservation_card_item_list, parent, false)
        return ListItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.bind(list[position], position)
    }
}