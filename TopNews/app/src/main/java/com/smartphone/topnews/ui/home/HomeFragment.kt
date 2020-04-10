package com.smartphone.topnews.ui.home

import android.os.Bundle
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
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.newsTextView.text = it
        })

        homeViewModel.newsResponse.observe(viewLifecycleOwner, Observer { newresponse ->
            binding.newsTextView.text = newresponse.newsDetails?.get(0)?.title
        })
        return binding.root
    }
}
