package com.smartphone.topnews.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.smartphone.topnews.R
import com.smartphone.topnews.databinding.FragmentHomeBinding
import com.smartphone.topnews.network.RowAdapter


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater, R.layout.fragment_home,container,false)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
                //ViewModelProviders.of(this).get(HomeViewModel::class.java)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            binding.newsTextView.text = "Today"
//        })
        val type = arguments?.getString("type")
        if(type == null){
            homeViewModel.getTopBusinessNews("")
        }else{
            homeViewModel.getTopBusinessNews(type.toString())
        }
        homeViewModel.newsResponse.observe(viewLifecycleOwner, Observer { newresponse ->
            binding.newsTextView.text = "Today"
            val list = newresponse.newsDetails
            val adapter1 = list?.let { RowAdapter(it)}
            binding.list.adapter = adapter1
        })
        return binding.root
    }
}
