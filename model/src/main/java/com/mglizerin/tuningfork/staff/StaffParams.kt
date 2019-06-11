package com.mglizerin.tuningfork.staff

import com.mglizerin.tuningfork.sound.types.ChordElement

/**
 * @param width Ширина
 * @param height Высота
 */
data class Size(
    val width: Int,
    val height: Int
)

/**
 * Координаты штиля ноты
 *
 * @param x
 * @param y0
 * @param y1
 */
data class NoteStemCoord(
    val x: Int,
    val y0: Int,
    val y1: Int
)

/**
 * Метрики элемента аккорда (используются для отрисовки)
 *
 * @param element [Элемент аккорда][ChordElement]
 * @param coord Координаты элемента (x, y)
 */
data class ChordElementMetrics(
    val element: ChordElement,
    val coord: Pair<Int, Int>,
    val stemCoord: NoteStemCoord? = null
)

/**
 * Метрики аккорда (используются для отрисовки)
 *
 * @param elements [Метрики элементов аккорда][ChordElementMetrics]
 * @param width Общая прямоугольника, включающего все элементы аккорда
 */
data class ChordMetrics(
    val elements: List<ChordElementMetrics>,
    val width: Int
)

/**
 * Параметры сетки нотного стана (все значения в px)
 *
 * @param width Ширина сетки
 * @param height Высота сетки
 * @param hGuidesCount Количество горизонтальных направляющих
 * @param spaceBetweenVGuides Расстояние между вертикальными направляющими
 * @param baseLinesGuides Номера горизонтальных направляющих основных линеек нотного стана
 * @param lineWeight Толщина линейки нотного стана
 * @param showClef Нужно ли показывать скрипичный ключ
 * @param marginBeforeClef Отступ перед ключом
 * @param marginBeforeKeyAccidentals Отступ перед группой знаков альтерации при ключе (без учёта ключа)
 * @param marginBeforeChords Отступ перед аккордами
 * @param spaceBetweenAccidentalAndNoteHead Расстояние между знаком альтерации и нотной головкой
 */
data class StaffGridParams(
    val width: Int = 400,
    val height: Int = 120,
    val hGuidesCount: Int = 17,
    val spaceBetweenVGuides: Int = 8,
    val baseLinesGuides: List<Int> = listOf(4, 6, 8, 10, 12),
    val lineWeight: Int = 1,
    val showClef: Boolean = true,
    val marginBeforeClef: Int = 20,
    val marginBeforeKeyAccidentals: Int = 12,
    val marginBeforeChords: Int = 30,
    val spaceBetweenAccidentalAndNoteHead: Int = 5,
    val spaceBetweenChords: Int = 20
)