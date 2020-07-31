package com.android.example.livedatabuilder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModelProvider
import com.android.example.livedata.databinding.FragmentSecondBinding

/**

 * @Author: chen

 * @datetime: 2020/7/31

 * @desc:

 */
class SecondFragment : BaseFragment() {

    companion object {
        const val TAG = "SecondFragment"
        var instance = SecondFragment()
    }

    private var mViewModel : SecondViewModel? = null

    private var mUserInfo : User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewModel = ViewModelProvider(this).get(SecondViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentSecondBinding.inflate(inflater, container, false).apply {
            viewmodel = mViewModel
            user = User("小明", true)
        }.root
    }
}