package com.smartphone.topnews

import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.smartphone.topnews.ui.home.DetailScreenFragment


class DetailScreenActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_screen)
        val url = intent.getStringExtra("url")
//        val title = intent.getStringExtra("title")
//        val content = intent.getStringExtra("content")
//        val text = findViewById<TextView>(R.id.Title)
//        val image = findViewById<ImageView>(R.id.detailmageview)
//        val text1 = findViewById<TextView>(R.id.content)
//        text.text = title
//        text1.text = content
//        Glide.with(this).load(url).into(image)
        if (savedInstanceState == null) {
            Log.i("inside","safghsdf")
            val fragment = DetailScreenFragment()
            val manager= supportFragmentManager
            val t = manager.beginTransaction()
            val b = Bundle();
            b.putString("url", url)
            fragment.arguments = b
            t.add(R.id.main_content, fragment)
                t.commit()
        }

    }
}