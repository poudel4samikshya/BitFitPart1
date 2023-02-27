package com.example.bitfitpart1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


const val FOOD_EXTRA = "FOOD_EXTRA"
private const val TAG = "FoodAdapter"

class FoodAdapter(private val context: Context, private val foods: List<DisplayFoodItem>) :
    RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.food_item,parent,false)
        return ViewHolder(view)

    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // TODO: Get the individual article and bind to holder
        val food = foods[position]
        holder.bind(food)
    }

    override fun getItemCount() = foods.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val foodNTextView = itemView.findViewById<TextView>(R.id.fooditem)
        private val caloriesNTextView = itemView.findViewById<TextView>(R.id.caloriesview)
        fun bind(food: DisplayFoodItem) {

            foodNTextView.text = food.food
            caloriesNTextView.text = food.calories

        }



    }



}