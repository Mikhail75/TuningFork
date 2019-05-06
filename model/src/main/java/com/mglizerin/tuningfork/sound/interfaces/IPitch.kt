package com.mglizerin.tuningfork.sound.interfaces

import com.mglizerin.tuningfork.sound.types.Accidental
import com.mglizerin.tuningfork.sound.types.Note

/**
 * Высота звука:
 *   нота звукоряда (до...си),
 *   знак альтерации (диез, бемоль, бекар),
 *   номер октавы (3...6)
 */
interface IPitch {
    /**
     * @return Нота звукоряда (до ... си)
     */
    fun note(): Note

    /**
     * @return Знак альтерации (диез, бемоль, бекар)
     */
    fun accidental(): Accidental

    /**
     * @return Номер октавы
     */
    fun octave(): Int
}