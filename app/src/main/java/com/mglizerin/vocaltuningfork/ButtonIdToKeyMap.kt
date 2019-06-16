package com.mglizerin.vocaltuningfork

import com.mglizerin.tuningfork.sound.Key
import com.mglizerin.tuningfork.sound.interfaces.IKey
import com.mglizerin.tuningfork.sound.types.Accidental
import com.mglizerin.tuningfork.sound.types.Mode
import com.mglizerin.tuningfork.sound.types.Note

val buttonIdToKeyMap = mapOf<Int, IKey>(
    R.id.BDurButton to Key(Note.B, Accidental.FLAT, Mode.MAJOR),
    R.id.FDurButton to Key(Note.F, Accidental.NATURAL, Mode.MAJOR),
    R.id.CDurButton to Key(Note.C, Accidental.NATURAL, Mode.MAJOR),
    R.id.GDurButton to Key(Note.G, Accidental.NATURAL, Mode.MAJOR),
    R.id.DDurButton to Key(Note.D, Accidental.NATURAL, Mode.MAJOR),

    R.id.GMollButton to Key(Note.G, Accidental.NATURAL, Mode.MINOR),
    R.id.DMollButton to Key(Note.D, Accidental.NATURAL, Mode.MINOR),
    R.id.AMollButton to Key(Note.A, Accidental.NATURAL, Mode.MINOR),
    R.id.EMollButton to Key(Note.E, Accidental.NATURAL, Mode.MINOR),
    R.id.HMollButton to Key(Note.B, Accidental.NATURAL, Mode.MINOR)
)