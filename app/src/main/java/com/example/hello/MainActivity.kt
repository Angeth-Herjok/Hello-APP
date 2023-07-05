package com.example.hello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.hello.databinding.ActivityLoginBinding
import com.example.hello.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
//    lateinit var tvLogin: TextView
//    lateinit var button: Button
//    lateinit var tilFirstName: TextInputLayout
//    lateinit var etFirstName: TextInputEditText
//    lateinit var tilLastName: TextInputLayout
//    lateinit var etLastName: TextInputEditText
//    lateinit var tilEmail: TextInputLayout
//    lateinit var etEmail: TextInputEditText
//    lateinit var tilPassword: TextInputLayout
//    lateinit var etPassword: TextInputEditText
//    lateinit var tilPasswordConfirmation: TextInputLayout
//    lateinit var etPasswordConfirmation: TextInputEditText
 lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_main)
        setContentView(binding.root)
//        castView()

//        binding.tvLogin = findViewById(R.id.tvLogin)
        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.button.setOnClickListener {
            validateSignUp()

        }
    }

//    fun castView() {
//        tvLogin = findViewById(R.id.tvLogin)
//        button = findViewById(R.id.button)
//        tilFirstName = findViewById(R.id.tilFirstName)
//        tilLastName = findViewById(R.id.tilLastName)
//        tilEmail = findViewById(R.id.tilEmail)
//        tilPassword = findViewById(R.id.tilPassword)
//        tilPasswordConfirmation = findViewById(R.id.tilpasswordConfirmation)
//        etFirstName = findViewById(R.id.etFirstName)
//        etLastName = findViewById(R.id.etLastName)
//        etEmail = findViewById(R.id.etEmail)
//        etPassword = findViewById(R.id.etPassword)
//        etPasswordConfirmation = findViewById(R.id.etPasswordConfirmation)

//    }

    fun validateSignUp() {
//        binding.tilLastName.error=null
        binding.tilLastName.error=null

        val firstName = binding.etFirstName.text.toString()
        val lastName = binding.etLastName.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        val passwordConfirmation = binding.etPasswordConfirmation.text.toString()
        var error=false

        if (firstName.isBlank()) {
            binding.tilFirstName.error = "first name required"
            error=true
        }
        if (lastName.isBlank()) {
            binding.tilLastName.error = "first name required"
            error=true
        }
        if (email.isBlank()) {
            binding.tilEmail.error = "first name required"
            error=true
        }
        if (password.isBlank()) {
            binding.tilPassword.error = "first name required"
            error=true
        }
        if (passwordConfirmation.isBlank()) {
           binding.tilpasswordConfirmation.error = "first name required"
            error=true
        }
        if (password!=passwordConfirmation){
            binding.tilpasswordConfirmation.error="password confirmation does not match password"
            error=true
        }
        if (!error){
            Toast.makeText(this,"$firstName $lastName $email",Toast.LENGTH_LONG).show()
        }
    }
}