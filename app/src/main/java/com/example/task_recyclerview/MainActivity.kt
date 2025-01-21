package com.example.task_recyclerview

import android.graphics.PorterDuff
import android.os.Bundle
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val books = mutableListOf(
            Book("One Hundred Years of Solitude", "Gabriel García Márquez", "solitude", 4.5f),
            Book("Terra Nostra", "Carlos Fuentes", "nostra", 4.0f),
            Book("Angels & Demons", "By Dan Brown", "angels", 3.8f),
            Book("The Sword Thief", "By peter Lerangis", "sword", 4.2f),
            Book("Inferno", "By Dan Brown", "angles", 4.6f),
            Book("Bloodline", "By James Rollins", "blood", 4.1f),
            Book("The House of spirits", "By Lsabel Allend", "spirits", 4.3f),
            Book("The Hummingbird's Daughter", "By Luis Alberto Umea", "humming", 4.4f),
        )
        binding.rvBooks.layoutManager = LinearLayoutManager(this)
        binding.rvBooks.adapter = BookAdapter(books)

        binding.toolbar.toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.notificationIcon -> {
                    Toast.makeText(this, R.string.notification, Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        binding.toolbar.toolbar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }

        binding.toolbar.toolbar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }
        binding.navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.Reviews -> {
                    Toast.makeText(this, R.string.Reviews, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }

                R.id.Favorite -> {
                    Toast.makeText(this, R.string.Favorite, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }

                R.id.search -> {
                    Toast.makeText(this, R.string.Search, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }

                R.id.Profile -> {
                    Toast.makeText(this, R.string.profile, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }

                R.id.Settings -> {
                    Toast.makeText(this, R.string.Setting, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }

                else -> false
            }
        }
    }
}