package com.example.bitfitpart1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import com.example.bitfitpart1.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val TAG = "MainActivity"

class MainActivity:AppCompatActivity() {

    private val foods = mutableListOf<DisplayFoodItem>()
    //private lateinit var foodsRecyclerView: RecyclerView
    //private lateinit var binding: ActivityMainBinding
    private lateinit var binding: LayoutInflater



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addNewFButton = findViewById<Button>(R.id.button2)
        //val : Fragment = FoodListFragment()
        //val foodListFragment: Fragment = DashboardFragment()
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { item ->
            lateinit var fragment: Fragment
            when (item.itemId) {
                R.id.graph_icon -> fragment =  DashboardFragment()
                R.id.list_icon -> fragment = FoodListFragment()
            }
            replaceFragment(fragment)
            true
        }
        bottomNavigationView.selectedItemId = R.id.list_icon
        addNewFButton.setOnClickListener{
            val intent = Intent(this@MainActivity,DetailsActivity::class.java)


            startActivity(intent)

        }
    }
    private fun replaceFragment(foodListFragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.logs_frame_layout, foodListFragment)
        fragmentTransaction.commit()
    }
}