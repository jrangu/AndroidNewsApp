package com.smartphone.topnews.network

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.smartphone.topnews.R
import kotlinx.android.synthetic.main.row.view.*


class RowAdapter(private val myDataset: List<NewsArticles>) :
    RecyclerView.Adapter<RowAdapter.MyViewHolder>() {

    // var imageUrl: String = ""

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RowAdapter.MyViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row, parent, false) as View

        // set the view's size, margins, paddings and layout parameters
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        //holder.view.label1.text = myDataset.get(position).publishedAt
        holder.view.label1.text = myDataset.get(position).title
        val imageUrl = myDataset.get(position).urlToImage.toString()
        if (imageUrl == null) {
            holder.view.imageview2.visibility = INVISIBLE
        } else {
            holder.view.imageview2.visibility = VISIBLE
            Glide.with(holder.view.context).load(imageUrl).into(holder.view.imageview2);
        }
        holder.view.cv.setOnClickListener {
        }
        holder.view.btnShare.setOnClickListener {
            val newsUrl = myDataset.get(position).url
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, newsUrl)
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            holder.view.context.startActivity(shareIntent)
        }


    }

    override fun getItemCount() = myDataset.size
}