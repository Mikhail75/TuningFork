package com.mglizerin.tuningfork.sound.interfaces

/**
 * Аккорд (набор звуков, исполняющихся одновременно)
 */
interface IChord {
    /**
     * @return Звуки, входящие в аккорд
     */
    fun sounds(): List<ISound>
}