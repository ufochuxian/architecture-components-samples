package com.android.example.livedatabuilder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import java.util.*
import kotlin.concurrent.timerTask

/**

 * @Author: chen

 * @datetime: 2020/7/30

 * @desc:

 */
class LiveDataFragmentViewModel : ViewModel() {

    //注意这里不能直接使用MutabLiveData()，不然在按下back按键的时候，会引起LiveDataFragment重建（因为在这个例子中使用的是navigation，使用的是replace按键）
    //LiveDataFragment的生命周期又会变成大于onStart，所以就又会触发goToSecondFraLiveData的onChanged方法，又会将在LiveDataFragment注册中注册的livedata的方法又走一次
    //参考：https://juejin.im/post/6844903721831235591
    var goToSecondFraLiveData = MutableLiveData<Event<String>>()


    fun goToSecondFragment() {
        goToSecondFraLiveData.value = Event("goToSecond")
    }
}