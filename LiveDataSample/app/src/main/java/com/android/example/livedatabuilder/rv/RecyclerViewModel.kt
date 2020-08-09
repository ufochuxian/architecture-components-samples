package com.android.example.livedatabuilder.rv

import androidx.lifecycle.ViewModel

/**

 * @Author: chen

 * @datetime: 2020/8/1

 * @desc:

 */
class RecyclerViewModel : ViewModel() {


    private var repository = RvRepository()


    fun getShoes(): List<RvRepository.Shoes> {
        return repository.mShoes
    }

    fun updateDataSource(position : Int) {

        val mShoes = repository.getShoes()

        mShoes.getOrNull(position)?.let {
            it.name.set("我被更新了")
        }

    }

}