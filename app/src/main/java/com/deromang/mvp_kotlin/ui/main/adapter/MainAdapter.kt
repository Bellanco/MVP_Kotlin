package com.deromang.mvp_kotlin.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.deromang.domain.data.ResultModel
import com.deromang.mvp_kotlin.R
import kotlinx.android.synthetic.main.main_list_item.view.*

class MainAdapter(
    private val items: List<ResultModel>?,
    private val context: Context?,
    val listener: OnClickListener
) :
    RecyclerView.Adapter<ViewHolder>() {

    // Gets the number of items in the list
    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.main_list_item,
                parent,
                false
            )
        )
    }

    // Binds each item in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        items?.get(position)?.let { result ->
            holder.tvItem.text = result.title
            holder.tvDescription.text = result.overview
            holder.tvPopularity.text = result.popularity.toString()
            holder.ivFavourite.setOnClickListener {
                listener.onClick(result)
            }
        }
    }

    interface OnClickListener {
        fun onClick(model: ResultModel)
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val tvItem: TextView = view.tvItem
    val tvDescription: TextView = view.tvDescription
    val tvPopularity: TextView = view.tvPopularity
    val ivFavourite: ImageView = view.ivFavourite
}

