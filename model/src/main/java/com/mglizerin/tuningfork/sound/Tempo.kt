package com.mglizerin.tuningfork.sound

import com.mglizerin.tuningfork.sound.interfaces.ITempo
import com.mglizerin.tuningfork.sound.types.Beat

/**
 * Определяет темп звучания семпла по метроному
 * (длительность доли, количество долей в минуту)
 *
 * @param beat Длительность доли (целая, половинная, четверть, восьмая)
 * @param beatsPerMinute Количество долей в минуту
 */
data class Tempo(
    val beat : Beat,
    val beatsPerMinute: Int
) : ITempo {
    override fun beat() = beat
    override fun beatsPerMinute() = beatsPerMinute
}