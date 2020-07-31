package com.android.example.livedatabuilder

import androidx.databinding.Observable
import androidx.databinding.ObservableField


/**

 * @Author: chen

 * @datetime: 2020/7/31

 * @desc:

 */


class User(name: String, isVip: Boolean) {
    var name  = ObservableField(name)
    var boolean = ObservableField(isVip)
}