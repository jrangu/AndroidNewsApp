package com.smartphone.topnews

import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity


class DetailScreenActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_detail_screen)
        val url = intent.getStringExtra("url")
//        val title = intent.getStringExtra("title")
//        val content = intent.getStringExtra("content")
//        val text = findViewById<TextView>(R.id.Title)
//        val image = findViewById<ImageView>(R.id.detailmageview)
//        val text1 = findViewById<TextView>(R.id.content)
//        text.text = title
//        text1.text = content
//        Glide.with(this).load(url).into(image)

        val webview = findViewById<WebView>(R.id.webview)
        Log.i("url",url)
        webview.webViewClient = WebViewClient()
        webview.settings.javaScriptEnabled = true
        webview.settings.domStorageEnabled = true
        webview.overScrollMode = WebView.OVER_SCROLL_NEVER
        webview.loadUrl(url)

    }
}