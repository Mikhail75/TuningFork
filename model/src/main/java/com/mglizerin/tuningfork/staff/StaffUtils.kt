package com.mglizerin.tuningfork.staff

import com.mglizerin.tuningfork.sound.interfaces.IKey
import com.mglizerin.tuningfork.sound.interfaces.ISound
import com.mglizerin.tuningfork.sound.types.Accidental
import com.mglizerin.tuningfork.sound.types.Beat
import com.mglizerin.tuningfork.sound.types.ChordElement
import com.mglizerin.tuningfork.staff.maps.keyToScale
import kotlin.math.round

infix fun Float.mul(that: Int): Int = round(this * that).toInt()
infix fun Int.mul(that: Float): Int = round(this * that).toInt()

/** Толщина направляющей */
const val GUIDE_WEIGHT = 1

/**
 * Вычисляет расстояние между горизонтальными направляющими сетки нотного стана
 *
 * @param staffGridHeight Высота сетки нотного стана
 * @param hGuidesCount Количество горизонтальных направляющих
 *
 * @return Расстояние между горизонтальными направляющими сетки нотного стана
 */
fun calculateSpaceBetweenHGuides(staffGridHeight: Int, hGuidesCount: Int): Int {
    return (staffGridHeight - hGuidesCount) / hGuidesCount
}

/**
 * Вычисляет y-координаты для всех горизонтальных направляющих сетки нотного стана
 *
 * @param spaceBetweenHGuides Расстояние между горизонтальными направляющими сетки нотного стана
 * @param hGuidesCount Количество горизонтальных направляющих
 *
 * @return Список значений y-координат для всех горизонтальных направляющих (с 0, сверху вниз)
 */
fun calculateHorizontalGuidesY(spaceBetweenHGuides: Int, hGuidesCount: Int): List<Int> {
    val hGuideWithSpaceAfter = GUIDE_WEIGHT + spaceBetweenHGuides
    val hGuidesY = mutableListOf<Int>()

    for (i in 0 until hGuidesCount)
    {
        hGuidesY.add(hGuideWithSpaceAfter * i)
    }

    return hGuidesY
}

/**
 * Вычисляет x-координаты для всех вертикальных направляющих сетки нотного стана
 *
 * @param staffGridWidth Ширина сетки нотного стана
 * @param spaceBetweenVGuides Расстояние между вертикальными направляющими
 *
 * @return Список значений x-координат для всех вертикальных направляющих (с 0, слева направо)
 */
fun calculateVerticalGuidesX(staffGridWidth: Int, spaceBetweenVGuides: Int): List<Int> {
    val vGuideWithSpaceAfter = GUIDE_WEIGHT + spaceBetweenVGuides
    val vGuidesX = mutableListOf<Int>()

    for (i in 0..staffGridWidth step vGuideWithSpaceAfter)
    {
        vGuidesX.add(i)
    }

    return vGuidesX
}

/**
 * Вычисляет y-координаты для пяти основных линеек нотного стана
 *
 * @param hGuidesY Y-координаты горизонтальных направляющих нотного стана
 * @param baseLineGuides Номера горизонтальных направляющих, на которых располагаются пять основных линеек нотного стана
 *
 * @return Список значений y-координат для основных линеек нотного стана
 */
fun calculateBaseLinesY(hGuidesY: List<Int>, baseLineGuides: List<Int> ): List<Int> {
    val baseLinesY = mutableListOf<Int>()

    baseLineGuides.forEach {
        baseLinesY.add(hGuidesY[it])
    }

    return baseLinesY
}

/**
 * Вычисляет размер нотной головки
 *
 * @param baseLinesY Y-координаты основных линеек нотного стана
 * @param lineWeight Толщина линейки нотного стана
 *
 * @return [Размер][Size] нотной головки
 */
fun calculateNoteHeadSize(baseLinesY: List<Int>, lineWeight: Int): Size {
    /** Отношение ширины нотной головки к её высоте */
    val noteHeadWidthTonoteHeadHeightRatio = 1.23f

    val height = baseLinesY[1] - baseLinesY[0] - lineWeight
    val width = height mul noteHeadWidthTonoteHeadHeightRatio

    return Size(width, height)
}

/**
 * Вычисляет размер скрипичного ключа
 *
 * @param baseLinesY Y-координаты основных линеек нотного стана
 * @return [Размер][Size] скрипичного ключа
 */
fun calculateClefSize(baseLinesY: List<Int>): Size {
    /** Отношение высоты ключа к области ("кругляшку"), указывающим на ноту соль */
    val clefHeightToClefPointerHeightRatio = 3.46f
    /** Отношение ширины ключа к высоте ключа */
    val clefWidthToClefHeightRatio = 0.37f
    /** Высота области ("кругляшка"), указывающего на ноту соль */
    val clefPointerHeight = baseLinesY[4] - baseLinesY[2]

    val height = clefPointerHeight mul clefHeightToClefPointerHeightRatio
    val width = height mul clefWidthToClefHeightRatio

    return Size(width, height)
}

/**
 * Вычисляет Y-координату скрипичного ключа
 *
 * @param baseLinesY Y-координаты основных линеек нотного стана
 * @param clefSize [Ширина и высота скрипичного ключа][Size]
 *
 * @return Y-координату скрипичного ключа
 */
