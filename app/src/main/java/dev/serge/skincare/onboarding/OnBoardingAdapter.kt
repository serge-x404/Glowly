package dev.serge.skincare.onboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.serge.skincare.R

class OnBoardingAdapter(
    private val list: List<OnBoardingDataClass>,
    private val onNextClick: () -> Unit
): RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    class OnBoardingViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.onBoardingImage)
        val text = view.findViewById<TextView>(R.id.onBoardingText)
        val buttonText = view.findViewById<TextView>(R.id.onBoardingButtonText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_onboarding,
                parent,
                false
            )
        return OnBoardingViewHolder(view)
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        val item = list[position]

        holder.image.setImageResource(item.image)
        holder.text.text = item.text
        holder.buttonText.text = item.buttonContent
        holder.buttonText.setOnClickListener {
            onNextClick()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}