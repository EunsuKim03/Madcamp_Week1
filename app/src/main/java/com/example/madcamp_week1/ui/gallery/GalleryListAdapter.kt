package com.example.madcamp_week1.ui.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.madcamp_week1.R

class GalleryListAdapter(private val context: android.content.Context, private val p3list: ArrayList<Photo3>) :
    RecyclerView.Adapter<GalleryListAdapter.Holder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.gallery_item_list, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(p3list[position], context)
    }

    override fun getItemCount(): Int {
        return p3list.size
    }

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView!!) {
        private val p1: ImageView = itemView.findViewById<ImageView>(R.id.photo1)
        private val p2: ImageView = itemView.findViewById<ImageView>(R.id.photo2)
        private val p3: ImageView = itemView.findViewById<ImageView>(R.id.photo3)

        fun bind(photo_set: Photo3, context: android.content.Context) {
            if (!photo_set.p1.isNullOrEmpty()) {
                val resId = context.resources.getIdentifier(photo_set.p1, "drawable", context.packageName)
                p1.setImageResource(resId)
            } else {
                p1.setImageResource(R.mipmap.ic_launcher)
            }

            if (!photo_set.p2.isNullOrEmpty()) {
                val resId = context.resources.getIdentifier(photo_set.p2, "drawable", context.packageName)
                p2.setImageResource(resId)
            } else {
                p2.setImageResource(R.mipmap.ic_launcher)
            }

            if (!photo_set.p3.isNullOrEmpty()) {
                val resId = context.resources.getIdentifier(photo_set.p3, "drawable", context.packageName)
                p3.setImageResource(resId)
            } else {
                p3.setImageResource(R.mipmap.ic_launcher)
            }

//            p1.setOnClickListener {
//
//            }
        }
    }
}