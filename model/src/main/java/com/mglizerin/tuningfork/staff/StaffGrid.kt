package com.mglizerin.tuningfork.staff

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
    /** Y-координаты основных линеек нотного стана */
    val baseLinesY: List<Int>
    /** Параметры нотной головки */
    val noteHeadSize: NoteHeadSize

    /** Y-координаты горизонтальных направляющих нотного стана */
    private var mHGuidesY: List<Int>
    /** X-координаты вертикальных направляющих нотного стана */
    private var mVGuidesX: List<Int>

    init {
        mHGuidesY = calculateHorizontalGuidesY(staffGridHeight, params.hGuidesCount)
        mVGuidesX = calculateVerticalGuidesX(staffGridWidth, params.spaceBetweenVGuides)

        baseLinesY = calculateBaseLinesY(mHGuidesY, params.baseLinesGuides)
        noteHeadSize = calculateNoteHeadSize(baseLinesY, lineWeight, params.noteHeadWidthRatio)
    }

    /**
     * @param vGuideNumber Номер вертикальной направляющей
     * @param hGuideNumber Номер горизонтальной направляющей
     * @return Пару, содрежающую x- и y-координаты нотной головки
     */
    fun getNoteHeadCoord(vGuideNumber: Int, hGuideNumber: Int): Pair<Int, Int> {
        return mVGuidesX[vGuideNumber] to mHGuidesY[hGuideNumber] + lineWeight
    }

    /**
     * @param vGuideNumber Номер вертикальной направляющей
     * @param hGuideNumber Номер горизонтальной направляющей
     * @return [Координаты нотного штиля][NoteStemCoord]
     */
    fun getNoteStemDownCoord(vGuideNumber: Int, hGuideNumber: Int, notesInAccord: Int = 1): NoteStemCoord {
        val noteHeadCoord = getNoteHeadCoord(vGuideNumber, hGuideNumber)
        val baseStemLength = noteHeadSize.height * 2

        val x = noteHeadCoord.first
        val y0 = round(noteHeadCoord.second + noteHeadSize.height * 0.6f).toInt()
        val y1 = y0 + baseStemLength + notesInAccord * noteHeadSize.height

        return NoteStemCoord(x, y0, y1)
    }
}