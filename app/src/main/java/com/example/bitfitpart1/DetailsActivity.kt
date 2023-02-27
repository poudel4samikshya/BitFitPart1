package com.example.bitfitpart1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val recordFoodButton = findViewById<Button>(R.id.button)
        val foodVal = findViewById<EditText>(R.id.foodinfo)
        val calorieVal = findViewById<EditText>(R.id.calorieinfo)

        recordFoodButton.setOnClickListener {
            val food = foodVal.text.toString()
            val calories = calorieVal.text.toString()

            lifecycleScope.launch(IO) {
                (application as FoodApplication).db.ActivityDao().insert(
                    ActivityEntity(food, calories)
                )
            }
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

}