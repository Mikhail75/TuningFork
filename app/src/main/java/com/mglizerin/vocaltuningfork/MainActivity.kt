package com.mglizerin.vocaltuningfork

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import com.mglizerin.vocaltuningfork.application.TuningForkApplication

class MainActivity : AppCompatActivity() {
    private lateinit var mTempoTextView: TextView
    private lateinit var mTempoSeekBar: SeekBar

    val mTempoMinValue = 30
    val mTempoMaxValue = 180

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTempoTextView = findViewById(R.id.tempoTextView)
        mTempoSeekBar = findViewById(R.id.tempoSeekBar)

        initChangeTempoButtons()
        initTempoTextView()
        initTempoSeekBar()

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            startActivity(Intent(this, SamplesActivity::class.java))
        }
    }

    private fun initChangeTempoButtons() {
        addChangeTempoButtonListener(findViewById(R.id.beat60button), 60)
        addChangeTempoButtonListener(findViewById(R.id.beat90button), 90)
        addChangeTempoButtonListener(findViewById(R.id.beat120button), 120)
    }

    private fun addChangeTempoButtonListener(button: Button, value: Int) {
        button.setOnClickListener {
            onTempoChanged(value)
        }
    }

    private fun initTempoTextView() {
        val tempo = TuningForkApplication.getApplication().tempo()
        mTempoTextView.text = tempo.beatsPerMinute().toString()
    }

    private fun initTempoSeekBar() {
        val tempo = TuningForkApplication.getApplication().tempo()

        mTempoSeekBar.max = mTempoMaxValue - mTempoMinValue
        mTempoSeekBar.progress = tempo.beatsPerMinute() - mTempoMinValue

        mTempoSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mTempoTextView.text = (progress + mTempoMinValue).toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) = Unit

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                if (seekBar != null) {
                    onTempoChanged(seekBar.progress + mTempoMinValue)
                }
            }

        })
    }

    private fun onTempoChanged(value: Int) {
        mTempoTextView.text = value.toString()
        mTempoSeekBar.progress = value - mTempoMinValue

        TuningForkApplication.getApplication().setTempo(value)
    }
}
