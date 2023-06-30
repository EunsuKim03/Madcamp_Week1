package com.example.madcamp_week1.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.madcamp_week1.databinding.FragmentGalleryBinding


class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    var photolist = arrayListOf<Photo3>(
        Photo3("ic_gallery_food", "ic_gallery_food", "photo_eatmythai"),
        Photo3("ic_gallery_food", "ic_gallery_food", "ic_gallery_food"),
        Photo3("ic_gallery_food", "ic_gallery_food", "ic_gallery_food"),
        Photo3("ic_gallery_food", "ic_gallery_food", "ic_gallery_food"),
        Photo3("ic_gallery_food", "ic_gallery_food", "ic_gallery_food"),
        Photo3("ic_gallery_food", "ic_gallery_food", "ic_gallery_food"),
        Photo3("ic_gallery_food", "ic_gallery_food", "ic_gallery_food"),
        Photo3("ic_gallery_food", "ic_gallery_food", "ic_gallery_food"),
        Photo3("ic_gallery_food", "ic_gallery_food", "ic_gallery_food"),
    )

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

        val adt = GalleryListAdapter(requireContext(), photolist)
        binding.galleryList.adapter = adt

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}