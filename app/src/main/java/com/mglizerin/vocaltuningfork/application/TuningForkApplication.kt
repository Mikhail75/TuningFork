package com.mglizerin.vocaltuningfork.application

import android.app.Application
import android.support.v7.app.AppCompatDelegate
import com.mglizerin.tuningfork.player.Player
import com.mglizerin.tuningfork.player.util.createDefaultSoundBank

class TuningForkApplication: Application() {
    private val mSoundBank = createDefaultSoundBank()
    private lateinit var mPlayer: Player

    init {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
        mPlayer = Player(mSoundBank, instance)
    }

    companion object {
        private lateinit var instance: TuningForkApplication

        fun playTest() {
            instance.mPlayer.play(createTestSample())
        }

        fun getApplication(): TuningForkApplication {
            return instance
        }
    }
}