package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.buttonGeneratePassword)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)

        seekBar?.setOnSeekBarChangeListener(object :
                SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                // write custom code for progress is stopped
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // write custom code for progress is stopped
                Toast.makeText(this@MainActivity,
                        "Changing String length from: ${seekBar.progress}",
                        Toast.LENGTH_SHORT).show()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // write custom code for progress is stopped
                Toast.makeText(this@MainActivity,
                        "New String length: ${seekBar.progress}",
                        Toast.LENGTH_SHORT).show()
            }
        })

        button.setOnClickListener {
            val randomString = generateRandomString(seekBar.progress)
            Toast.makeText(this, randomString, Toast.LENGTH_SHORT).show()
        }
    }

    private fun generateRandomString(length: Int): String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9') + ('α'..'ω') + ('Α'..'Ω')
        return (1..length)
                .map { allowedChars.random() }
                .joinToString("")
    }
}

