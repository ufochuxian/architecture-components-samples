package com.android.example.livedatabuilder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.example.livedata.R
import com.android.example.livedata.databinding.LayoutLivedatafragmentBinding

/**

 * @Author: chen

 * @datetime: 2020/7/30

 * @desc:

 */
class LiveDataFragment : BaseFragment() {

    companion object {
        const val TAG = "LiveDataFragment"

        val instance = LiveDataFragment()
    }

    private var mLiveDataFragmentBinding: LayoutLivedatafragmentBinding? = null

    private var mViewModel: LiveDataFragmentViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewModel = ViewModelProvider(this).get(LiveDataFragmentViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mLiveDataFragmentBinding =
            LayoutLivedatafragmentBinding.inflate(inflater, container, false).apply {
                viewModel = mViewModel
            }


        return mLiveDataFragmentBinding?.root
    }




}