package com.mglizerin.tuningfork.samples

import com.mglizerin.tuningfork.sound.Pitch
import com.mglizerin.tuningfork.sound.Sound
import com.mglizerin.tuningfork.sound.types.Accidental
import com.mglizerin.tuningfork.sound.types.Beat
import com.mglizerin.tuningfork.sound.types.Note

/** Нота до   */ val C = Note.C
/** Нота ре   */ val D = Note.D
/** Нота ми   */ val E = Note.E
/** Нота фа   */ val F = Note.F
/** Нота соль */ val G = Note.G
/** Нота фа   */ val A = Note.A
/** Нота си   */ val B = Note.B

/** Четверть */
val Q = Beat.QUARTER
/** Половинная */
val HF = Beat.HALF

/** Диез */
val SHARP = Accidental.SHARP
/** Бемоль */
val FLAT = Accidental.FLAT
/** Бекар */
val NATURAL = Accidental.NATURAL

val A5 = Pitch(A, NATURAL, 5)
val G5 = Pitch(G, NATURAL, 5)
val F5 = Pitch(F, NATURAL, 5)
val E5 = Pitch(E, NATURAL, 5)
val D5 = Pitch(D, NATURAL, 5)
val C5 = Pitch(C, NATURAL, 5)
val B4 = Pitch(B, NATURAL, 4)
val A4 = Pitch(A, NATURAL, 4)
val G4 = Pitch(G, NATURAL, 4)
val F4 = Pitch(F, NATURAL, 4)
val E4 = Pitch(E, NATURAL, 4)
val D4 = Pitch(D, NATURAL, 4)
val C4 = Pitch(C, NATURAL, 4)
val B3 = Pitch(B, NATURAL, 3)
val A3 = Pitch(A, NATURAL, 3)

val A5S = Pitch(A, SHARP, 5)
val G5S = Pitch(G, SHARP, 5)
val F5S = Pitch(F, SHARP, 5)
val E5S = Pitch(E, SHARP, 5)
val D5S = Pitch(D, SHARP, 5)
val C5S = Pitch(C, SHARP, 5)
val B4S = Pitch(B, SHARP, 4)
val A4S = Pitch(A, SHARP, 4)
val G4S = Pitch(G, SHARP, 4)
val F4S = Pitch(F, SHARP, 4)
val E4S = Pitch(E, SHARP, 4)
val D4S = Pitch(D, SHARP, 4)
val C4S = Pitch(C, SHARP, 4)
val B3S = Pitch(B, SHARP, 3)
val A3S = Pitch(A, SHARP, 3)

val A5F = Pitch(A, FLAT, 5)
val G5F = Pitch(G, FLAT, 5)
val F5F = Pitch(F, FLAT, 5)
val E5F = Pitch(E, FLAT, 5)
val D5F = Pitch(D, FLAT, 5)
val C5F = Pitch(C, FLAT, 5)
val B4F = Pitch(B, FLAT, 4)
val A4F = Pitch(A, FLAT, 4)
val G4F = Pitch(G, FLAT, 4)
val F4F = Pitch(F, FLAT, 4)
val E4F = Pitch(E, FLAT, 4)
val D4F = Pitch(D, FLAT, 4)
val C4F = Pitch(C, FLAT, 4)
val B3F = Pitch(B, FLAT, 3)
val A3F = Pitch(A, FLAT, 3)

val A5Q = Sound(A5, Q)
val G5Q = Sound(G5, Q)
val F5Q = Sound(F5, Q)
val E5Q = Sound(E5, Q)
val D5Q = Sound(D5, Q)
val C5Q = Sound(C5, Q)
val B4Q = Sound(B4, Q)
val A4Q = Sound(A4, Q)
val G4Q = Sound(G4, Q)
val F4Q = Sound(F4, Q)
val E4Q = Sound(E4, Q)
val D4Q = Sound(D4, Q)
val C4Q = Sound(C4, Q)
val B3Q = Sound(B3, Q)
val A3Q = Sound(A3, Q)

val A5SQ = Sound(A5S, Q)
val G5SQ = Sound(G5S, Q)
val F5SQ = Sound(F5S, Q)
val E5SQ = Sound(E5S, Q)
val D5SQ = Sound(D5S, Q)
val C5SQ = Sound(C5S, Q)
val B4SQ = Sound(B4S, Q)
val A4SQ = Sound(A4S, Q)
val G4SQ = Sound(G4S, Q)
val F4SQ = Sound(F4S, Q)
val E4SQ = Sound(E4S, Q)
val D4SQ = Sound(D4S, Q)
val C4SQ = Sound(C4S, Q)
val B3SQ = Sound(B3S, Q)
val A3SQ = Sound(A3S, Q)

val A5FQ = Sound(A5F, Q)
val G5FQ = Sound(G5F, Q)
val F5FQ = Sound(F5F, Q)
val E5FQ = Sound(E5F, Q)
val D5FQ = Sound(D5F, Q)
val C5FQ = Sound(C5F, Q)
val B4FQ = Sound(B4F, Q)
val A4FQ = Sound(A4F, Q)
val G4FQ = Sound(G4F, Q)
val F4FQ = Sound(F4F, Q)
val E4FQ = Sound(E4F, Q)
val D4FQ = Sound(D4F, Q)
val C4FQ = Sound(C4F, Q)
val B3FQ = Sound(B3F, Q)
val A3FQ = Sound(A3F, Q)

val A5H = Sound(A5, HF)
val G5H = Sound(G5, HF)
val F5H = Sound(F5, HF)
val E5H = Sound(E5, HF)
val D5H = Sound(D5, HF)
val C5H = Sound(C5, HF)
val B4H = Sound(B4, HF)
val A4H = Sound(A4, HF)
val G4H = Sound(G4, HF)
val F4H = Sound(F4, HF)
val E4H = Sound(E4, HF)
val D4H = Sound(D4, HF)
val C4H = Sound(C4, HF)
val B3H = Sound(B3, HF)
val A3H = Sound(A3, HF)

val A5SH = Sound(A5S, HF)
val G5SH = Sound(G5S, HF)
val F5SH = Sound(F5S, HF)
val E5SH = Sound(E5S, HF)
val D5SH = Sound(D5S, HF)
val C5SH = Sound(C5S, HF)
val B4SH = Sound(B4S, HF)
val A4SH = Sound(A4S, HF)
val G4SH = Sound(G4S, HF)
val F4SH = Sound(F4S, HF)
val E4SH = Sound(E4S, HF)
val D4SH = Sound(D4S, HF)
val C4SH = Sound(C4S, HF)
val B3SH = Sound(B3S, HF)
val A3SH = Sound(A3S, HF)

val A5FH = Sound(A5F, HF)
val G5FH = Sound(G5F, HF)
val F5FH = Sound(F5F, HF)
val E5FH = Sound(E5F, HF)
val D5FH = Sound(D5F, HF)
val C5FH = Sound(C5F, HF)
val B4FH = Sound(B4F, HF)
val A4FH = Sound(A4F, HF)
val G4FH = Sound(G4F, HF)
val F4FH = Sound(F4F, HF)
val E4FH = Sound(E4F, HF)
val D4FH = Sound(D4F, HF)
val C4FH = Sound(C4F, HF)
val B3FH = Sound(B3F, HF)
val A3FH = Sound(A3F, HF)