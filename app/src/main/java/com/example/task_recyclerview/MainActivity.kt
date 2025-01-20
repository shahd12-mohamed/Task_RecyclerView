package com.example.task_recyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task_recyclerview.databinding.ActivityMainBinding
import com.example.task_recyclerview.ui.theme.Task_RecyclerViewTheme

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // إنشاء بيانات وهمية
        val books = mutableListOf(
            Book("One Hundred Years of Solitude", "Gabriel García Márquez", "solitude", 4.5f),
            Book("Terra Nostra", "Carlos Fuentes", "nostra", 4.0f),
            Book("Angels & Demons", "Dan Brown", "angels", 3.8f),
        )

        adapter = BookAdapter(books)
        binding.rvBooks.adapter = adapter
        binding.toolbar.toolbar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }
        binding.navigationView.setNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.Reviews -> {
                    Toast.makeText(this,R.string.Reviews,Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.Favorite -> {
                    Toast.makeText(this,R.string.Favorite,Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.search-> {
                    Toast.makeText(this,R.string.Search,Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.Profile-> {
                    Toast.makeText(this,R.string.profile,Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.Settings-> {
                    Toast.makeText(this,R.string.Setting,Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                else -> false
            }
        }

    }
}


