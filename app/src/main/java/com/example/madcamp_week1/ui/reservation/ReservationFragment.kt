package com.example.madcamp_week1.ui.reservation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.madcamp_week1.databinding.FragmentReservationBinding
import com.example.madcamp_week1.db.ReservationData
import com.example.madcamp_week1.db.ReservationList

class ReservationFragment : Fragment() {
    private var dataList: ArrayList<ReservationData> = ReservationList

    private var _binding: FragmentReservationBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val reservationViewModel =
            ViewModelProvider(this)

        _binding = FragmentReservationBinding.inflate(inflater, container, false)

        dataList.sortWith(compareBy {it.date})

        binding.rcvReservationList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rcvReservationList.setHasFixedSize(true)
        binding.rcvReservationList.adapter = ReservationListAdapter(dataList)

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