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

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Date

/**
 * Showcases different patterns using the liveData coroutines builder.
 */
class LiveDataViewModel(
    private val dataSource: DataSource
) : ViewModel() {

    var goFra : MutableLiveData<Unit> = MutableLiveData()



    // Exposed LiveData from a function that returns a LiveData generated with a liveData builder
    val currentTime = dataSource.getCurrentTime()

    // Coroutines inside a transformation
    val currentTimeTransformed = currentTime.switchMap {
        // timeStampToTime is a suspend function so we need to call it from a coroutine.
        liveData { emit(timeStampToTime(it)) }
    }

    // Exposed liveData that emits and single value and subsequent values from another source.
    val currentWeather: LiveData<String> = liveData {
        emit(LOADING_STRING)
        emitSource(dataSource.fetchWeather())
    }

    // Exposed cached value in the data source that can be updated later on
    val cachedValue = dataSource.cachedData

    // Called when the user clicks on the "FETCH NEW DATA" button. Updates value in data source.
    fun onRefresh() {
        // Launch a coroutine that reads from a remote data source and updates cache
        viewModelScope.launch {
            dataSource.fetchNewData()
        }
    }

    fun gotoFra() {
        goFra.value = null
    }

    // Simulates a long-running computation in a background thread
    private suspend fun timeStampToTime(timestamp: Long): String {
        delay(500)  // Simulate long operation
        val date = Date(timestamp)
        return date.toString()
    }

    companion object {
        // Real apps would use a wrapper on the result type to handle this.
        const val LOADING_STRING = "Loading..."
    }

    fun test() {
        Log.i("test","test start")
        viewModelScope.launch {
            delay(3000)
            Log.i("test","test launch")
        }
        Log.i("test","test end")
    }
}


/**
 * Factory for [LiveDataViewModel].
 */
object LiveDataVMFactory : ViewModelProvider.Factory {

    private val dataSource = DefaultDataSource(Dispatchers.IO)

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        //这里如果viewmodel需要带参数的话，那么使用ViewModelProviders.of() 生成viewmodel会报错，因为其内部默认会调用viewmodel不带参数的构造函数
        //https://medium.com/koderlabs/viewmodel-with-viewmodelprovider-factory-the-creator-of-viewmodel-8fabfec1aa4f
        return LiveDataViewModel(dataSource) as T
    }
}
