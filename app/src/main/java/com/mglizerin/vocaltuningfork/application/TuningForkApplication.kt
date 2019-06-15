package com.mglizerin.vocaltuningfork.application

import android.app.Application
import android.support.v7.app.AppCompatDelegate
import com.mglizerin.tuningfork.player.Player
import com.mglizerin.tuningfork.player.util.createDefaultSoundBank
import com.mglizerin.tuningfork.samples.createSamples
import com.mglizerin.tuningfork.sound.Key
import com.mglizerin.tuningfork.sound.Tempo
import com.mglizerin.tuningfork.sound.interfaces.IKey
import com.mglizerin.tuningfork.sound.interfaces.ISample
import com.mglizerin.tuningfork.sound.interfaces.ITempo
import com.mglizerin.tuningfork.sound.types.*

class TuningForkApplication: Application() {
    private val mSoundBank = createDefaultSoundBank()
    private lateinit var mPlayer: Player
    private lateinit var mSamples: List<ISample>

    private var mKey = Key(Note.G, Accidental.NATURAL, Mode.MAJOR)
    private var mTempo = Tempo(Beat.QUARTER, 90)

    init {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    fun tempo(): ITempo {
        return Tempo(mTempo.beat(), mTempo.beatsPerMinute())
    }

    fun setKey(key: IKey) {
        if (key != mKey) {
            mKey = Key(key.note(), key.accidental(), key.mode())
            createSamples()
        }
    }

    fun setTempo(beatsPerMinute: Int) {
        if (beatsPerMinute != mTempo.beatsPerMinute) {
            mTempo = Tempo(Beat.QUARTER, beatsPerMinute)
            createSamples()
        }
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        mPlayer = Player(mSoundBank, instance)
        createSamples()
    }

    private fun createSamples() {
        mSamples = createSamples(mKey, mTempo)
    }

    companion object {
        private lateinit var instance: TuningForkApplication

        fun play(sample: ISample) {
            instance.mPlayer.play(sample)
        }

        fun samples(): List<ISample> {
            return instance.mSamples
        }

        fun getApplication(): TuningForkApplication {
            return instance
        }
    }
}