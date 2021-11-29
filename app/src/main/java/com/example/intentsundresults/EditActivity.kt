package com.example.intentsundresults

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class EditActivity : AppCompatActivity() {
    private lateinit var editView : EditText
    private lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        initViews()
    }
    private fun initViews()
    {
        editView = findViewById(R.id.text)
        editView.setText(intent.getStringExtra("text"))
        button = findViewById(R.id.save_button)
        button.setOnClickListener { onSaveButtonClick() }
    }

    private fun onSaveButtonClick()
    {
        var resultIntent = Intent()
        resultIntent.putExtra("text", editView.text.toString())
        setResult(RESULT_OK, resultIntent)
        finish()
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }
}