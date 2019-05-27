package com.mglizerin.tuningfork.staff

import kotlin.math.round

/**
 * @param staffGridHeight Высота сетки нотного стана
 * @param hGuidesCount Количество горизонтальных направляющих
 * @return Список значений y-координат для всех горизонтальных направляющих (с 0, сверху вниз)
 */
fun calculateHorizontalGuidesY(staffGridHeight: Int, hGuidesCount: Int): List<Int> {
    val hGuideWeight = 1 // Толщина горизонтальной направляющей
    val hGuideWithSpaceAfter = (staffGridHeight - hGuidesCount) / hGuidesCount + hGuideWeight
    val hGuidesY = mutableListOf<Int>()

    for (i in 0 until hGuidesCount)
    {
        hGuidesY.add(hGuideWithSpaceAfter * i)
    }

    return hGuidesY
}

/**
 * @param staffGridWidth Ширина сетки нотного стана
 * @param spaceBetweenVGuides Расстояние между вертикальными направляющими
 * @return Список значений x-координат для всех вертикальных направляющих (с 0, слева направо)
 */
fun calculateVerticalGuidesX(staffGridWidth: Int, spaceBetweenVGuides: Int): List<Int> {
    val vGuideWeight = 1 // Толщина вертикальной направляющей
    val vGuideWithSpaceAfter = spaceBetweenVGuides + vGuideWeight
    val vGuidesX = mutableListOf<Int>()

    for (i in 0..staffGridWidth step vGuideWithSpaceAfter)
    {
        vGuidesX.add(i)
    }

    return vGuidesX
}

/**
 * Вычисляет y-координаты для основных линеек нотного стана
 *
 * @param hGuidesY Y-координаты горизонтальных направляющих нотного стана
 * @param baseLineGuides Номера горизонтальных направляющих основных линеек нотного стана
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
 * Вычисляет ширину и высоту нотной головки
 *
 * @param baseLinesY Y-координаты основных линеек нотного стана
 * @param lineWeight Толщина линейки нотного стана
 * @param noteHeadWidthRatio Отношение ширины нотной головки к её высоте
 * @return [Ширину и высоту нотной головки][NoteHeadSize]
 */
fun calculateNoteHeadSize(baseLinesY: List<Int>, lineWeight: Int, noteHeadWidthRatio: Float): NoteHeadSize {
    val height = baseLinesY[1] - baseLinesY[0] - lineWeight
    val width =  round(height.toFloat() * noteHeadWidthRatio).toInt()

    return NoteHeadSize(width, height)
}