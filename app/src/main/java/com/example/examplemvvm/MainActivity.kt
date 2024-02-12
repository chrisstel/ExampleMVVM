package com.example.examplemvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.examplemvvm.databinding.ActivityMainBinding
import com.example.examplemvvm.viewmodel.MainViewModel
import com.example.examplemvvm.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, MainViewModelFactory(this))[MainViewModel::class.java]

        viewModel.getUserLiveData().observe(this) {
            binding.tvUsername.text = it.username
            binding.tvEmail.text = it.email
        }

        binding.btnSave.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val email = binding.etEmail.text.toString()
            viewModel.save(username, email)
        }

        binding.btnLoad.setOnClickListener {
            viewModel.load()
        }
    }
}