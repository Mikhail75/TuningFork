package com.mglizerin.tuningfork.samples

import com.mglizerin.tuningfork.samples.presets.createGDurSamples
import com.mglizerin.tuningfork.sound.Key
import com.mglizerin.tuningfork.sound.interfaces.IKey
import com.mglizerin.tuningfork.sound.interfaces.ISample
import com.mglizerin.tuningfork.sound.interfaces.ITempo
import com.mglizerin.tuningfork.sound.types.Accidental
import com.mglizerin.tuningfork.sound.types.Mode
import com.mglizerin.tuningfork.sound.types.Note

fun createSamples(key: IKey, tempo: ITempo): List<ISample> = when (key) {
        Key(Note.G, Accidental.NATURAL, Mode.MAJOR) -> createGDurSamples(tempo)
        Key(Note.D, Accidental.NATURAL, Mode.MAJOR) -> TODO()
        else -> error("cannot create sample")
    }
