package com.mglizerin.tuningfork

import com.mglizerin.tuningfork.player.util.createDefaultSoundBank
import com.mglizerin.tuningfork.sound.Pitch
import com.mglizerin.tuningfork.sound.Sound
import com.mglizerin.tuningfork.sound.interfaces.IPitch
import com.mglizerin.tuningfork.sound.interfaces.ISound
import com.mglizerin.tuningfork.sound.types.*
import org.junit.Test
import org.junit.Assert.*

class CreateDefaultSoundBankTest {
    val sounds: List<IPitch> = listOf(
        Pitch(Note.D, Accidental.NATURAL, 4),
        Pitch(Note.F, Accidental.SHARP, 4),
        Pitch(Note.A, Accidental.NATURAL, 4),
        Pitch(Note.D, Accidental.NATURAL, 5)
    )

    @Test
    fun shouldCreateDefaultSoundBank() {
        val soundBank = createDefaultSoundBank()
        sounds.forEach { it ->
            assertNotNull(soundBank.getResource(it))
        }
    }
}
