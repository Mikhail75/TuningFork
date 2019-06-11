package com.mglizerin.tuningfork.staff

import com.mglizerin.tuningfork.sound.interfaces.IChord
import com.mglizerin.tuningfork.sound.interfaces.IKey
import com.mglizerin.tuningfork.sound.interfaces.IPitch
import com.mglizerin.tuningfork.sound.types.Accidental
import com.mglizerin.tuningfork.sound.types.ChordElement
import com.mglizerin.tuningfork.sound.types.Note
import com.mglizerin.tuningfork.staff.maps.keyToAccidentalInfo
import com.mglizerin.tuningfork.staff.maps.noteToHorizontalGuideNumberMap
import kotlin.math.round

/**
 * @param params [Параметры сетки][StaffGridParams] нотного стана
 */
class StaffGrid(
    private val params: StaffGridParams
) {
    /** Ширина сетки нотного стана */
    val staffGridWidth = params.width
    /** Высота сетки нотного стана */
    val staffGridHeight = params.height
    /** Толщина линейки нотного стана */
    val lineWeight = params.lineWeight
    /** Нужно ли показывать ключ */
    val showClef = params.showClef
    /** Y-координаты основных линеек нотного стана */
    val baseLinesY: List<Int>
     /** Размер скрипичного ключа */
    val clefSize: Size
    /** Размер нотной головки */
    val noteHeadSize: Size
    /** Размеры знаков альтерации */
    val accidentalSize: Map<Accidental, Size>
    /** Расстояние между аккордами */
    val spaceBetweenChords = params.spaceBetweenChords

    /** Расстояние между горизнотальными направляющими */
    private var mSpaceBetweenHGuides: Int
    /** Y-координаты горизонтальных направляющих нотного стана */
    private var mHGuidesY: List<Int>
    /** X-координаты вертикальных направляющих нотного стана */
    private var mVGuidesX: List<Int>
    /** X-координата группы знаков при ключе */
    private var mKeyAccidentalsX: Int
    /** Расстояние между знаками альтерации при ключе */
    private var mSpaceBetweenKeyAccidental: Int
    /** Номер диеза при ключе -> номер горизонтальной направляющей. Нумерация диезов с 1 (фа-до-соль-ре-ля-ми-си) */
    private var mSharpNumberToHGuideNumber: Map<Int, Int>
    /** Номер бемоля при ключе -> номер горизонтальной направляющей. Нумерация бемолей с 1 (си-ми-ля-ре-соль-до-фа) */
    private var mFlatNumberToHGuideNumber: Map<Int, Int>
    /** {[Нота][Note], номер октавы} -> номер горизонтальной направляющей */
    private var mNoteToHGuideNumber: Map<Pair<Note, Int>, Int>

    init {
        mSpaceBetweenHGuides = calculateSpaceBetweenHGuides(staffGridHeight, params.hGuidesCount)
        mHGuidesY = calculateHorizontalGuidesY(mSpaceBetweenHGuides, params.hGuidesCount)
        mVGuidesX = calculateVerticalGuidesX(staffGridWidth, params.spaceBetweenVGuides)

        baseLinesY = calculateBaseLinesY(mHGuidesY, params.baseLinesGuides)
        clefSize = calculateClefSize(baseLinesY)
        noteHeadSize = calculateNoteHeadSize(baseLinesY, lineWeight)

        mKeyAccidentalsX = calculateKeyAccidentalsX(showClef, clefSize, params.marginBeforeClef, params.marginBeforeKeyAccidentals)
        mSpaceBetweenKeyAccidental = 8
        mSharpNumberToHGuideNumber = mapOf(1 to 4, 2 to 7, 3 to 3, 4 to 6, 5 to 9, 6 to 5, 7 to 8)
        mFlatNumberToHGuideNumber = mapOf(1 to 8, 2 to 5, 3 to 9, 4 to 6, 5 to 10, 6 to 7, 7 to 11)
        mNoteToHGuideNumber = noteToHorizontalGuideNumberMap()

        accidentalSize = mapOf(
            Accidental.SHARP to calculateSharpSize(mSpaceBetweenHGuides),
            Accidental.FLAT to calculateFlatSize(mSpaceBetweenHGuides),
            Accidental.NATURAL to calculateNaturalSize(mSpaceBetweenHGuides)
        )
    }

    /**
     * Возвращает координату пересечения горизонтальной и вертикальной направляющих
     *
     * @param vGuideNumber Номер вертикальной направляющей
     * @param hGuideNumber Номер горизонтальной направляющей
     *
     * @return Пару, содрежающую x- и y-координаты пересечения направляющих
     */
    fun getCoordByGuideNumbers(vGuideNumber: Int, hGuideNumber: Int): Pair<Int, Int> {
        return mVGuidesX[vGuideNumber] to mHGuidesY[hGuideNumber] + lineWeight
    }

    fun getClefCoord(): Pair<Int, Int> {
        return params.marginBeforeClef to calculateClefY(baseLinesY, clefSize)
    }

    /**
     * Вычисляет координаты знака альтерации, входящего в группу знаков при ключе
     *
     * @param accidental [Тип знака альтерации][Accidental]
     * @param accidentalNumber Номер знака альтерации в группе (нумерация с 1, см. [mSharpNumberToHGuideNumber], [mFlatNumberToHGuideNumber])
     *
     * @return Пару, содрежающую x- и y-координаты знака альтерации
     */
    fun getKeyAccidentalCoord(accidental: Accidental, accidentalNumber: Int): Pair<Int, Int>  {
        val hGuideNumber = when (accidental) {
            Accidental.SHARP -> mSharpNumberToHGuideNumber.getValue(accidentalNumber)
            Accidental.FLAT -> mFlatNumberToHGuideNumber.getValue(accidentalNumber)
            else -> error("")
        }

        val x = mKeyAccidentalsX + (accidentalNumber - 1) * (accidentalSize.getValue(accidental).width + mSpaceBetweenKeyAccidental)
        val y = calculateAccidentalY(mHGuidesY[hGuideNumber], accidental, accidentalSize.getValue(accidental).height)

        return x to y
    }

    /**
     * Вычисляет Y-координату знака альтерации для ноты (знак рисуется рядом с нотной головкой)
     *
     * @param pitch [Высота ноты][IPitch]
     *
     * @return Y-координату знака альтерации для ноты
     */
    fun getNoteAccidentalY(pitch: IPitch): Int {
        val hGuideNumber = mNoteToHGuideNumber.getValue(pitch.note() to pitch.octave()) + 1
        val accidental = pitch.accidental()

        return calculateAccidentalY(mHGuidesY[hGuideNumber], accidental, accidentalSize.getValue(accidental).height)
    }

    fun getNoteHeadY(pitch: IPitch): Int {
        val hGuideNumber = mNoteToHGuideNumber.getValue(pitch.note() to pitch.octave())
        return mHGuidesY[hGuideNumber] + lineWeight
    }

    /**
     * Вычисляет координаты нотного штиля
     *
     * @param chord [Аккорд][IChord]
     * @param startX Начальная x-координата
     *
     * @return [Координаты нотного штиля][NoteStemCoord]
     */
    fun getNoteStemCoord(chord: IChord, startX: Int): NoteStemCoord {
        val guides = mutableListOf<Int>()

        chord.sounds().forEach { sound ->
            val pitch = sound.pitch()
            guides.add(mNoteToHGuideNumber.getValue(pitch.note() to pitch.octave()))
        }

        val baseStemLength = noteHeadSize.height * 2

        val minGuideNumber = guides.min()!!
        val maxGuideNumber = guides.max()!!

        // Штиль вниз
        if (minGuideNumber < 8) {
            val x = startX
            val y0 = mHGuidesY[minGuideNumber + 1] + 2
            val y1 = y0 + baseStemLength + chord.sounds().size * noteHeadSize.height

            return NoteStemCoord(x, y0, y1)
        }
        // Штиль вверх
        else {
            val x = startX + noteHeadSize.width
            val y0 = mHGuidesY[maxGuideNumber + 1] - 2
            val y1 = y0 - baseStemLength - chord.sounds().size * noteHeadSize.height

            return NoteStemCoord(x, y0, y1)
        }
    }

    /**
     * Вычисляет метрики аккорда, который должен быть нарисован
     *
     * @param chord [Аккорд][IChord]
     * @param key [Тональность][IKey] сэмла, частью которого является аккорд
     *
     * @return [Метрики аккорда][ChordMetrics], который должен быть нарисован
     */
    fun getChordMetrics(chord: IChord, key: IKey, startX: Int = 0): ChordMetrics {
        var x = startX
        var width = 0
        /** Элементы аккорда */
        val elements = mutableListOf<ChordElementMetrics>()

        // Знаки альтерации
        chord.sounds().forEach { sound ->
            if (!scaleContainsSound(sound, key)) { // Если натуральный звукоряд не содержит звук, нужно нарисовать знак альтерации
                val accidental = sound.pitch().accidental()

                val element = getChordElement(accidental)
                val y = getNoteAccidentalY(sound.pitch())

                elements.add(ChordElementMetrics(element, x to y))
                width = maxOf(width, accidentalSize.getValue(accidental).width)
            }
        }

        if (width != 0) {
            width += params.spaceBetweenAccidentalAndNoteHead
            x += width
        }

        // Нотные головки
        chord.sounds().forEach { sound ->
            val beat = sound.beat()

            val element = getChordElement(beat)
            val y = getNoteHeadY(sound.pitch())

            elements.add(ChordElementMetrics(element, x to y))
        }

        width += noteHeadSize.width

        val noteStemCoord = getNoteStemCoord(chord, x)
        elements.add(ChordElementMetrics(ChordElement.Stem, noteStemCoord.x to 0, noteStemCoord))

        return ChordMetrics(elements, width)
    }

    /**
     * Вычисляет стартовую x-координату для аккордов
     *
     * @param key [Тональность][IKey] сэмла
     *
     * @return Стартовую x-координату для аккордов
     */
    fun getChordStartX(key: IKey): Int {
        var startX = 0

        if (showClef) {
            startX += params.marginBeforeClef + clefSize.width
        }

        if (keyToAccidentalInfo.contains(key)) {
            val (accidental, accidentalCount) = keyToAccidentalInfo.getValue(key)
            startX += params.marginBeforeKeyAccidentals
            startX += accidentalCount * accidentalSize.getValue(accidental).width
            startX += (accidentalCount - 1) * mSpaceBetweenKeyAccidental
        }

        startX += params.marginBeforeChords

        return startX
    }
}