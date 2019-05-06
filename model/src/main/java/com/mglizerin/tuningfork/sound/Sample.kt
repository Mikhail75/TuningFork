package com.mglizerin.tuningfork.sound

import com.mglizerin.tuningfork.sound.interfaces.IChord
import com.mglizerin.tuningfork.sound.interfaces.IKey
import com.mglizerin.tuningfork.sound.interfaces.ISample
import com.mglizerin.tuningfork.sound.interfaces.ITempo

/**
 * Семпл содержит:
 *   набор аккородов (звуков), исполняющихся последовательно;
 *   описание свойств, общих для всех аккородов семпла.
 *
 * @param tempo [Темп][ITempo] исполнения семпла по метроному
 * @param key [Тональность][IKey] сэмпла
 * @param chords [Аккорды][IChord], которые нужно исполнить последовательно
 */
data class Sample(
    private val tempo: ITempo,
    private val key: IKey,
    private val chords: List<IChord>
) : ISample {
    override fun tempo(): ITempo = tempo
    override fun key(): IKey = key
    override fun chords(): List<IChord> = chords
}