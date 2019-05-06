package com.mglizerin.tuningfork.sound

import com.mglizerin.tuningfork.sound.interfaces.IPitch
import com.mglizerin.tuningfork.sound.interfaces.ISoundBank
import com.mglizerin.tuningfork.sound.interfaces.ISample

/**
 * Содержит набор звуков, необходимых для воспроизведения [семплов][ISample]
 */
class SoundBank() : ISoundBank {
    var mSounds: MutableMap<IPitch, Int> = mutableMapOf()

    override fun addSound(pitch: IPitch, resourceId: Int) {
        mSounds.set(pitch, resourceId)
    }

    override fun getResource(pitch: IPitch): Int? {
        return mSounds[pitch]
    }

    override fun forEachSound(apply: (IPitch, Int) -> Unit) {
        mSounds.forEach{ (pitch, id) -> apply(pitch, id) }
    }
}