package com.mglizerin.tuningfork.samples.presets

import com.mglizerin.tuningfork.samples.*
import com.mglizerin.tuningfork.sound.Key
import com.mglizerin.tuningfork.sound.Sample
import com.mglizerin.tuningfork.sound.interfaces.ISample
import com.mglizerin.tuningfork.sound.interfaces.ITempo
import com.mglizerin.tuningfork.sound.types.Accidental
import com.mglizerin.tuningfork.sound.types.Mode
import com.mglizerin.tuningfork.sound.types.Note

fun createGDurSamples(tempo: ITempo): List<ISample> {
    val key = Key(Note.G, Accidental.NATURAL, Mode.MAJOR)
    val samples = mutableListOf<ISample>()

    val data = listOf(
        listOf(D5_Q, B4_Q, G4_H),
        listOf(G4_Q, B4_Q, D5_Q, B4_Q, G4_H),
        listOf(G4_Q, B4_Q, G4_Q, A4_Q, F4S_Q, D4_H),
        listOf(C5_Q,A4_Q, F4S_Q, D4_H)
    )

    data.forEach { chord ->
        samples.add(Sample(tempo, key, chord))
    }

    return samples
}