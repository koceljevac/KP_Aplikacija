package com.example.kupujemprodajemaplikacija

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kupujemprodajemaplikacija.databinding.ActivityMainBinding
import com.example.kupujemprodajemaplikacija.databinding.FragmentHomeBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
}