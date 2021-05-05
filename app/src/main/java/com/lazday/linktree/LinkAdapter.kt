package com.lazday.linktree

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LinkAdapter(
    private val items: List<LinktreeModel>,
    private val listener: AdapterListener,
): RecyclerView.Adapter<LinkAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.image)
        val title = itemView.findViewById<TextView>(R.id.title)

    }

    interface AdapterListener {
        fun onClick(link: LinktreeModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_link, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.image.setImageResource( item.image )
        holder.title.text = item.title
        holder.itemView.setOnClickListener {
            listener.onClick( item )
        }
    }

    override fun getItemCount() = items.size
}