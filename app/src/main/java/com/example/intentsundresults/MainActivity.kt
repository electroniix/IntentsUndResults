package com.example.intentsundresults

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var textview : TextView
    private lateinit var button : Button
    private val resultContract = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    {result: ActivityResult? ->
        if (result?.resultCode == Activity.RESULT_OK)
        {
            textview.text = result.data?.getStringExtra("text")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }
    private fun initViews()
    {
        textview = findViewById(R.id.text)
        button = findViewById(R.id.edit_button)
        button.setOnClickListener { onEditButtonClick() }
    }

    private fun onEditButtonClick()
    {
        val intent = Intent(this, EditActivity::class.java)
        intent.putExtra("text", textview.text.toString())
        resultContract.launch(intent)
    }

}