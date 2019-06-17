package com.mglizerin.tuningfork.samples.presets

import com.mglizerin.tuningfork.samples.*

val G5_D5_B4_G4_H = createChord(G5H, D5H, B4H, G4H)
val F5S_D5_C5_A4_H = createChord(F5SH,D5H, C5H, A4H)

val G_DUR_SAMPLES = listOf(
    listOf(D5_Q, B4_Q, G4_H),
    listOf(G4_Q, B4_Q, D5_Q, B4_Q, G4_H),
    listOf(G4_Q, B4_Q, G4_Q, A4_Q, F4S_Q, D4_H),
    listOf(C5_Q, A4_Q, F4S_Q, D4_H),
    listOf(G5_D5_B4_G4_H)
)