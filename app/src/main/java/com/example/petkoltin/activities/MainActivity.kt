package com.example.petkoltin.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.petkoltin.R
import com.example.petkoltin.activities.adapters.ListAdapter
import model.Pet
import service.PetService

class MainActivity : AppCompatActivity() {


    lateinit var petService: PetService
    lateinit var dataArrayList: ArrayList<Pet?>
    lateinit var listAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btn_register: Button = findViewById(R.id.register);
        btn_register.setOnClickListener {
            val i = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(i)
        }

        petService = PetService(this)
        dataArrayList = petService.getAll()
        listAdapter = ListAdapter(this, dataArrayList)
        displayListView()

    }

    override fun onRestart() {
        super.onRestart()
        Log.d("RESTART", "TA NA BAGACA")
        petService = PetService(this)
        dataArrayList = petService.getAll()
        listAdapter = ListAdapter(this, dataArrayList)
        displayListView()
    }

    fun displayListView() {
        val listview = findViewById<ListView>(R.id.listview)
        listview.adapter = listAdapter
        listview.isClickable = true

        if (dataArrayList.isEmpty()) {
            val emptyText = findViewById<TextView>(R.id.emptyText)
            emptyText.visibility = View.VISIBLE
            emptyText.text = "Pets not Found"
            listview.visibility = View.INVISIBLE
        } else {
            listview.onItemClickListener = AdapterView.OnItemClickListener { _, _, i, _ ->
                val intent = Intent(applicationContext, DetailedActivity::class.java)
                intent.putExtra("name", dataArrayList[i]!!.name)
                intent.putExtra("age", dataArrayList[i]!!.age)
                intent.putExtra("breed", dataArrayList[i]!!.breed)
                startActivity(intent)
            }
        }

    }
}