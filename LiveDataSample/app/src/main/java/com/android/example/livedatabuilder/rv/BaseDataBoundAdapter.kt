package com.android.example.livedatabuilder.rv

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**

 * @Author: chen

 * @datetime: 2020/8/7

 * @desc:

 */
abstract class BaseDataBoundAdapter<T : ViewDataBinding> : RecyclerView.Adapter<DataBoundViewHolder<T>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBoundViewHolder<T> {
        val vh = DataBoundViewHolder.create<T>(parent, getItemLayoutID())
        return vh
    }

    override fun onBindViewHolder(holder: DataBoundViewHolder<T>, position: Int) {
        bindItem(holder,position)
        holder.binding.executePendingBindings()
    }

    abstract fun bindItem(holder: DataBoundViewHolder<T>, position: Int)

    abstract fun getItemLayoutID(): Int

}