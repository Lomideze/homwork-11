package com.example.homwork11

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homwork11.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("FIRST_NAME")
        val lastName = intent.getStringExtra("LAST_NAME")

        if (lastName != null) {
            if (name != null) {
                if (name.isNotEmpty() || lastName.isNotEmpty()) {
                    binding.apply {
                        etSecondName.setText(name)
                        etSecondLastName.setText(lastName)
                    }
                }
            }
        }
    }
}