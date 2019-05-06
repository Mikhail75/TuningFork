package com.mglizerin.tuningfork.player.util

import com.mglizerin.tuningfork.sound.interfaces.IChord
import com.mglizerin.tuningfork.sound.interfaces.ITempo

/**
 * Вычисляет длительность звучания аккорда в миллисекундах
 *
 * @param tempo Темп по метроному
 * @param chord Аккорд, для которого нужно вычислить длительность звучания
 * @return Длительность звучания аккорда в миллисекундах
 */
fun calculateChordDuration(tempo: ITempo, chord: IChord): Long {
    val millisecondPerMinute = 60000
    var chordDuration = 0

    chord.sounds().forEach { note ->
        val bitDuration = millisecondPerMinute / tempo.beatsPerMinute()
        val noteDuration = bitDuration * (tempo.beat().toInt() / note.beat().toInt())

        when {
            noteDuration > chordDuration -> chordDuration = noteDuration
        }
    }

    return chordDuration.toLong()
}