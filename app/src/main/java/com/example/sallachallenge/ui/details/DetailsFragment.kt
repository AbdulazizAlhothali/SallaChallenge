package com.example.sallachallenge.ui.details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.sallachallenge.databinding.DetailsFragmentBinding
import com.example.sallachallenge.models.developersjson.DevelopersJson
import com.google.gson.Gson
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import java.io.InputStream

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private val arg : DetailsFragmentArgs by navArgs()
    private lateinit var binding: DetailsFragmentBinding
    private val viewModel by viewModels<DetailsViewModel>()
    private lateinit var adapter: DetailsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        viewModel.getDetailsData("1328842359", arg.productID).observe(viewLifecycleOwner){
            adapter = DetailsAdapter(it.data.images)
            Log.e("details", "${it.data.images}")
            binding.vpDetails.adapter = adapter
        }
    }

}