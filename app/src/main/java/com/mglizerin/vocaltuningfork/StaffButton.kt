package com.mglizerin.vocaltuningfork

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.support.graphics.drawable.VectorDrawableCompat
import android.support.v7.widget.AppCompatButton
import com.mglizerin.tuningfork.sound.interfaces.ISample
import com.mglizerin.tuningfork.sound.types.Accidental
import com.mglizerin.tuningfork.sound.types.ChordElement
import com.mglizerin.tuningfork.staff.ChordMetrics
import com.mglizerin.tuningfork.staff.NoteStemCoord
import com.mglizerin.tuningfork.staff.StaffGrid
import com.mglizerin.tuningfork.staff.maps.keyToAccidentalInfo
import kotlin.math.round

class StaffButton(
    context: Context?,
    resources: Resources,
    private val staffGrid: StaffGrid,
    private val sample: ISample
) : AppCompatButton(context) {

    private var paint = Paint()

    private val mFilledHead = VectorDrawableCompat.create(resources, R.drawable.ic_head_quarter, null)!!
    private val mOutlineHead = VectorDrawableCompat.create(resources, R.drawable.ic_head_half, null)!!
    private val mClef = VectorDrawableCompat.create(resources, R.drawable.ic_clef, null)!!
    private val mSharp = VectorDrawableCompat.create(resources, R.drawable.ic_sharp, null)!!
    private val mFlat = VectorDrawableCompat.create(resources, R.drawable.ic_flat, null)!!
    private val mNatural = VectorDrawableCompat.create(resources, R.drawable.ic_natural, null)!!

    init {
        this.width = px(staffGrid.staffGridWidth).toInt()
        this.height = px(staffGrid.staffGridHeight).toInt()

        initNoteHead()
        initAccidental(Accidental.SHARP, mSharp)
        initAccidental(Accidental.FLAT, mFlat)
        initAccidental(Accidental.NATURAL, mNatural)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (canvas != null) {
            canvas.drawColor(Color.LTGRAY)
            drawStaff(canvas)
        }
    }

    private fun initNoteHead() {
        val noteHeadWidth = px(staffGrid.noteHeadSize.width).toInt()
        val noteHeadHeight = px(staffGrid.noteHeadSize.height).toInt()

        mFilledHead.setBounds(0, 0, noteHeadWidth, noteHeadHeight)
        mOutlineHead.setBounds(0, 0, noteHeadWidth, noteHeadHeight)
    }

    private fun initAccidental(accidental: Accidental, drawable: VectorDrawableCompat) {
        val (width, height) = staffGrid.accidentalSize.get(accidental)!!

        val sharpWidth = px(width).toInt()
        val sharpHeight = px(height).toInt()

        drawable.setBounds(0, 0, sharpWidth, sharpHeight)
    }

    private fun drawStaff(canvas: Canvas) {
        drawBaseLines(canvas)
        drawClef(canvas)
        drawKey(canvas)
        drawChords(canvas)
    }

    /**
     * Рисует линейки нотного стана
     */
    private fun drawBaseLines(canvas: Canvas) {
        paint.color = Color.BLACK
        paint.strokeWidth = staffGrid.lineWeight.toFloat()

        staffGrid.baseLinesY.forEach {
            canvas.drawLine(0f, px(it), this.width.toFloat(), px(it), paint)
        }
    }

    /**
     * Рисует скрипичный ключ
     */
    private fun drawClef(canvas: Canvas) {
        when {
            staffGrid.showClef == true -> {
                val clefWidth = px(staffGrid.clefSize.width).toInt()
                val clefHeight = px(staffGrid.clefSize.height).toInt()
                val clefCoord = staffGrid.getClefCoord()

                mClef.setBounds(0, 0, clefWidth, clefHeight)
                drawVector(canvas, mClef, px(clefCoord.first), px(clefCoord.second))
            }
        }
    }

    /**
     * Рисует знаки альтерации при ключе
     */
    private fun drawKey(canvas: Canvas) {
        if (keyToAccidentalInfo.contains(sample.key())) {
            val (accidental, accidentalCount) = keyToAccidentalInfo.getValue(sample.key())

            for (i in 1..accidentalCount) {
                val coord = staffGrid.getKeyAccidentalCoord(accidental, i)
                drawVector(canvas, getAccidentalDrawable(accidental), px(coord.first), px(coord.second))
            }
        }
    }

    /**
     * Рисует последовательность аккордов
     */
    private fun drawChords(canvas: Canvas) {
        var offsetX = staffGrid.getChordStartX(sample.key())

        sample.chords().forEach { chord ->
            val chordMetrics = staffGrid.getChordMetrics(chord, sample.key())
            drawChord(canvas, chordMetrics, offsetX)
            offsetX += chordMetrics.width + staffGrid.spaceBetweenChords
        }
    }

    /**
     * Рисует аккорд
     */
    private fun drawChord(canvas: Canvas, chordMetrics: ChordMetrics, offsetX: Int) {
        chordMetrics.elements.forEach {
            val x = offsetX + it.coord.first
            val y = it.coord.second

            when (it.element) {
                ChordElement.FilledHead -> drawVector(canvas, mFilledHead, px(x), px(y))
                ChordElement.OutlineHead -> drawVector(canvas, mOutlineHead, px(x), px(y))
                ChordElement.Stem -> drawStem(canvas, x, it.stemCoord!!.y0, it.stemCoord!!.y1)
                ChordElement.Sharp -> drawVector(canvas, mSharp, px(x), px(y))
                ChordElement.Flat -> drawVector(canvas, mFlat, px(x), px(y))
                ChordElement.Natural -> drawVector(canvas, mNatural, px(x), px(y))
            }
        }
    }

    /**
     * Рисует нотный штилю
     */
    private fun drawStem(canvas: Canvas, x: Int, y0: Int, y1: Int) {
        paint.strokeWidth = 2f
        canvas.drawLine(px(x), px(y0), px(x), px(y1), paint)
        paint.strokeWidth = 1f
    }

    private fun getAccidentalDrawable(accidental: Accidental): VectorDrawableCompat = when (accidental) {
        Accidental.SHARP -> mSharp
        Accidental.FLAT -> mFlat
        else -> error("")
    }

    private fun drawVector(canvas: Canvas, noteHead: VectorDrawableCompat, x: Float, y: Float) {
        canvas.translate(x, y)
        noteHead.draw(canvas)
        canvas.translate(-x, -y)
    }

    private fun px(dp: Int): Float {
        return round(dp.toFloat() * resources.displayMetrics.density)
    }
}