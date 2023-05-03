package com.assignment.buzzware

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.assignment.buzzware.model.ApiStates
import com.assignment.buzzware.views.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val viewModel:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvEmail=findViewById<EditText>(R.id.editTextTextPersonName)
        val tvpass=findViewById<EditText>(R.id.editTextTextPersonName2)
val btn=findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            viewModel.loginUser("satextile2050@gmail.com", "49593303")

            lifecycleScope.launchWhenStarted {
                viewModel.loginState.collect {
                    when (it) {
                        is ApiStates.Loading -> {
                            Log.d("TAG", "onCreate: loading")

                        }
                        is ApiStates.Failure -> {
                            Log.d("TAG", "onCreate: ${it.msg}")
                        }
                        is ApiStates.Success -> {
                            Log.d("TAG", "onCreate: Success")
                            Log.d("TAG", "onCreate: ${it.data?.msg}")
                            Toast.makeText(applicationContext, "Suucess", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
}