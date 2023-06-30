package com.example.madcamp_week1.ui.gallery

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.madcamp_week1.databinding.FragmentGalleryBinding
import com.example.madcamp_week1.db.RestaurantList


class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    val list1 = RestaurantList.map { it.photoName }.filterIndexed { i, _ -> i%3 == 0 }
    val list2 = RestaurantList.map { it.photoName }.filterIndexed { i, _ -> i%3 == 1 }
    val list3 = RestaurantList.map { it.photoName }.filterIndexed { i, _ -> i%3 == 2 }
    val photolist = list1.zip(list2).zip(list3) { (s1, s2), s3 -> Photo3(s1, s2, s3) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val lm = LinearLayoutManager(context)
        binding.galleryList.layoutManager = lm
        binding.galleryList.setHasFixedSize(true)

        val adt = GalleryListAdapter(requireContext(), photolist as ArrayList<Photo3>)
        binding.galleryList.adapter = adt

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}