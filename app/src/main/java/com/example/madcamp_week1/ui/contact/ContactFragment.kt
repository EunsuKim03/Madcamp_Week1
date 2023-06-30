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
import com.example.madcamp_week1.db.ContactData

class ContactFragment : Fragment() {
    var dataList: ArrayList<ContactData> = arrayListOf(
        ContactData("AAA", "010-1111-1111"),
        ContactData("BBB", "010-1111-2222"),
        ContactData("CCC", "010-1111-3333"),
        ContactData("DDD", "010-1111-4444"),
        ContactData("EEE", "010-1111-5555"),
        ContactData("FFF", "010-1111-6666"),
        ContactData("GGG", "010-1111-7777"),
        ContactData("HHH", "010-1111-8888"),
        ContactData("III", "010-1111-9999"),
        ContactData("JJJ", "010-1111-0000"),
        ContactData("KKK", "010-2222-2222"),
        ContactData("LLL", "010-2222-3333"),
        ContactData("MMM", "010-2222-4444"),
        ContactData("NNN", "010-2222-5555"),
        ContactData("OOO", "010-2222-6666"),
        ContactData("PPP", "010-2222-7777"),
        ContactData("QQQ", "010-2222-8888"),
        ContactData("RRR", "010-2222-9999"),
        ContactData("SSS", "010-2222-0000")
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
            ViewModelProvider(this)

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