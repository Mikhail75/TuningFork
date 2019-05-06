package com.mglizerin.tuningfork.sound

import com.mglizerin.tuningfork.sound.interfaces.IChord
import com.mglizerin.tuningfork.sound.interfaces.ISound

/**
 * Аккорд (набор звуков, исполняющихся одновременно)
 *
 * @param sounds [Звуки][ISound], входящие в аккорд
 */
data class Chord(
    private val sounds: List<ISound>
) : IChord {
    override fun sounds(): List<ISound> = sounds
}