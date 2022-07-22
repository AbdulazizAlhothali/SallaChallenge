package com.example.sallachallenge.ui.details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.sallachallenge.R
import com.example.sallachallenge.databinding.DetailsFragmentBinding
import com.example.sallachallenge.databinding.MainFragmentBinding
import com.example.sallachallenge.models.DevelopersJson
import com.example.sallachallenge.paging.StorePagingAdapter
import com.example.sallachallenge.ui.main.MainViewModel
import com.google.gson.Gson
import java.io.InputStream

class DetailsFragment : Fragment() {

    private lateinit var binding: DetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var json :String? = null
        val inputStream: InputStream = context?.assets!!.open("Developers.json")
        json = inputStream.bufferedReader().use { it.readText() }
        inputStream.close()
        Log.e("json", "${json}")
        val devJson = Gson().fromJson(json,DevelopersJson::class.java)
        Log.e("json", "${devJson.store}")

    }

}