package com.example.madcamp_week1.ui.gallery

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.madcamp_week1.R
import com.example.madcamp_week1.ui.contact.ContactDetailActivity

class GalleryListAdapter(private val context: android.content.Context, private val p3list: ArrayList<Photo3>) :
    RecyclerView.Adapter<GalleryListAdapter.Holder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.gallery_item_list, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(p3list[position], context, position)
    }

    override fun getItemCount(): Int {
        return p3list.size
    }

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView!!) {
        private val p1: ImageView = itemView.findViewById<ImageView>(R.id.photo1)
        private val p2: ImageView = itemView.findViewById<ImageView>(R.id.photo2)
        private val p3: ImageView = itemView.findViewById<ImageView>(R.id.photo3)

        fun bind(photo_set: Photo3, context: android.content.Context, position: Int) {
            var resId1: Int? = null
            if (!photo_set.p1.isNullOrEmpty()) {
                p1.visibility = VISIBLE
                resId1 = context.resources.getIdentifier(photo_set.p1, "drawable", context.packageName)
                p1.setImageResource(resId1)
            } else {
                resId1 = context.resources.getIdentifier("nothing", "drawable", context.packageName)
                p1.setImageResource(R.mipmap.ic_launcher)
            }

            var resId2: Int? = null
            if (!photo_set.p2.isNullOrEmpty()) {
                p2.visibility = VISIBLE
                resId2 = context.resources.getIdentifier(photo_set.p2, "drawable", context.packageName)
                p2.setImageResource(resId2)
            } else {
                resId2 = context.resources.getIdentifier("nothing", "drawable", context.packageName)
                p2.setImageResource(R.mipmap.ic_launcher)
            }

            var resId3: Int? = null
            if (!photo_set.p3.isNullOrEmpty()) {
                p3.visibility = VISIBLE
                resId3 = context.resources.getIdentifier(photo_set.p3, "drawable", context.packageName)
                p3.setImageResource(resId3)
            } else {
                resId3 = context.resources.getIdentifier("nothing", "drawable", context.packageName)
                p3.setImageResource(R.mipmap.ic_launcher)
            }

            p1.setOnClickListener {
                Intent(context, GalleryDetailActivity::class.java).apply {
                    putExtra("galleryData1", resId1)
                    putExtra("galleryData2", position * 3)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { context.startActivity(this) }
            }

            p2.setOnClickListener {
                Intent(context, GalleryDetailActivity::class.java).apply {
                    putExtra("galleryData1", resId2)
                    putExtra("galleryData2", position * 3 + 1)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { context.startActivity(this) }
            }

            p3.setOnClickListener {
                Intent(context, GalleryDetailActivity::class.java).apply {
                    putExtra("galleryData1", resId3)
                    putExtra("galleryData2", position * 3 + 2)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { context.startActivity(this) }
            }
        }
    }
}