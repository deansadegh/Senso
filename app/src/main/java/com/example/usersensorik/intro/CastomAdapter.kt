package com.example.usersensorik.intro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.usersensorik.R

class castomAdapter(private val mList: List<listmodel>) : RecyclerView.Adapter<castomAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.imageView.setImageResource(itemsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.textView.text = itemsViewModel.text
        holder.textDescription.text = itemsViewModel.description

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView3)
        val textView: TextView = itemView.findViewById(R.id.text_title)
        val textDescription: TextView = itemView.findViewById(R.id.txt_description)
    }
}
