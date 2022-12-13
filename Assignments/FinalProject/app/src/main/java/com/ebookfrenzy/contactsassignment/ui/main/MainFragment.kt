package com.ebookfrenzy.contactsassignment.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebookfrenzy.contactsassignment.R
import com.ebookfrenzy.contactsassignment.databinding.FragmentMainBinding
import com.ebookfrenzy.contactsassignment.Contact

class MainFragment : Fragment(), OnItemClickListener {
    private var adapter: ContactListAdapter? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    val viewModel: MainViewModel by viewModels()
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private var preventRepeat: Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preventRepeat = false
        listenerSetup()
        observerSetup()
        recyclerSetup()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun clearFields() {
       //todo implement this
    }

    private fun listenerSetup() {
        binding.addBtn.setOnClickListener {
            val name = binding.nameInputField.text.toString()
            val phone = binding.phoneInputField.text.toString()

            if (name != "" && phone != "") {
                val contact = Contact(name, phone)
                viewModel.insertContact(contact) //this is calling viewModel method which in turn calls the REPO method
                clearFields()

            } else if (name== "" || phone=="") {
                Toast.makeText(context?.applicationContext, "Please enter a valid Name and Number", Toast.LENGTH_LONG).show()
            }
        }

        binding.findBtn.setOnClickListener {
            if (binding.nameInputField.text.toString().isNotEmpty()) {
                preventRepeat = true
                viewModel.findContact(binding.nameInputField.text.toString())
            }
        }

        binding.ascBtn.setOnClickListener{
            viewModel.sortASC()
        }

        binding.descBtn.setOnClickListener{
            viewModel.sortDESC()
        }

    }

    private fun observerSetup() {
        viewModel.getAllContacts()?.observe(viewLifecycleOwner) { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        }

        viewModel.getSearchResults().observe(viewLifecycleOwner) { contacts ->
            contacts?.let {
                if (it.isNotEmpty()) {
                    adapter?.setContactList(it)
                }
                if (it.isEmpty()&& preventRepeat) {
                    Toast.makeText(
                        context?.applicationContext, "You must enter a search criteria\n" +
                                "in the name field", Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.card_layout)
        binding.contactRecycler.layoutManager = LinearLayoutManager(context)
        binding.contactRecycler.adapter = adapter

        adapter!!.settingListener(object: ContactListAdapter.OnItemClickListner{
            override fun onClick(str: String) {
                super.onClick(str)
                val replace = str.replace("[0-9]".toRegex(),"").trim()
                viewModel.deleteContact(replace)
            }
        })
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

    }

}