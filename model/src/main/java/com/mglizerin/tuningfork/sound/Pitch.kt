package com.mglizerin.tuningfork.sound

import com.mglizerin.tuningfork.sound.interfaces.IPitch
import com.mglizerin.tuningfork.sound.types.Accidental
import com.mglizerin.tuningfork.sound.types.Note

data class Pitch(
    private val note: Note,
    private val accidental: Accidental,
    private val octave: Int
) : IPitch {

    override fun note() = note
    override fun accidental() = accidental
    override fun octave() = octave

}