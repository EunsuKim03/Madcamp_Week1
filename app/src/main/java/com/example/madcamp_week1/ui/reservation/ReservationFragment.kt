package com.example.madcamp_week1.ui.reservation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.madcamp_week1.databinding.FragmentReservationBinding
import com.example.madcamp_week1.db.ContactData
import com.example.madcamp_week1.db.ReservationData
import com.example.madcamp_week1.db.reservationRoom.ReservationDatabase
import com.example.madcamp_week1.db.reservationRoom.ReservationEntity
import kotlinx.coroutines.runBlocking
import org.json.JSONArray

//var reservationDataList = ArrayList<ReservationData>()
class ReservationFragment : Fragment() {
//    private var dataList: ArrayList<ReservationData> = ReservationList
    private var _binding: FragmentReservationBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // parse json file
//        val json = resources.assets.open("reservation_data.json").reader().readText()
//        val jsonArray = JSONArray(json)
//        for (index in 0 until jsonArray.length()) {
//            val jsonObject = jsonArray.getJSONObject(index)
//            val id = jsonObject.getInt("id")
//            val rid = jsonObject.getInt("restaurant_id")
//            val contactID_jsonArray = jsonObject.getJSONArray("contact_id")
//            var contacts = ArrayList<ContactData>()
//            for(idx in 0 until contactID_jsonArray.length()) {
//                val cid = contactID_jsonArray.getInt(idx)
//                contacts.add(contactDataList.get(cid))
//            }
//
//            val date = jsonObject.getString("date")
//            reservationDataList.add(ReservationData(restaurantDataList.get(rid), contacts, date))
//        }

        var db = Room.databaseBuilder(
            requireContext().applicationContext,
            ReservationDatabase::class.java, "reservationDB"
        ).build()

        val reservationViewModel =
            ViewModelProvider(this)

        _binding = FragmentReservationBinding.inflate(inflater, container, false)

        val temp: List<ReservationEntity>

        runBlocking { temp = db.reservationDao().getAll() }


        var reservationList = ArrayList<ReservationEntity>()

        temp.forEach { reservationList.add(it) }

        reservationList.sortWith(compareBy {it.date})

        var dataListByDate = ArrayList<Pair<String, List<ReservationEntity>>>()

        reservationList.groupBy { it.date }.entries.map { dataListByDate.add(Pair(it.key, it.value)) }.toList()

        binding.rcvReservationList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rcvReservationList.setHasFixedSize(true)
//        binding.rcvReservationList.adapter = ReservationListAdapter(dataList)
        binding.rcvReservationList.adapter = ReservationCardListAdapter(dataListByDate)

        val root: View = binding.root

//        val textView: TextView = binding.textLikes
//        reservationViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}