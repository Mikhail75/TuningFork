package com.mglizerin.tuningfork.samples

import com.mglizerin.tuningfork.samples.presets.*
import com.mglizerin.tuningfork.sound.Key
import com.mglizerin.tuningfork.sound.Sample
import com.mglizerin.tuningfork.sound.interfaces.IChord
import com.mglizerin.tuningfork.sound.interfaces.IKey
import com.mglizerin.tuningfork.sound.interfaces.ISample
import com.mglizerin.tuningfork.sound.interfaces.ITempo
import com.mglizerin.tuningfork.sound.types.Accidental
import com.mglizerin.tuningfork.sound.types.Mode
import com.mglizerin.tuningfork.sound.types.Note

fun createSamples(key: IKey, tempo: ITempo): List<ISample> {
    fun createSamplesImpl(sampleList: List<List<IChord>>): List<ISample> {
        val samples = mutableListOf<ISample>()

        sampleList.forEach { chords ->
            samples.add(Sample(tempo, key, chords))
        }

        return samples
    }

    return when (key) {
        Key(Note.B, Accidental.FLAT, Mode.MAJOR) -> createSamplesImpl(B_DUR_SAMPLES)
        Key(Note.F, Accidental.NATURAL, Mode.MAJOR) -> createSamplesImpl(F_DUR_SAMPLES)
        Key(Note.C, Accidental.NATURAL, Mode.MAJOR) -> createSamplesImpl(C_DUR_SAMPLES)
        Key(Note.G, Accidental.NATURAL, Mode.MAJOR) -> createSamplesImpl(G_DUR_SAMPLES)
        Key(Note.D, Accidental.NATURAL, Mode.MAJOR) -> createSamplesImpl(D_DUR_SAMPLES)
        Key(Note.G, Accidental.NATURAL, Mode.MINOR) -> createSamplesImpl(G_MOLL_SAMPLES)
        Key(Note.D, Accidental.NATURAL, Mode.MINOR) -> createSamplesImpl(D_MOLL_SAMPLES)
        Key(Note.A, Accidental.NATURAL, Mode.MINOR) -> createSamplesImpl(A_MOLL_SAMPLES)
        Key(Note.E, Accidental.NATURAL, Mode.MINOR) -> createSamplesImpl(E_MOLL_SAMPLES)
        Key(Note.B, Accidental.NATURAL, Mode.MINOR) -> createSamplesImpl(H_MOLL_SAMPLES)
        else -> error("cannot create sample")
    }
}