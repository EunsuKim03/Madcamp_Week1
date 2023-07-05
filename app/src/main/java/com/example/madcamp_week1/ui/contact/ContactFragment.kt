package com.example.madcamp_week1.ui.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.madcamp_week1.databinding.FragmentContactBinding
import com.example.madcamp_week1.db.ContactData
import com.example.madcamp_week1.db.contactRoom.ContactDatabase
import com.example.madcamp_week1.db.contactRoom.ContactEntity
import kotlinx.coroutines.runBlocking
import org.json.JSONArray

//var contactDataList = ArrayList<ContactData>()
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
        // room
        var db = Room.databaseBuilder(
            requireContext().applicationContext,
            ContactDatabase::class.java, "contactDB"
        ).build()




        // parse json file
//        val json = resources.assets.open("contact_data.json").reader().readText()
//        val jsonArray = JSONArray(json)
//        for (index in 0 until jsonArray.length()) {
//            val jsonObject = jsonArray.getJSONObject(index)
//            val id = jsonObject.getInt("id")
//            val name = jsonObject.getString("name")
//            val photoName = jsonObject.getString("photo_name")
//            val phoneNumber = jsonObject.getString("phone")
//            contactDataList.add(ContactData(id, name, photoName, phoneNumber))
//        }

        val homeViewModel =
            ViewModelProvider(this)

        _binding = FragmentContactBinding.inflate(inflater, container, false)

//        contactDataList.sortWith(compareBy { it.name })

        binding.rcvContactList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rcvContactList.setHasFixedSize(true)
//        binding.rcvContactList.adapter = ContactListAdapter(contactDataList)
        var contactList = ArrayList<ContactEntity>()

        runBlocking {
            val temp = db.contactDao().getAll()
            temp.forEach { contactList.add(it) }
        }

        binding.rcvContactList.adapter = ContactListAdapter(contactList)

        val root: View = binding.root
//
//        val textView: TextView = binding.textContact
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        return root
    }

    override fun onResume() {
        super.onResume()

        var db = Room.databaseBuilder(
            requireContext().applicationContext,
            ContactDatabase::class.java, "contactDB"
        ).build()

        var contactList = ArrayList<ContactEntity>()

        runBlocking {
            val temp = db.contactDao().getAll()
            temp.forEach { contactList.add(it) }
        }

        if(contactList.size <= 0) {
            binding.rcvContactList.visibility = View.GONE
            binding.tvIsEmptyList.visibility = View.VISIBLE
        } else {
            binding.tvIsEmptyList.visibility = View.GONE
            binding.rcvContactList.visibility = View.VISIBLE
            binding.rcvContactList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            binding.rcvContactList.setHasFixedSize(true)
//        binding.rcvContactList.adapter = ContactListAdapter(contactDataList)
            val decoCount = binding.rcvContactList.itemDecorationCount
            if(decoCount != 0) {
                binding.rcvContactList.removeItemDecorationAt(decoCount - 1)
            }
            binding.rcvContactList.addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))

            binding.rcvContactList.adapter = ContactListAdapter(contactList)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}