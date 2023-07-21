package com.curso.android.app.sartorimatias.proyectofinalintegrador.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.curso.android.app.sartorimatias.proyectofinalintegrador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.result.observe(this) {
            binding.result.text = "${it.text}"
        }

        binding.compareButton.setOnClickListener {
            val text1 = binding.text1.text.toString()
            val text2 = binding.text2.text.toString()
            mainViewModel.compareTexts(text1, text2)
        }
    }
}