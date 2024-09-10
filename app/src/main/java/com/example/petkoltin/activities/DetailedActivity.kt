package com.example.petkoltin.activities

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.petkoltin.R
import com.example.petkoltin.databinding.ActivityDetailedBinding

class DetailedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        val intent = this.intent
        if (intent != null) {
            val name = intent.getStringExtra("name")
            val age =intent.getStringExtra("age")
            val breed = intent.getStringExtra("breed")

            val name_field = findViewById<TextView>(R.id.detailName)
            name_field.text = name

            val age_field = findViewById<TextView>(R.id.detailAge)
            age_field.text = age

            val breed_field = findViewById<TextView>(R.id.detailBreed)
            breed_field.text = breed

        }

    }
}