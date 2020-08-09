package com.android.example.livedatabuilder.rv

import androidx.databinding.ObservableField
import androidx.databinding.ObservableParcelable
import com.android.example.livedata.R


/**

 * @Author: chen

 * @datetime: 2020/8/7

 * @desc:

 */
class RvRepository {

    var mShoes =
        listOf<Shoes>(
            Shoes("aj",R.mipmap.aj),
            Shoes("aj12",R.mipmap.air_jordan_12),
            Shoes("aj13",R.mipmap.air_jordan_13),
            Shoes("diamond",R.mipmap.diamond_low),
            Shoes("leborn",R.mipmap.leborn)
        )


    fun getShoes(): List<Shoes> {
        return mShoes
    }


    class Shoes(name: String,resID: Int)  {
        // 如果需要使用双向绑定，那么需要使用这个DataBinding里面定义的一些字段进行绑定
        //https://blog.csdn.net/lixpjita39/article/details/78751811
        var name : ObservableField<String> = ObservableField<String>(name)
        var mResId = resID
    }

}