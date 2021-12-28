package com.mvi.sample.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mvi.sample.R
import com.mvi.sample.data.dto.TvShow
import kotlinx.android.synthetic.main.item_shows_layout.view.*


class ShowsAdapter(
    private val showsList: ArrayList<TvShow>
) : RecyclerView.Adapter<ShowsAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(show: TvShow) {
            itemView.tvShowName.text = show.name
            itemView.tvNetwork.text = show.network
            Glide.with(itemView.ivShow.context)
                .load(show.image_thumbnail_path)
                .into(itemView.ivShow)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_shows_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = showsList.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(showsList[position])

    fun addData(list: List<TvShow>) {
        showsList.addAll(list)
    }

}