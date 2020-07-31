/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.example.livedatabuilder

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.android.example.livedata.R
import com.android.example.livedata.databinding.ActivityLivedataBinding
import kotlinx.coroutines.launch

class LiveDataActivity : AppCompatActivity() {

    // Obtain ViewModel
    private val viewmodel: LiveDataViewModel by viewModels { LiveDataVMFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Obtain binding object using the Data Binding library
        val binding = DataBindingUtil.setContentView<ActivityLivedataBinding>(
            this, R.layout.activity_livedata
        )

        // Set the LifecycleOwner to be able to observe LiveData objects
        binding.lifecycleOwner = this

        // Bind ViewModel
        binding.viewmodel = viewmodel

        lifecycleScope.launchWhenResumed {
            Log.i("test","onResume")
        }


        viewmodel.goFra.observe(this, Observer {
            goToLiveDataFag()
        } )
        viewmodel.test()

    }

    private fun goToLiveDataFag() {
        supportFragmentManager.beginTransaction().apply {
            add(R.id.root_view,LiveDataFragment.instance,LiveDataFragment.TAG)
            commitAllowingStateLoss()
        }
    }
}


