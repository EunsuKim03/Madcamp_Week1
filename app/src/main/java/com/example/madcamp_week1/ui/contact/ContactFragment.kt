package com.example.madcamp_week1.ui.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.madcamp_week1.databinding.FragmentContactBinding

class TestData(
    private var name: String? = null,
    private var phoneNumber: String? = null
) {
    fun getName(): String? {
        return name
    }
    fun setName(name: String) {
        this.name = name
    }
    fun getPhoneNumber(): String? {
        return phoneNumber
    }
    fun setPhoneNumber(phoneNumber: String) {
        this.phoneNumber = phoneNumber
    }
}

class ContactFragment : Fragment() {
    var dataList: ArrayList<TestData> = arrayListOf(
        TestData("AAA", "010-1111-1111"),
        TestData("BBB", "010-1111-2222"),
        TestData("CCC", "010-1111-3333"),
        TestData("DDD", "010-1111-4444"),
        TestData("EEE", "010-1111-5555"),
        TestData("FFF", "010-1111-6666"),
        TestData("GGG", "010-1111-7777"),
        TestData("HHH", "010-1111-8888"),
        TestData("III", "010-1111-9999"),
        TestData("JJJ", "010-1111-0000"),
        TestData("KKK", "010-2222-2222"),
        TestData("LLL", "010-2222-3333"),
        TestData("MMM", "010-2222-4444"),
        TestData("NNN", "010-2222-5555"),
        TestData("OOO", "010-2222-6666"),
        TestData("PPP", "010-2222-7777"),
        TestData("QQQ", "010-2222-8888"),
        TestData("RRR", "010-2222-9999"),
        TestData("SSS", "010-2222-0000")
    )

    private var _binding: FragmentContactBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(ContactViewModel::class.java)

        _binding = FragmentContactBinding.inflate(inflater, container, false)

        binding.rcvContactList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rcvContactList.setHasFixedSize(true)
        binding.rcvContactList.adapter = ContactListAdapter(dataList)

        val root: View = binding.root
//
//        val textView: TextView = binding.textContact
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}