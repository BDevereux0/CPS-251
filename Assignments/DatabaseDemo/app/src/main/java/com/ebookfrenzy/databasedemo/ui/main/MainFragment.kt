
package com.ebookfrenzy.databasedemo.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebookfrenzy.databasedemo.Product
import com.ebookfrenzy.databasedemo.R
import com.ebookfrenzy.databasedemo.databinding.FragmentMainBinding
import java.util.*

class MainFragment : Fragment() {

    private var adapter: ProductListAdapter? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    val viewModel: MainViewModel by viewModels()
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }


/*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listenerSetup()
        observerSetup()
        recyclerSetup()

    }*/


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listenerSetup()
        observerSetup()
        recyclerSetup()
    }

    private fun listenerSetup() {
        binding.addButton.setOnClickListener {
            val name = binding.productName.text.toString()
            val quantity = binding.productQuantity.text.toString()

            if (name != "" && quantity != "") {
                val product = Product(name, Integer.parseInt(quantity))
                viewModel.insertProduct(product)
                clearFields()
            } else {
                binding.productID.text = "Incomplete information"
            }
        }
        binding.findButton.setOnClickListener { viewModel.findProduct(
            binding.productName.text.toString()) }

    binding.deleteButton.setOnClickListener {
        viewModel.deleteProduct(binding.productName.text.toString())
        clearFields()
    }
}

    private fun observerSetup() {
        viewModel.getAllProducts()?.observe(viewLifecycleOwner, Observer { products ->
            products?.let {
                adapter?.setProductList(it)
            }
        })
        viewModel.getSearchResults().observe(viewLifecycleOwner, Observer { products ->
            products?.let {
                if (it.isNotEmpty()) {
                    binding.productID.text = String.format(Locale.US, "%d", it[0].id)
                    binding.productName.setText(it[0].productName)
                    binding.productQuantity.setText(String.format(Locale.US, "%d",
                        it[0].quantity))
                } else {
                    binding.productID.text = "No Match"
                }
            }
        })
    }

    private fun recyclerSetup() {
        adapter = ProductListAdapter(R.layout.product_list_item)
        binding.productRecycler.layoutManager = LinearLayoutManager(context)
        binding.productRecycler.adapter = adapter
    }



    private fun clearFields() {
        binding.productID.text = ""
        binding.productName.setText("")
        binding.productQuantity.setText("")
    }
}
