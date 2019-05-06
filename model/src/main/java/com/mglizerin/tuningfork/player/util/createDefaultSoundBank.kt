package com.mglizerin.tuningfork.player.util

import com.mglizerin.tuningfork.R
import com.mglizerin.tuningfork.sound.Pitch
import com.mglizerin.tuningfork.sound.SoundBank
import com.mglizerin.tuningfork.sound.interfaces.IPitch
import com.mglizerin.tuningfork.sound.interfaces.ISoundBank
import com.mglizerin.tuningfork.sound.types.*

fun createDefaultSoundBank(): ISoundBank {
    val defaultSounds: Map<IPitch, Int> = mapOf(
        Pitch(Note.D, Accidental.NATURAL, 4) to R.raw.d4,
        Pitch(Note.F, Accidental.SHARP, 4) to R.raw.fis4,
        Pitch(Note.A, Accidental.NATURAL, 4) to R.raw.a4,
        Pitch(Note.D, Accidental.NATURAL, 5) to R.raw.d5
    )

    val soundBank = SoundBank()

    defaultSounds.forEach{ (key, value) ->
        soundBank.addSound(key, value)
    }

    return soundBank
}