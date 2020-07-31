package com.android.example.livedatabuilder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.android.example.livedata.R
import com.android.example.livedata.databinding.ActivityNavigateBinding

/**

 * @Author: chen

 * @datetime: 2020/7/31

 * @desc:

 */
class NavigateActivity : AppCompatActivity() {

    private var mViewModel : NavigateViewModel ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityNavigateBinding>(this,R.layout.activity_navigate)

    }
}