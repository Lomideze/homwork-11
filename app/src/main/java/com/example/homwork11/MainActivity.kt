package com.example.homwork11

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.homwork11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnItemClick {

    private lateinit var binding: ActivityMainBinding

    private val list = mutableListOf<ItemData>()
    private val adapter = ItemAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            recycleView.adapter = adapter
            recycleView.layoutManager = GridLayoutManager(applicationContext, 2)

            btnAdd.setOnClickListener {
                addBtn()
            }
        }


    }

    private fun addBtn() {
        binding.apply {
            val firstName = etFirstName.text.toString()
            val lastName = etLastName.text.toString()

            if (firstName.isNotEmpty() || lastName.isNotEmpty()) {
                list.add(ItemData("$firstName", "$lastName", whichImage(), R.drawable.ic_trash))
                adapter.setItems(list)

                etFirstName.setText("")
                etLastName.setText("")
            }
        }
    }

    private fun whichImage(): Int {
        val car: RadioButton = binding.rbCar
        return if (car.isChecked) {
            R.drawable.ic_car
        } else
            R.drawable.ic_bike
    }

    override fun onItemClicked(position: Int) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("FIRST_NAME", list[position].firstName)
        intent.putExtra("LAST_NAME", list[position].lastname)
        startActivity(intent)
    }

}
