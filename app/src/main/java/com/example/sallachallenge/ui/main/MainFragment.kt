package com.example.sallachallenge.ui.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sallachallenge.SharedViewModel
import com.example.sallachallenge.databinding.MainFragmentBinding
import com.example.sallachallenge.models.developersjson.DevelopersJson
import com.example.sallachallenge.paging.StorePagingAdapter
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import java.io.InputStream

@AndroidEntryPoint
class MainFragment : Fragment() {


    private lateinit var binding: MainFragmentBinding
    private val viewModel by viewModels<MainViewModel>()
    private val sharedViewModel by activityViewModels<SharedViewModel>()
    private lateinit var adapter: StorePagingAdapter
    private lateinit var brandAdapter: BrandAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val devJson = Gson().fromJson(jsonString(context), DevelopersJson::class.java)
        binding.dev = devJson
        adapter = StorePagingAdapter(devJson.font_family)
        val layoutManager = GridLayoutManager(requireContext(), 2)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                if(position==0){
                    return 2
                }
                return  1
            }
        }
        binding.rvMain.layoutManager = layoutManager
        binding.rvMain.setHasFixedSize(true)
        sharedViewModel.jsonDevValue(devJson)
        viewModel.getItemData(devJson.id).observe(viewLifecycleOwner){
            Log.e("MyStore","$it")
            adapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
        viewModel.getBrandData(devJson.id).observe(viewLifecycleOwner){
            brandAdapter = BrandAdapter(listOf(it), devJson.font_family)
            val ca = ConcatAdapter()
            ca.addAdapter(brandAdapter)
            ca.addAdapter(adapter)
            binding.rvMain.adapter = ca
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