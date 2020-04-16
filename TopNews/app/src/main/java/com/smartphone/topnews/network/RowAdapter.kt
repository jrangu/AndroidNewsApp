package com.smartphone.topnews.network

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.smartphone.topnews.R
import kotlinx.android.synthetic.main.row.view.*


class RowAdapter(private val myDataset: List<NewsArticles>) :
    RecyclerView.Adapter<RowAdapter.MyViewHolder>() {

    var imageUrl: String = ""

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RowAdapter.MyViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row, parent, false) as View
        Glide.with(parent.context).load(imageUrl).into(view.imageview2);
        // set the view's size, margins, paddings and layout parameters
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        //holder.view.label1.text = myDataset.get(position).publishedAt
        holder.view.label1.text = myDataset.get(position).title
        imageUrl = myDataset.get(position).urlToImage.toString()
        holder.view.cv.setOnClickListener {

        }
        holder.view.btnShare.setOnClickListener {
            holder.view.label1.text = "testing"
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            //startActivity(shareIntent)
        }


    }

    override fun getItemCount() = myDataset.size
}