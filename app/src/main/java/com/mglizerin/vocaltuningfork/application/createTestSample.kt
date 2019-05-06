package com.mglizerin.vocaltuningfork.application

import com.mglizerin.tuningfork.sound.*
import com.mglizerin.tuningfork.sound.interfaces.IChord
import com.mglizerin.tuningfork.sound.interfaces.ISample
import com.mglizerin.tuningfork.sound.interfaces.ISound
import com.mglizerin.tuningfork.sound.types.Accidental
import com.mglizerin.tuningfork.sound.types.Beat
import com.mglizerin.tuningfork.sound.types.Mode
import com.mglizerin.tuningfork.sound.types.Note

fun createTestSample() : ISample {
    val tempo = Tempo(Beat.QUARTER, 90)
    val key = Key(Note.D, Accidental.NATURAL, Mode.MAJOR)
    val chords: List<IChord> = listOf(
        Chord(
            listOf<ISound>(Sound(Pitch(Note.D, Accidental.NATURAL, 5), Beat.QUARTER))
        ),
        Chord(
            listOf<ISound>(Sound(Pitch(Note.A, Accidental.NATURAL, 4), Beat.QUARTER))
        ),
        Chord(
            listOf<ISound>(Sound(Pitch(Note.F, Accidental.SHARP, 4), Beat.QUARTER))
        ),
        Chord(
            listOf<ISound>(Sound(Pitch(Note.D, Accidental.NATURAL, 4), Beat.HALF))
        )
    )

    return Sample(tempo, key, chords)
}