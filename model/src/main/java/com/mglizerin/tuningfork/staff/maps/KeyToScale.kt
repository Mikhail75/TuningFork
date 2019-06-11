package com.mglizerin.tuningfork.staff.maps

import com.mglizerin.tuningfork.sound.Key
import com.mglizerin.tuningfork.sound.interfaces.IKey
import com.mglizerin.tuningfork.sound.types.Accidental
import com.mglizerin.tuningfork.sound.types.*
import com.mglizerin.tuningfork.sound.types.Mode
import com.mglizerin.tuningfork.sound.types.Note

/**
 * Ассоциативный массив хранит натуральные звукоряды тональностей
  */
val keyToScale: Map<IKey, List<Pair<Note, Accidental>>> = mapOf(
    Key(Note.C, Accidental.NATURAL, Mode.MAJOR) to C_DUR_A_MOLL_SCALE,    // C-dur
    Key(Note.A, Accidental.NATURAL, Mode.MINOR) to C_DUR_A_MOLL_SCALE,    // a-moll

    Key(Note.G, Accidental.NATURAL, Mode.MAJOR) to G_DUR_E_MOLL_SCALE,    // G-dur
    Key(Note.D, Accidental.NATURAL, Mode.MAJOR) to D_DUR_H_MOLL_SCALE,    // D-dur
    Key(Note.A, Accidental.NATURAL, Mode.MAJOR) to A_DUR_FIS_MOLL_SCALE,  // A-dur
    Key(Note.E, Accidental.NATURAL, Mode.MAJOR) to E_DUR_CIS_MOLL_SCALE,  // E-dur
    Key(Note.B, Accidental.NATURAL, Mode.MAJOR) to H_DUR_GIS_MOLL_SCALE,  // H-dur
    Key(Note.F, Accidental.SHARP, Mode.MAJOR) to FIS_DUR_DIS_MOLL_SCALE,  // Fis-dur
    Key(Note.C, Accidental.SHARP, Mode.MAJOR) to CIS_DUR_AIS_MOLL_SCALE,  // Cis-dur

    Key(Note.E, Accidental.NATURAL, Mode.MINOR) to G_DUR_E_MOLL_SCALE,    // e-moll
    Key(Note.B, Accidental.NATURAL, Mode.MINOR) to D_DUR_H_MOLL_SCALE,    // h-moll
    Key(Note.F, Accidental.SHARP, Mode.MINOR) to A_DUR_FIS_MOLL_SCALE,    // fis-moll
    Key(Note.C, Accidental.SHARP, Mode.MINOR) to E_DUR_CIS_MOLL_SCALE,    // cis-moll
    Key(Note.G, Accidental.SHARP, Mode.MINOR) to FIS_DUR_DIS_MOLL_SCALE,  // gis-moll
    Key(Note.D, Accidental.SHARP, Mode.MINOR) to CIS_DUR_AIS_MOLL_SCALE,  // dis-moll
    Key(Note.A, Accidental.SHARP, Mode.MINOR) to CIS_DUR_AIS_MOLL_SCALE,  // ais-moll

    Key(Note.F, Accidental.NATURAL, Mode.MAJOR) to F_DUR_D_MOLL_SCALE,    // F-dur
    Key(Note.B, Accidental.FLAT, Mode.MAJOR) to B_DUR_G_MOLL_SCALE,       // B-dur
    Key(Note.E, Accidental.FLAT, Mode.MAJOR) to ES_DUR_C_MOLL_SCALE,      // Es-dur
    Key(Note.A, Accidental.FLAT, Mode.MAJOR) to AS_DUR_F_MOLL_SCALE,      // As-dur
    Key(Note.D, Accidental.FLAT, Mode.MAJOR) to DES_DUR_B_MOLL_SCALE,     // Des-dur
    Key(Note.G, Accidental.FLAT, Mode.MAJOR) to GES_DUR_ES_MOLL_SCALE,    // Ges-dur
    Key(Note.C, Accidental.FLAT, Mode.MAJOR) to CES_DUR_AS_MOLL_SCALE,    // Ces-dur

    Key(Note.D, Accidental.NATURAL, Mode.MINOR) to F_DUR_D_MOLL_SCALE,    // d-moll
    Key(Note.G, Accidental.NATURAL, Mode.MINOR) to B_DUR_G_MOLL_SCALE,    // g-moll
    Key(Note.C, Accidental.NATURAL, Mode.MINOR) to ES_DUR_C_MOLL_SCALE,   // c-moll
    Key(Note.F, Accidental.NATURAL, Mode.MINOR) to AS_DUR_F_MOLL_SCALE,   // f-moll
    Key(Note.B, Accidental.FLAT, Mode.MINOR) to DES_DUR_B_MOLL_SCALE,     // b-moll
    Key(Note.E, Accidental.FLAT, Mode.MINOR) to GES_DUR_ES_MOLL_SCALE,    // es-moll
    Key(Note.A, Accidental.FLAT, Mode.MINOR) to CES_DUR_AS_MOLL_SCALE     // as-moll

)