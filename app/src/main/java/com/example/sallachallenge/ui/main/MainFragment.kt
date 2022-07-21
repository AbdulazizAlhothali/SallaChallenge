package com.example.sallachallenge.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.example.sallachallenge.databinding.MainFragmentBinding
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
        viewModel.setHeader("1328842359")
        viewModel.list.observe(viewLifecycleOwner){
            Log.e("MyStore","$it")
            adapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
        viewModel.getBrandData().observe(viewLifecycleOwner){
            binding.tvDesc.text = it.brand.description
            binding.ivCompany.load(it.brand.banner)
            binding.ivLogo.load(it.brand.logo)
        }
        /*viewModel.getData().observe(viewLifecycleOwner){
            Log.e("MyStore","${listOf(it)}")
        }*/
    }

}