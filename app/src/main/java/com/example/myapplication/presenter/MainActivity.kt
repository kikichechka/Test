package com.example.myapplication.presenter

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.activityTabLayout.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        findNavController(R.id.nav_host_fragment_container).navigate(R.id.action_historyFragment_to_searchFragment)
                    }

                    1 -> {
                        findNavController(R.id.nav_host_fragment_container).navigate(R.id.action_searchFragment_to_historyFragment)
                    }
                }
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {}

            override fun onTabReselected(p0: TabLayout.Tab?) {}
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
