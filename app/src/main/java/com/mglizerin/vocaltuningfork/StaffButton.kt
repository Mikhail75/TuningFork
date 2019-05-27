package com.mglizerin.vocaltuningfork

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.support.graphics.drawable.VectorDrawableCompat
import android.support.v7.widget.AppCompatButton
import com.mglizerin.tuningfork.staff.NoteStemCoord
import com.mglizerin.tuningfork.staff.StaffGrid
import kotlin.math.round

class StaffButton(
    context: Context?,
    resources: Resources,
    private val staffGrid: StaffGrid
) : AppCompatButton(context) {

    private var paint = Paint()

    private val mQuarterHead = VectorDrawableCompat.create(resources, R.drawable.ic_head_quarter, null)

    init {
        this.width = px(staffGrid.staffGridWidth).toInt()
        this.height = px(staffGrid.staffGridHeight).toInt()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (canvas != null) {
            canvas.drawColor(Color.LTGRAY)
            drawBaseLines(canvas)
            drawNotes(canvas)
        }
    }

    private fun drawBaseLines(canvas: Canvas) {
        paint.color = Color.BLACK
        paint.strokeWidth = staffGrid.lineWeight.toFloat()

        staffGrid.baseLinesY.forEach {
            canvas.drawLine(0f, px(it), this.width.toFloat(), px(it), paint)
        }

    }

    private fun drawNotes(canvas: Canvas) {
        val noteHeadWidth = px(staffGrid.noteHeadSize.width).toInt()
        val noteHeadHeight = px(staffGrid.noteHeadSize.height).toInt()

        val quarter = mQuarterHead!!
        quarter.setBounds(0, 0, noteHeadWidth, noteHeadHeight)

        val noteHeads = listOf<Pair<Int, Int>>(
            staffGrid.getNoteHeadCoord(10, 8),
            staffGrid.getNoteHeadCoord(10, 10),
            staffGrid.getNoteHeadCoord(10, 12),
            staffGrid.getNoteHeadCoord(30, 7),
            staffGrid.getNoteHeadCoord(30, 9),
            staffGrid.getNoteHeadCoord(30, 11),
            staffGrid.getNoteHeadCoord(50, 5)
        )

        noteHeads.forEach {
            drawNoteHead(canvas, quarter, px(it.first), px(it.second))
        }

        paint.strokeWidth = 2f

        val noteStems = listOf<NoteStemCoord>(
            staffGrid.getNoteStemDownCoord(10, 8, 3),
            staffGrid.getNoteStemDownCoord(30, 7, 3),
            staffGrid.getNoteStemDownCoord(50, 5)
        )

        noteStems.forEach {
            canvas.drawLine(px(it.x), px(it.y0), px(it.x), px(it.y1), paint)
        }
    }

    private fun drawNoteHead(canvas: Canvas, noteHead: VectorDrawableCompat, x: Float, y: Float) {
        canvas.translate(x, y)
        noteHead.draw(canvas)
        canvas.translate(-x, -y)
    }

    private fun px(dp: Int): Float {
        return round(dp.toFloat() * resources.displayMetrics.density)
    }
}