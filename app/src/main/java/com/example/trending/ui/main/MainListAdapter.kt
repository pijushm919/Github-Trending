package com.example.trending.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.trending.databinding.LayoutListItemBinding
import com.example.trending.models.TrendingRepo


class MainListAdapter(private val viewModel: MainViewModel) : ListAdapter<TrendingRepo,MainListAdapter.ViewHolder>(MainDiffItemCallback()) {

    class ViewHolder(private val binding: LayoutListItemBinding, private val viewModel: MainViewModel):RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("NotifyDataSetChanged")
        fun bind(item: TrendingRepo){
            binding.model = item
            binding.crdItem.setOnClickListener {
                viewModel.selectedItem.value = item
            }
            if (viewModel.selectedItem.value == item){
                setChecked()
            }else{
                setUnChecked()
            }
        }
        private fun setChecked(){
            binding.crdItem.isChecked = true
        }
        private fun setUnChecked(){
            binding.crdItem.isChecked = false
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val lyt = LayoutListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(lyt,viewModel)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MainDiffItemCallback : DiffUtil.ItemCallback<TrendingRepo>(){
        override fun areItemsTheSame(oldItem: TrendingRepo, newItem: TrendingRepo): Boolean {
           return oldItem.repositoryName == newItem.repositoryName
        }

        override fun areContentsTheSame(oldItem: TrendingRepo, newItem: TrendingRepo): Boolean {
            return oldItem == newItem
        }

    }
}