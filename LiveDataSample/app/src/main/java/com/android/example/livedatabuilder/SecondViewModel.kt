package com.android.example.livedatabuilder

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlin.random.Random

/**

 * @Author: chen

 * @datetime: 2020/7/31

 * @desc:

 */
class SecondViewModel : ViewModel() {

    companion object {
        const val TAG = "SecondViewModel"
    }


    fun updateUserInfo(user: User) {
        //Databinding ObservableField使用
        // https://developer.android.google.cn/reference/android/databinding/ObservableField
        Log.i(TAG,"[updateUserInfo],username:${user.name.get()}")
        user.name.set("小明${Random.nextInt(100)}")
        user.boolean.set(false)
    }
}