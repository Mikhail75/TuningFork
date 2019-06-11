package com.mglizerin.tuningfork.staff.maps

import com.mglizerin.tuningfork.sound.Key
import com.mglizerin.tuningfork.sound.interfaces.IKey
import com.mglizerin.tuningfork.sound.types.Accidental
import com.mglizerin.tuningfork.sound.types.Mode
import com.mglizerin.tuningfork.sound.types.Note

/**
 * Ассоциативный массив хранит тип и количество знаков альтерации для тональностей со знаками
 */
val keyToAccidentalInfo: Map<IKey, Pair<Accidental, Int>> = mapOf(
    Key(Note.G, Accidental.NATURAL, Mode.MAJOR) to Pair(Accidental.SHARP, 1),   // G-dur
    Key(Note.D, Accidental.NATURAL, Mode.MAJOR) to Pair(Accidental.SHARP, 2),   // D-dur
    Key(Note.A, Accidental.NATURAL, Mode.MAJOR) to Pair(Accidental.SHARP, 3),   // A-dur
    Key(Note.E, Accidental.NATURAL, Mode.MAJOR) to Pair(Accidental.SHARP, 4),   // E-dur
    Key(Note.B, Accidental.NATURAL, Mode.MAJOR) to Pair(Accidental.SHARP, 5),   // H-dur
    Key(Note.F, Accidental.SHARP, Mode.MAJOR) to Pair(Accidental.SHARP, 6),     // Fis-dur
    Key(Note.C, Accidental.SHARP, Mode.MAJOR) to Pair(Accidental.SHARP, 7),     // Cis-dur

    Key(Note.E, Accidental.NATURAL, Mode.MINOR) to Pair(Accidental.SHARP, 1),   // e-moll
    Key(Note.B, Accidental.NATURAL, Mode.MINOR) to Pair(Accidental.SHARP, 2),   // h-moll
    Key(Note.F, Accidental.SHARP, Mode.MINOR) to Pair(Accidental.SHARP, 3),     // fis-moll
    Key(Note.C, Accidental.SHARP, Mode.MINOR) to Pair(Accidental.SHARP, 4),     // cis-moll
    Key(Note.G, Accidental.SHARP, Mode.MINOR) to Pair(Accidental.SHARP, 5),     // gis-moll
    Key(Note.D, Accidental.SHARP, Mode.MINOR) to Pair(Accidental.SHARP, 6),     // dis-moll
    Key(Note.A, Accidental.SHARP, Mode.MINOR) to Pair(Accidental.SHARP, 7),     // ais-moll

    Key(Note.F, Accidental.NATURAL, Mode.MAJOR) to Pair(Accidental.FLAT, 1),    // F-dur
    Key(Note.B, Accidental.FLAT, Mode.MAJOR) to Pair(Accidental.FLAT, 2),       // B-dur
    Key(Note.E, Accidental.FLAT, Mode.MAJOR) to Pair(Accidental.FLAT, 3),       // Es-dur
    Key(Note.A, Accidental.FLAT, Mode.MAJOR) to Pair(Accidental.FLAT, 4),       // As-dur
    Key(Note.D, Accidental.FLAT, Mode.MAJOR) to Pair(Accidental.FLAT, 5),       // Des-dur
    Key(Note.G, Accidental.FLAT, Mode.MAJOR) to Pair(Accidental.FLAT, 6),       // Ges-dur
    Key(Note.C, Accidental.FLAT, Mode.MAJOR) to Pair(Accidental.FLAT, 7),       // Ces-dur

    Key(Note.D, Accidental.NATURAL, Mode.MINOR) to Pair(Accidental.FLAT, 1),    // d-moll
    Key(Note.G, Accidental.NATURAL, Mode.MINOR) to Pair(Accidental.FLAT, 2),    // g-moll
    Key(Note.C, Accidental.NATURAL, Mode.MINOR) to Pair(Accidental.FLAT, 3),    // c-moll
    Key(Note.F, Accidental.NATURAL, Mode.MINOR) to Pair(Accidental.FLAT, 4),    // f-moll
    Key(Note.B, Accidental.FLAT, Mode.MINOR) to Pair(Accidental.FLAT, 5),       // b-moll
    Key(Note.E, Accidental.FLAT, Mode.MINOR) to Pair(Accidental.FLAT, 6),       // es-moll
    Key(Note.A, Accidental.FLAT, Mode.MINOR) to Pair(Accidental.FLAT, 7)        // as-moll
)