package com.android.example.livedatabuilder.rv

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding

/**

 * @Author: chen

 * @datetime: 2020/8/7

 * @desc:

 */
abstract class DataBoundAdapter<T : ViewDataBinding>(layoutID : Int) : BaseDataBoundAdapter<T>() {

    @LayoutRes
    val mLayoutId: Int = layoutID

    override fun getItemLayoutID() : Int {
        return mLayoutId
    }

}