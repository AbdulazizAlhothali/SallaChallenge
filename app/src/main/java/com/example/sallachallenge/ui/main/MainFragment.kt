package com.example.sallachallenge.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sallachallenge.R
import com.example.sallachallenge.databinding.MainFragmentBinding
import com.example.sallachallenge.model.BaseStoreData
import com.example.sallachallenge.paging.StorePagingAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {


    private lateinit var binding: MainFragmentBinding
    private val viewModel by viewModels<MainViewModel>()
    private lateinit var adapter: StorePagingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = StorePagingAdapter()
        binding.rvMain.layoutManager = LinearLayoutManager(context)
        binding.rvMain.setHasFixedSize(true)
        binding.rvMain.adapter = adapter
        viewModel.list.observe(viewLifecycleOwner){
            Log.e("MyStore","${listOf(it)}")
            adapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
        /*viewModel.getData().observe(viewLifecycleOwner){
            Log.e("MyStore","${listOf(it)}")
        }*/
    }

}