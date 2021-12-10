package com.example.trending.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.example.trending.R
import com.example.trending.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: MainFragmentBinding
    private val adapter by lazy {
        MainListAdapter(viewModel)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater,container,false)
        viewModel.apiCall()
        binding.lifecycleOwner = viewLifecycleOwner
        binding.rcrItems.adapter = adapter

        val helper: SnapHelper = LinearSnapHelper()
        helper.attachToRecyclerView(binding.rcrItems)

        viewModel.repos.observe(this,{
            adapter.submitList(it)
        })
        viewModel.selectedItem.observe(this,{
            adapter.notifyDataSetChanged()
        })

        binding.scrItems.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                viewModel.filter(p0?.trim())
                return true
            }

        })
        return binding.root
    }
}