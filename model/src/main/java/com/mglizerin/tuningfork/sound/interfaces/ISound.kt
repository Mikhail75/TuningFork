package com.mglizerin.tuningfork.sound.interfaces

import com.mglizerin.tuningfork.sound.types.Beat

/**
 * Один звук (минимальная "единица звучания").
 * Характеризуется высотой ([IPitch]), длительностью в долях такта ([Beat])
 * (целая, половинная, четверть, восьмая, шестнадцатая)
 */
interface ISound {
    /**
     * @return Высота звука (нота звукоряда, знак альтерации, номер октавы)
     */
    fun pitch(): IPitch

    /**
     * @return Длительность в долях такта ([Beat])
     */
    fun beat(): Beat
}