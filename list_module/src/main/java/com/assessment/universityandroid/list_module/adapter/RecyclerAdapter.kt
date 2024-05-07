package com.assessment.universityandroid.list_module.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assessment.universityandroid.core.database.University
import com.assessment.universityandroid.detail.DetailActivity
import com.assessment.universityandroid.list_module.databinding.SingleItemBinding


class RecyclerAdapter(val uniList: List<University>,val mContext: Context):  RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: SingleItemBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val binding = SingleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val binding = holder.binding
        val uni = uniList[position]
        binding.txtUniName.text = uni.name
        binding.txtUniState.text = uni.stateProvince
        holder.binding.img.setOnClickListener {
            val intent = Intent(mContext,DetailActivity::class.java)
            //Todo shouldn't use
            val b = Bundle()
            b.putString("name", uni.name)
            b.putString("state", uni.stateProvince)
            b.putString("country", uni.country)
            b.putString("country_code", uni.alphaTwoCode)
            b.putString("web_pages", uni.webPage.first())
            intent.putExtra("Data_Key", b)
            mContext.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
      return uniList.size
    }
}
interface ItemClickListener {
    fun onClick(view: View?, position: Int, isLongClick: Boolean)
}