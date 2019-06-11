package com.mglizerin.vocaltuningfork

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.mglizerin.tuningfork.staff.StaffGrid
import com.mglizerin.tuningfork.staff.StaffGridParams
import com.mglizerin.vocaltuningfork.application.TuningForkApplication
import com.mglizerin.vocaltuningfork.application.createTestSample
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resources = TuningForkApplication.getApplication().resources
        val staffGrid = StaffGrid(StaffGridParams())

        val staffButton = StaffButton(this, resources, staffGrid, createTestSample())
        staffButton.setOnClickListener {
            Toast.makeText(this, "Staff button pushed!", Toast.LENGTH_SHORT).show()
        }

        root_layout.addView(staffButton)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            TuningForkApplication.playTest()
        }
    }
}
