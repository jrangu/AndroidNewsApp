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
import com.bumptech.glide.Glide
//import androidx.lifecycle.ViewModelProviders
import com.smartphone.topnews.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {


        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
                //ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        val newsTextView: TextView = root.findViewById(R.id.newsTextView)
        homeViewModel.newsResponse.observe(viewLifecycleOwner, Observer { newresponse ->
            newsTextView.text = newresponse.newsDetails?.get(0)?.title
        })
        return root
    }
}
