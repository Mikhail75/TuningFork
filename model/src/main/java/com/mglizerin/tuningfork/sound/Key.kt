package com.mglizerin.tuningfork.sound

import com.mglizerin.tuningfork.sound.interfaces.IKey
import com.mglizerin.tuningfork.sound.types.Accidental
import com.mglizerin.tuningfork.sound.types.Mode
import com.mglizerin.tuningfork.sound.types.Note

/**
 * Тональность
 *
 * @param note Нота звукоряда (до ... си)
 * @param accidental Знак альтерации ноты (диез, бемоль, бекар)
 * @param mode Лад (мажор, минор)
 */
data class Key(
    private val note: Note,
    private val accidental: Accidental,
    private val mode: Mode
) : IKey {
    override fun note(): Note = note
    override fun accidental(): Accidental = accidental
    override fun mode(): Mode = mode
}