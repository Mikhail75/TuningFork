package com.mglizerin.tuningfork.player.util

import com.mglizerin.tuningfork.R
import com.mglizerin.tuningfork.sound.Pitch
import com.mglizerin.tuningfork.sound.SoundBank
import com.mglizerin.tuningfork.sound.interfaces.IPitch
import com.mglizerin.tuningfork.sound.interfaces.ISoundBank
import com.mglizerin.tuningfork.sound.types.*

fun createDefaultSoundBank(): ISoundBank {
    val defaultSounds: Map<IPitch, Int> = mapOf(
        Pitch(Note.G, Accidental.NATURAL, 3) to R.raw.f_43,
        Pitch(Note.A, Accidental.NATURAL, 3) to R.raw.f_45,
        Pitch(Note.B, Accidental.NATURAL, 3) to R.raw.f_47,
        Pitch(Note.C, Accidental.NATURAL, 4) to R.raw.f_48,
        Pitch(Note.D, Accidental.NATURAL, 4) to R.raw.f_50,
        Pitch(Note.E, Accidental.NATURAL, 4) to R.raw.f_52,
        Pitch(Note.F, Accidental.NATURAL, 4) to R.raw.f_53,
        Pitch(Note.G, Accidental.NATURAL, 4) to R.raw.f_55,
        Pitch(Note.A, Accidental.NATURAL, 4) to R.raw.f_57,
        Pitch(Note.B, Accidental.NATURAL, 4) to R.raw.f_59,
        Pitch(Note.C, Accidental.NATURAL, 5) to R.raw.f_60,
        Pitch(Note.D, Accidental.NATURAL, 5) to R.raw.f_62,
        Pitch(Note.E, Accidental.NATURAL, 5) to R.raw.f_64,
        Pitch(Note.F, Accidental.NATURAL, 5) to R.raw.f_65,
        Pitch(Note.G, Accidental.NATURAL, 5) to R.raw.f_67,

        Pitch(Note.G, Accidental.SHARP, 3) to R.raw.f_44,
        Pitch(Note.A, Accidental.SHARP, 3) to R.raw.f_46,
        Pitch(Note.B, Accidental.SHARP, 3) to R.raw.f_48,
        Pitch(Note.C, Accidental.SHARP, 4) to R.raw.f_49,
        Pitch(Note.D, Accidental.SHARP, 4) to R.raw.f_51,
        Pitch(Note.E, Accidental.SHARP, 4) to R.raw.f_53,
        Pitch(Note.F, Accidental.SHARP, 4) to R.raw.f_54,
        Pitch(Note.G, Accidental.SHARP, 4) to R.raw.f_56,
        Pitch(Note.A, Accidental.SHARP, 4) to R.raw.f_58,
        Pitch(Note.B, Accidental.SHARP, 4) to R.raw.f_60,
        Pitch(Note.C, Accidental.SHARP, 5) to R.raw.f_61,
        Pitch(Note.D, Accidental.SHARP, 5) to R.raw.f_63,
        Pitch(Note.E, Accidental.SHARP, 5) to R.raw.f_65,
        Pitch(Note.F, Accidental.SHARP, 5) to R.raw.f_66,
        Pitch(Note.G, Accidental.SHARP, 5) to R.raw.f_68,

        Pitch(Note.A, Accidental.FLAT, 3) to R.raw.f_44,
        Pitch(Note.B, Accidental.FLAT, 3) to R.raw.f_46,
        Pitch(Note.C, Accidental.FLAT, 4) to R.raw.f_47,
        Pitch(Note.D, Accidental.FLAT, 4) to R.raw.f_49,
        Pitch(Note.E, Accidental.FLAT, 4) to R.raw.f_51,
        Pitch(Note.F, Accidental.FLAT, 4) to R.raw.f_52,
        Pitch(Note.G, Accidental.FLAT, 4) to R.raw.f_54,
        Pitch(Note.A, Accidental.FLAT, 4) to R.raw.f_56,
        Pitch(Note.B, Accidental.FLAT, 4) to R.raw.f_58,
        Pitch(Note.D, Accidental.FLAT, 5) to R.raw.f_61,
        Pitch(Note.E, Accidental.FLAT, 5) to R.raw.f_63,
        Pitch(Note.F, Accidental.FLAT, 5) to R.raw.f_64,
        Pitch(Note.G, Accidental.FLAT, 5) to R.raw.f_66,
        Pitch(Note.A, Accidental.FLAT, 5) to R.raw.f_68
    )

    val soundBank = SoundBank()

    defaultSounds.forEach{ (key, value) ->
        soundBank.addSound(key, value)
    }

    return soundBank
}