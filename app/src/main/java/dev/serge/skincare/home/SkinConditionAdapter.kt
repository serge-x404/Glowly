package dev.serge.skincare.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.serge.skincare.R

class SkinConditionAdapter(
    private val list: List<SkinCondition>
): RecyclerView.Adapter<SkinConditionAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.titleText)
        val percentage = view.findViewById<TextView>(R.id.percentageText)
        val status = view.findViewById<TextView>(R.id.statusText)
        val progress = view.findViewById<ProgressBar>(R.id.progressBar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_skin_condition,
                parent,
                false
            )

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.title.text = item.title
        holder.percentage.text = "${item.percentage}%"
        holder.status.text = item.status
        holder.progress.progress = item.percentage
    }

    override fun getItemCount(): Int {
        return list.size
    }
}