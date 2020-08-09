package com.android.example.livedatabuilder.rv

import com.android.example.livedata.R
import com.android.example.livedata.databinding.ShoesItemBinding

/**

 * @Author: chen

 * @datetime: 2020/8/7

 * @desc:

 */
//这个后面不一定要跟着构造函数,可以在内部用constructor进行定义
class ShoesAdapter : DataBoundAdapter<ShoesItemBinding> {

    private var mShoes : List<RvRepository.Shoes>

    private var mCallBack : ActionCallBack? = null

//    constructor(layoutID: Int) : super(layoutID)

    constructor(
        layoutID: Int,
        mShoes: List<RvRepository.Shoes>,
        mCallBack: ActionCallBack?
    ) : super(layoutID) {
        this.mShoes = mShoes
        this.mCallBack = mCallBack
    }


    override fun bindItem(holder: DataBoundViewHolder<ShoesItemBinding>, position: Int) {
        holder.binding.shoes = mShoes[position]
        holder.binding.actionCallBack = mCallBack
    }

    override fun getItemCount(): Int {
        return mShoes.size
    }


    interface ActionCallBack {

        fun showName(name : String)

    }


}