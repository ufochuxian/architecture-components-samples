package com.android.example.livedatabuilder.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**

 * @Author: chen

 * @datetime: 2020/8/7

 * @desc:

 */
/**
 * A generic ViewHolder that wraps a generated ViewDataBinding class.
 *
 * @param <T> The type of the ViewDataBinding class
</T> */
class DataBoundViewHolder<T : ViewDataBinding>(val binding: T) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        /**
         * Creates a new ViewHolder for the given layout file.
         *
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            `*`
         * The provided layout must be using data binding.
         *
         * @param parent   The RecyclerView
         * @param layoutId The layout id that should be inflated. Must use data binding
         * @param <T>      The type of the Binding class that will be generated for the `layoutId`.
         * @return A new ViewHolder that has a reference to the binding class
        </T> */
        fun <T : ViewDataBinding> create(
            parent: ViewGroup,
            @LayoutRes layoutId: Int
        ): DataBoundViewHolder<T> {
            val binding: T = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layoutId, parent, false
            )
            return DataBoundViewHolder(binding)
        }
    }

}