fun calculateClefY(baseLinesY: List<Int>, clefSize: Size): Int {
    val spaceBeforeClefPointerToClefHeightRatio = 0.48f
    val spaceBeforeClefPointer = clefSize.height * spaceBeforeClefPointerToClefHeightRatio

    return baseLinesY[2] - spaceBeforeClefPointer.toInt()
}

/**
 * Вычисляет X-координату группы знаков альтерации при ключе
 *
 * @param showClef Нужно ли показывать скрипичный ключ
 * @param clefSize Размер скрипичного ключа
 * @param marginBeforeClef Отступ перед ключом
 * @param marginBeforeAccidentals Отступ перед группой знаков альтерации при ключе (без учёта ключа)
 *
 * @return X-координату группы знаков альтерации при ключе
 */
fun calculateKeyAccidentalsX(showClef: Boolean, clefSize: Size, marginBeforeClef: Int, marginBeforeAccidentals: Int): Int =
    when (showClef) {
        true -> marginBeforeClef + clefSize.width + marginBeforeAccidentals
        false -> marginBeforeAccidentals
    }

/**
 * Вычисляет размер знака альтерации "диез"
 *
 * @param spaceBetweenHGuides Расстояние между горизонтальными направляющими сетки нотного стана
 * @return [Размер][Size] диеза
 */
fun calculateSharpSize(spaceBetweenHGuides: Int): Size {
    /** Отношение высоты диеза к расстоянию между горизонтальными направляющими */
    val sharpHeightToSpaceBetweenHGuidesRatio = 5.8f
    /** Оношение ширины диеза к высоте диеза */
    val sharpWidthToSharpHeightRatio = 0.35f

    val height = sharpHeightToSpaceBetweenHGuidesRatio mul spaceBetweenHGuides
    val width = height mul sharpWidthToSharpHeightRatio

    return Size(width, height)
}

/**
 * Вычисляет размер знака альтерации "бемоль"
 *
 * @param spaceBetweenHGuides Расстояние между горизонтальными направляющими сетки нотного стана
 * @return [Размер][Size] бемоля
 */
fun calculateFlatSize(spaceBetweenHGuides: Int): Size {
    /** Отношение высоты бемоля к расстоянию между горизонтальными направляющими */
    val flatHeightToSpaceBetweenHGuidesRatio = 5.1f
    /** Оношение ширины бемоля к высоте бемоля */
    val flatWidthToFlatHeightRatio = 0.35f

    val height = flatHeightToSpaceBetweenHGuidesRatio mul spaceBetweenHGuides
    val width = height mul flatWidthToFlatHeightRatio

    return Size(width, height)
}

/**
 * Вычисляет размер знака альтерации "бекар"
 *
 * @param spaceBetweenHGuides Расстояние между горизонтальными направляющими сетки нотного стана
 *  * @return [Размер][Size] бекара
 */
fun calculateNaturalSize(spaceBetweenHGuides: Int): Size {
    /** Отношение высоты бекара к расстоянию между горизонтальными направляющими */
    val naturalHeightToSpaceBetweenHGuidesRatio = 6.5f
    /** Оношение ширины бекара к высоте бекара */
    val naturalWidthToNaturalHeightRatio = 0.22f

    val height = naturalHeightToSpaceBetweenHGuidesRatio mul spaceBetweenHGuides
    val width = height mul naturalWidthToNaturalHeightRatio

    return Size(width, height)
}

/**
 * Вычисляет y-координату [знака альтерации][Accidental]
 *
 * @param hGuideY Y-координата горизонтальной направляющей
 * @param accidental [Тип знака альтерации][Accidental]
 * @param accidentalHeight [Высота][Size] (dp) знака альтерации
 *
 * @return Y-координату [знака альтерации][Accidental]
 */
fun calculateAccidentalY(hGuideY: Int, accidental: Accidental, accidentalHeight: Int): Int =
    when (accidental) {
        Accidental.SHARP, Accidental.NATURAL -> {
            hGuideY - (accidentalHeight / 2)
        }
        Accidental.FLAT -> {
            val spaceBeforeGuideToAccidentalHeightRatio = 0.72f
            hGuideY - (accidentalHeight mul spaceBeforeGuideToAccidentalHeightRatio)
        }
    }

/**
 * Проверяет, входит ли звук в натуральный звукоряд тональности
 *
 * @param [Звук][ISound], который необходимо проверить
 * @param [Тональность][IKey] натурального звукоряда
 *
 * True, если звук входит в натуральный звукоряд тональности. False в ином случае
 */
fun scaleContainsSound(sound: ISound, key: IKey): Boolean {
    val note = sound.pitch().note()
    val accidental = sound.pitch().accidental()
    val scale = keyToScale[key]!!

    return scale.contains(Pair(note, accidental))
}

/**
 * Преобразует различные сущности аккорда в элемент аккорда для отрисовки
 *
 * @return Элемент аккорда для отрисовки
 */
fun getChordElement(value: Any): ChordElement {
    if (value is Accidental) {
        return when (value as Accidental) {
            Accidental.SHARP -> ChordElement.Sharp
            Accidental.FLAT -> ChordElement.Flat
            Accidental.NATURAL -> ChordElement.Natural
        }
    }

    if (value is Beat) {
        return when (value as Beat) {
            Beat.WHOLE, Beat.HALF -> ChordElement.OutlineHead
            Beat.QUARTER, Beat.EIGHT, Beat.SIXTEENTH -> ChordElement.FilledHead
        }
    }

    error("")
}