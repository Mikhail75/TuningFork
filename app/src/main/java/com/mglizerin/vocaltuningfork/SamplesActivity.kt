package com.mglizerin.vocaltuningfork

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Space
import android.widget.Toast
import com.mglizerin.tuningfork.staff.StaffGrid
import com.mglizerin.tuningfork.staff.StaffGridParams
import com.mglizerin.vocaltuningfork.application.TuningForkApplication

class SamplesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_samples)

        addStaffButtons()
    }

    private fun addStaffButtons() {
        val resources = TuningForkApplication.getApplication().resources
        val layout = findViewById<LinearLayout>(R.id.samples_container)

        val samples = TuningForkApplication.samples()
        val staffGrid = StaffGrid(StaffGridParams())

        for (sample in samples) {
            val staffButton = StaffButton(this, resources, staffGrid, sample)
            staffButton.setOnClickListener {
                TuningForkApplication.play(sample)
            }
            layout.addView(staffButton)
            addSpace(layout)
        }
    }

    private fun addSpace(layout: LinearLayout) {
        val space = Space(this)
        space.minimumHeight = 16
        layout.addView(space)
    }
}