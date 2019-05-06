package com.mglizerin.tuningfork.sound.interfaces

/**
 * Семпл содержит:
 *   набор аккородов (звуков), исполняющихся последовательно;
 *   описание свойств, общих для всех аккородов семпла.
 */
interface ISample {
    /**
     * @return [Темп][ITempo] исполнения семпла по метроному
     */
    fun tempo(): ITempo

    /**
     * @return [Тональность][IKey] сэмпла
     */
    fun key(): IKey

    /**
     * @return [Аккорды][IChord], которые нужно исполнить последовательно
     */
    fun chords(): List<IChord>
}