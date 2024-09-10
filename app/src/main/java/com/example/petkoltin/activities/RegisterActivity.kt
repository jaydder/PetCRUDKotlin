package com.example.petkoltin.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.petkoltin.R
import model.Pet
import service.PetService

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        val name: EditText = findViewById(R.id.registerName);
        val age: EditText = findViewById(R.id.registerAge);
        val bleed: EditText = findViewById(R.id.registerBleed);
        val btnRegister: Button = findViewById(R.id.btn_register);

        checkFields();
        btnRegister.setOnClickListener {
            val pet = Pet(name.text.toString(), age.text.toString().toInt(), bleed.text.toString());
            val petService = PetService(applicationContext);
            petService.create(pet);
            finish();
        }
    }
    private fun checkFields() {
        val name: EditText = findViewById(R.id.registerName);
        val age: EditText = findViewById(R.id.registerAge);
        val bleed: EditText = findViewById(R.id.registerBleed);

        name.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                if (name.text.isEmpty()) {
                    name.error = "Name is required"
                }
            }
        }
        age.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                if (age.text.isEmpty()) {
                    age.error = "Age is required"
                }
            }
        }
        bleed.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                if (bleed.text.isEmpty()) {
                    bleed.error = "Bleed is required"
                }
            }
        }
    }
}