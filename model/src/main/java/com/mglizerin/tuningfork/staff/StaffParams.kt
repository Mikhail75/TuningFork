package com.mglizerin.tuningfork.staff

/**
 * Параметры  нотной головки
 *
 * @param width Ширина нотной головки
 * @param height Высота нотной головки
 */
data class NoteHeadSize(
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
 * Параметры сетки нотного стана (все значения в px)
 *
 * @param width Ширина сетки
 * @param height Высота сетки
 * @param hGuidesCount Количество горизонтальных направляющих
 * @param spaceBetweenVGuides Расстояние между вертикальными направляющими
 * @param baseLinesGuides Номера горизонтальных направляющих основных линеек нотного стана
 * @param lineWeight Толщина линейки нотного стана
 * @param noteHeadWidthRatio Отношение ширины нотной головки к высоте
 */
data class StaffGridParams(
    val width: Int = 500,
    val height: Int = 200,
    val hGuidesCount: Int = 21,
    val spaceBetweenVGuides: Int = 6,
    val baseLinesGuides: List<Int> = listOf(6, 8, 10, 12, 14),
    val lineWeight: Int = 1,
    val noteHeadWidthRatio: Float = 1.23f
)