package com.example.sallachallenge.ui.main

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.example.sallachallenge.databinding.MainFragmentBinding
import com.example.sallachallenge.models.DevelopersJson
import com.example.sallachallenge.paging.StorePagingAdapter
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import java.io.InputStream

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
        binding.rvMain.layoutManager = GridLayoutManager(context,2)
        binding.rvMain.setHasFixedSize(true)
        binding.rvMain.adapter = adapter
        val devJson = Gson().fromJson(jsonString(context), DevelopersJson::class.java)
        binding.dev = devJson
        viewModel.setHeader(devJson.id)
        viewModel.list.observe(viewLifecycleOwner){
            Log.e("MyStore","$it")
            adapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
        viewModel.getBrandData(devJson.id).observe(viewLifecycleOwner){
            binding.brand = it.brand
        }
    }

    private fun jsonString(context: Context?): String{
        val json :String?
        val inputStream: InputStream = context?.assets!!.open("Developers.json")
        json = inputStream.bufferedReader().use { it.readText() }
        inputStream.close()
        return json
    }



}