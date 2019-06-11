package com.mglizerin.tuningfork.staff.maps

import com.mglizerin.tuningfork.sound.types.Note

fun noteToHorizontalGuideNumberMap(): Map<Pair<Note, Int>, Int> {
    return mapOf(
        Pair(Note.A, 5) to 1,
        Pair(Note.G, 5) to 2,
        Pair(Note.F, 5) to 3,
        Pair(Note.E, 5) to 4,
        Pair(Note.D, 5) to 5,
        Pair(Note.C, 5) to 6,
        Pair(Note.B, 4) to 7,
        Pair(Note.A, 4) to 8,
        Pair(Note.G, 4) to 9,
        Pair(Note.F, 4) to 10,
        Pair(Note.E, 4) to 11,
        Pair(Note.D, 4) to 12,
        Pair(Note.C, 4) to 13,
        Pair(Note.B, 3) to 14,
        Pair(Note.A, 3) to 15
    )
}