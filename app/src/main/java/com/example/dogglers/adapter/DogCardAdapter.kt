package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout
import com.example.dogglers.data.DataSource.dogs
import com.example.dogglers.model.Dog

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
) : RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    private val dataSet: List<Dog> = dogs

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        val imageView: ImageView = view!!.findViewById(R.id.dog_image)
        val textViewName: TextView = view!!.findViewById(R.id.dog_name)
        val textViewAge: TextView = view!!.findViewById(R.id.dog_age)
        val textViewHobby: TextView = view!!.findViewById(R.id.dog_hobby)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        val layoutId: Int

        if (layout == Layout.GRID) {
            layoutId = R.layout.grid_list_item
        } else {
            layoutId = R.layout.vertical_horizontal_list_item
        }

        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(layoutId, parent, false)

        return DogCardViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        val item = dataSet[position]
        val resource = context?.resources
        holder.imageView.setImageResource(item.imageResourceId)
        holder.textViewName.text = item.resourceName

        holder.textViewAge.text = item.age
        holder.textViewHobby.text = item.hobbies
    }
}
