package com.mglizerin.tuningfork.sound.interfaces

import com.mglizerin.tuningfork.sound.types.Beat

/**
 * Определяет темп звучания по метроному
 * ([длительность][Beat] доли, количество долей в минуту)
 */
interface ITempo {
    /**
     * @return Длительность доли (целая, половинная, четверть, восьмая)
     */
    fun beat(): Beat

    /**
     * @return Количество долей в минуту
     */
    fun beatsPerMinute(): Int
}