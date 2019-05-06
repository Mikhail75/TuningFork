package com.mglizerin.tuningfork.player

import com.mglizerin.tuningfork.sound.interfaces.ISample

/**
 * Воспроизводит [семплы][ISample]
 */
interface IPlayer {
    /**
     * @param sample Семпл ([ISample]), который необходимо воспроизвести
     */
    fun play(sample: ISample)
}