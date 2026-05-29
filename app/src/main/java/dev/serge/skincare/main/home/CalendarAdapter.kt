package dev.serge.skincare.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.serge.skincare.R

class CalendarAdapter(
    private val list: List<Calendar>
): RecyclerView.Adapter<CalendarAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val container = view.findViewById<LinearLayout>(R.id.calendarItem)
        val day = view.findViewById<TextView>(R.id.dayText)
        val date = view.findViewById<TextView>(R.id.dateText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_calendar,
                parent,
                false
            )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = list[position]

        holder.day.text = item.day
        holder.date.text = item.date
        holder.container.isSelected = item.isSelected

        holder.itemView.setOnClickListener {
            list.forEach {
                it.isSelected = false
            }

            item.isSelected = true

            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}