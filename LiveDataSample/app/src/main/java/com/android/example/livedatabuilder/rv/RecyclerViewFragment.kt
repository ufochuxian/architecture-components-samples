package com.android.example.livedatabuilder.rv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.example.livedata.R
import com.android.example.livedata.databinding.FragmentRecyclerviewBinding
import com.android.example.livedatabuilder.BaseFragment
import kotlinx.android.synthetic.main.fragment_recyclerview.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**

 * @Author: chen

 * @datetime: 2020/8/1

 * @desc:

 */
class RecyclerViewFragment : BaseFragment() {

    private lateinit var mViewModel : RecyclerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewModel = ViewModelProvider(this).get(RecyclerViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentRecyclerviewBinding.inflate(inflater,container,false).apply {
            viewmodel = mViewModel
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rv.adapter = ShoesAdapter(
            R.layout.shoes_item,
            mViewModel.getShoes(),
            object : ShoesAdapter.ActionCallBack {
                override fun showName(name: String) {
                    Toast.makeText(activity,name,Toast.LENGTH_LONG).show()
                }

            })


        lifecycleScope.launch {
            delay(5000)

            mViewModel.updateDataSource(3)


        }
    }
}