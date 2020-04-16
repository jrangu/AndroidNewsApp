package com.smartphone.topnews

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailScreenActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_detail_screen)
        val url = intent.getStringExtra("url")
        val title = intent.getStringExtra("title")
        val content = intent.getStringExtra("content")
        val text = findViewById<TextView>(R.id.Title)
        val image = findViewById<ImageView>(R.id.detailmageview)
        val text1 = findViewById<TextView>(R.id.content)
        text.text = title
        text1.text = content
        Glide.with(this).load(url).into(image)

    }
}