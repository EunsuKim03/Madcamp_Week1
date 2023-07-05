package com.example.madcamp_week1.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.madcamp_week1.databinding.FragmentGalleryBinding
import com.example.madcamp_week1.db.restaurantRoom.RestaurantDatabase
import com.example.madcamp_week1.db.restaurantRoom.RestaurantEntity
import kotlinx.coroutines.runBlocking


//var restaurantDataList = ArrayList<RestaurantData>()
class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var db = Room.databaseBuilder(
            requireContext().applicationContext,
            RestaurantDatabase::class.java, "restaurantDB"
        ).build()

//        val json = resources.assets.open("restaurant_data.json").reader().readText()
//        val jsonArray = JSONArray(json)
//        for (index in 0 until jsonArray.length()) {
//            val jsonObject = jsonArray.getJSONObject(index)
//            val rid = jsonObject.getInt("id")
//            val name = jsonObject.getString("name")
//            val photo_name = jsonObject.getString("photo_name")
//            val phoneNumber = jsonObject.getString("phone_number")
//            val address = jsonObject.getString("address")
//
//            restaurantDataList.add(RestaurantData(rid, name, photo_name, phoneNumber, address))
//        }

//        val _list = (1..(3 - (restaurantDataList.size % 3))%3).fold(restaurantDataList.map{r -> r as RestaurantData?}.toMutableList(), {acc, _ -> acc.add(null); acc})
        val temp: List<RestaurantEntity>

        runBlocking {
            temp = db.restaurantDao().getAll()
        }

        val _list = (1..(3 - (temp.size % 3))%3).fold(temp.map{r -> r as RestaurantEntity?}.toMutableList(), {acc, _ -> acc.add(null); acc})

//        val list1 = _list.map { it?.photoName }.filterIndexed { i, _ -> i%3 == 0 }
//        val list2 = _list.map { it?.photoName }.filterIndexed { i, _ -> i%3 == 1 }
//        val list3 = _list.map { it?.photoName }.filterIndexed { i, _ -> i%3 == 2 }
        val list1 = _list.filterIndexed { i, _ -> i%3 == 0 }
        val list2 = _list.filterIndexed { i, _ -> i%3 == 1 }
        val list3 = _list.filterIndexed { i, _ -> i%3 == 2 }
        val photolist = list1.zip(list2).zip(list3) { (s1, s2), s3 -> Photo3(s1, s2, s3) }


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

    override fun onResume() {
        super.onResume()

        var db = Room.databaseBuilder(
            requireContext().applicationContext,
            RestaurantDatabase::class.java, "restaurantDB"
        ).build()

        val temp: List<RestaurantEntity>

        runBlocking {
            temp = db.restaurantDao().getAll()
        }

        if(temp.size <= 0) {
            binding.galleryList.visibility = View.GONE
            binding.tvIsGalleryEmpty.visibility = View.VISIBLE
        } else {
            binding.tvIsGalleryEmpty.visibility = View.GONE
            binding.galleryList.visibility = View.VISIBLE
            val _list = (1..(3 - (temp.size % 3))%3).fold(temp.map{r -> r as RestaurantEntity?}.toMutableList(), {acc, _ -> acc.add(null); acc})

//        val list1 = _list.map { it?.photoName }.filterIndexed { i, _ -> i%3 == 0 }
//        val list2 = _list.map { it?.photoName }.filterIndexed { i, _ -> i%3 == 1 }
//        val list3 = _list.map { it?.photoName }.filterIndexed { i, _ -> i%3 == 2 }
            val list1 = _list.filterIndexed { i, _ -> i%3 == 0 }
            val list2 = _list.filterIndexed { i, _ -> i%3 == 1 }
            val list3 = _list.filterIndexed { i, _ -> i%3 == 2 }
            val photolist = list1.zip(list2).zip(list3) { (s1, s2), s3 -> Photo3(s1, s2, s3) }


            val lm = LinearLayoutManager(context)
            binding.galleryList.layoutManager = lm
            binding.galleryList.setHasFixedSize(true)

            val adt = GalleryListAdapter(requireContext(), photolist as ArrayList<Photo3>)
            binding.galleryList.adapter = adt
        }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}