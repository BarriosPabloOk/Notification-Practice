package com.pablobarriosdevs.notifications_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pablobarriosdevs.notifications_project.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}