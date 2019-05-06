package com.mglizerin.tuningfork.player

import android.content.Context
import android.media.AudioManager
import android.media.SoundPool
import com.mglizerin.tuningfork.player.util.calculateChordDuration
import com.mglizerin.tuningfork.sound.interfaces.*

/**
 * Воспроизводит [семплы][ISample]
 *
 * @param soundBank [Банк звуков][ISoundBank]
 * @param context [Context]
 */
class Player(
    private val soundBank: ISoundBank,
    private val context: Context
) : IPlayer {

    @Suppress("deprecation")
    private val mSoundPool = SoundPool(5, AudioManager.STREAM_MUSIC, 0)
    private var mLoadedSounds: MutableMap<IPitch, Int> = mutableMapOf()
    private var mActiveStreams: MutableList<Int> = mutableListOf()
    private var mIsPlaying = false

    init {
        soundBank.forEachSound { pitch, id ->
            val soundId = mSoundPool.load(context, id, 1)
            mLoadedSounds[pitch] = soundId
        }
    }

    override fun play(sample: ISample) {
        when {
            !mIsPlaying -> playSample(sample)
        }
    }

    private fun playSample(sample: ISample) {
        val playRunning = Runnable {
            mActiveStreams.clear()
            mIsPlaying = true

            sample.chords().forEach { chord ->
                playChord(chord)
                Thread.sleep(calculateChordDuration(sample.tempo(), chord))
                mSoundPool.autoPause()
            }

            mActiveStreams.forEach { mSoundPool.stop(it) }
            mIsPlaying = false
        }
        Thread(playRunning).start()
    }

    private fun playChord(chord: IChord) {
        chord.sounds().forEach {
            val id = mLoadedSounds[it.pitch()]
            when {
                id != null -> mActiveStreams.add(mSoundPool.play(id, 1f, 1f, 1, 0, 1f))
                else -> throw Exception("Loaded sound not found")
            }
        }
    }
}