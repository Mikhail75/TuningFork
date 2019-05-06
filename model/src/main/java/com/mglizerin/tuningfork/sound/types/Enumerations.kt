package com.mglizerin.tuningfork.sound.types

/**
 * Звукоряд: до, ре, ми, фа, соль, ля, си
 */
enum class Note {
    C, D, E, F, G, A, B
}

/**
 * Знаки альтерации: диез, бемоль, бекар
 */
enum class Accidental {
    SHARP, FLAT, NATURAL
}

/**
 * Лад: мажор, минор
 */
enum class Mode {
    MAJOR, MINOR
}

/**
 * Длительность в долях такта: целая, половинная, четверть, восьмая, шестнадцатая
 */
enum class Beat(private val value: Int) {
    WHOLE(1), HALF(2), QUARTER(4), EIGHT(8), SIXTEENTH(16);

    fun toInt() : Int = value
}