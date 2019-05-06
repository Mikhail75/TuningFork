package com.mglizerin.vocaltuningfork

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mglizerin.vocaltuningfork.application.TuningForkApplication

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            TuningForkApplication.playTest()
        }
    }
}
