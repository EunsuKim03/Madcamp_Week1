package com.example.madcamp_week1.ui.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.madcamp_week1.databinding.FragmentContactBinding
import com.example.madcamp_week1.db.ContactData
import com.example.madcamp_week1.db.ContactList

class ContactFragment : Fragment() {
    var dataList: ArrayList<ContactData> = ContactList

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