package dev.serge.skincare.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.CircularProgressIndicator
import dev.serge.skincare.R

class DailyRoutineAdapter(
    private val list: List<DailyRoutine>
): RecyclerView.Adapter<DailyRoutineAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val image = view.findViewById<ImageView>(R.id.productImage)
        val type = view.findViewById<TextView>(R.id.typeText)
        val product = view.findViewById<TextView>(R.id.productName)
        val progress = view.findViewById<CircularProgressIndicator>(R.id.circularProgress)
        val progressText = view.findViewById<TextView>(R.id.progressText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_daily_routine,
                parent,
                false
            )

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = list[position]

        holder.image.setImageResource(item.image)
        holder.type.text = item.type
        holder.product.text = item.productName
        holder.progress.progress = item.percentage
        holder.progressText.text = "${item.percentage}%"
    }

    override fun getItemCount(): Int {
        return list.size
    }
}