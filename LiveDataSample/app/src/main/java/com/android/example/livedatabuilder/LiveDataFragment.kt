package com.android.example.livedatabuilder

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.android.example.livedata.R
import com.android.example.livedata.databinding.LayoutLivedatafragmentBinding
import kotlinx.android.synthetic.main.layout_livedatafragment.*

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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        mViewModel?.goToSecondFraLiveData?.observe(viewLifecycleOwner, Observer {event ->
            event.getContentIfNotHandled()?.let {
                goToSecondFragment()
            }
        })
    }

    private fun goToSecondFragment() {
        Log.v(TAG, "[goToSecondFragment]")
        //这个地方有一点需要注意的地方，就是这里的调用的时候需要确保goToSecondFragment这个view是已经绘制完成的（不为null）
        //所以这里需要在onViewCreated()方法中调用，在onCreateView中调用，可能就会不成功了
        Navigation.findNavController(goToSecondFragment)
            .navigate(R.id.action_livedatafragment_to_secondfragment)
    }


}