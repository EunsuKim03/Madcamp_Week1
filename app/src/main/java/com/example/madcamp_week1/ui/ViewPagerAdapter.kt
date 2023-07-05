package com.example.madcamp_week1.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.madcamp_week1.ui.contact.ContactFragment
import com.example.madcamp_week1.ui.gallery.GalleryFragment
import com.example.madcamp_week1.ui.reservation.ReservationFragment

class ViewPagerAdapter (fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int= 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> ContactFragment()
            1 -> GalleryFragment()
            else -> ReservationFragment()
        }
    }
}