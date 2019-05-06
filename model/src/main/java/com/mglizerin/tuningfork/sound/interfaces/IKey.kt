package com.mglizerin.tuningfork.sound.interfaces

import com.mglizerin.tuningfork.sound.types.Accidental
import com.mglizerin.tuningfork.sound.types.Mode
import com.mglizerin.tuningfork.sound.types.Note

/**
 * Тональность
 *
 * Определяет тональность сэмпла по следующим параметрам:
 *   нота звукоряда: до ... си;
 *   знак альтерации ноты: диез, бемоль, бекар;
 *   лад: мажор, минор
 * Например: до мажор, ре минор, си-бемоль мажор
 */
interface IKey {
    /**
     * @return Нота звукоряда: до ... си
     */
    fun note(): Note

    /**
     * @return Знак альтерации (диез, бемоль, бекар)
     */
    fun accidental(): Accidental

    /**
     * @return Лад (мажор, минор)
     */
    fun mode(): Mode
}