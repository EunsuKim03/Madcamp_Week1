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
import org.json.JSONArray

var contactDataList = ArrayList<ContactData>()
class ContactFragment : Fragment() {
//    private var dataList: ArrayList<ContactData> = ContactList


    private var _binding: FragmentContactBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // parse json file
        val json = resources.assets.open("contact_data.json").reader().readText()
        val jsonArray = JSONArray(json)
        for (index in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(index)
            val id = jsonObject.getInt("id")
            val name = jsonObject.getString("name")
            val photoName = jsonObject.getString("photo_name")
            val phoneNumber = jsonObject.getString("phone")
            contactDataList.add(ContactData(id, name, photoName, phoneNumber))
        }

        val homeViewModel =
            ViewModelProvider(this)

        _binding = FragmentContactBinding.inflate(inflater, container, false)

        binding.rcvContactList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rcvContactList.setHasFixedSize(true)
        binding.rcvContactList.adapter = ContactListAdapter(contactDataList)

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