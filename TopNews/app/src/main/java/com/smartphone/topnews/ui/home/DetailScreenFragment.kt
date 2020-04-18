package com.smartphone.topnews.ui.home

import android.content.Intent.getIntent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import com.smartphone.topnews.R
import com.smartphone.topnews.databinding.FragmentDetailScreenBinding

/**
 * A simple [Fragment] subclass.
 */
class DetailScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val url = this.arguments?.getString("url")
        val binding = DataBindingUtil.inflate<FragmentDetailScreenBinding>(inflater, R.layout.fragment_detail_screen,container,false)
        binding.webview.webViewClient = WebViewClient()
       binding.webview.settings.javaScriptEnabled = true
        binding.webview.settings.domStorageEnabled = true
        binding.webview.overScrollMode = WebView.OVER_SCROLL_NEVER
        binding.webview.loadUrl(url)

        return binding.root
    }

}
