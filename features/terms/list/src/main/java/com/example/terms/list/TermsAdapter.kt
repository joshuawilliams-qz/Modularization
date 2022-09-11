package com.example.terms.list

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

internal class TermsAdapter(private val items: List<String>) :
    RecyclerView.Adapter<TermsAdapter.ViewHolder>() {

    class ViewHolder(private val view: TextView) : RecyclerView.ViewHolder(view) {

        fun bind(item: String) {
            view.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
