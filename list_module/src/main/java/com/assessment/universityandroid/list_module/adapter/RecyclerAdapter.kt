package com.assessment.universityandroid.list_module.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assessment.universityandroid.core.database.University
import com.assessment.universityandroid.list_module.databinding.SingleItemBinding

class RecyclerAdapter(val uniList: List<University>):  RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: SingleItemBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val binding = SingleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val binding = holder.binding
        val uni = uniList[position]
        uni.name?.let { Log.d("TAG", it) }
        binding.txtUniName.text = uni.name
        binding.txtUniState.text = uni.stateProvince

    }

    override fun getItemCount(): Int {
      return uniList.size
    }
}