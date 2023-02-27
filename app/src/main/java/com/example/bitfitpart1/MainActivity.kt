package com.example.bitfitpart1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import com.example.bitfitpart1.databinding.ActivityMainBinding

private const val TAG = "MainActivity"

class MainActivity:AppCompatActivity() {

    private val foods = mutableListOf<DisplayFoodItem>()
    private lateinit var foodsRecyclerView: RecyclerView
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        foodsRecyclerView = findViewById(R.id.food_items)

        val foodAdapter = FoodAdapter(this,foods)
        foodsRecyclerView.adapter = foodAdapter


        lifecycleScope.launch {
            (application as FoodApplication).db.ActivityDao().getAll().collect{ databaseList ->
                databaseList.map {entity ->
                    DisplayFoodItem(
                        entity.food,
                        entity.calories

                    )
                }.also { mappedList ->
//                    foods.clear()
                    foods.addAll(mappedList)
                    foodAdapter.notifyDataSetChanged()
                }
            }

        }
        foodsRecyclerView.layoutManager = LinearLayoutManager(this).also {
            val dividerItemDecoration = DividerItemDecoration(this, it.orientation)
            foodsRecyclerView.addItemDecoration(dividerItemDecoration)
        }
        val addNewFButton = findViewById<Button>(R.id.button2)
        addNewFButton.setOnClickListener{
            val intent = Intent(this@MainActivity,DetailsActivity::class.java)


            startActivity(intent)

        }

    }
}