package com.mglizerin.tuningfork.sound

import com.mglizerin.tuningfork.sound.interfaces.IPitch
import com.mglizerin.tuningfork.sound.interfaces.ISound
import com.mglizerin.tuningfork.sound.types.Beat

/**
 * Один звук (минимальная "единица звучания")
 * @see ISound
 *
 * @param pitch [Высота звука][IPitch]
 * @param beat [Длительность звука][Beat]
 */
data class Sound(
    val pitch: IPitch,
    val beat: Beat
) : ISound {
    override fun pitch() = pitch
    override fun beat() = beat
}