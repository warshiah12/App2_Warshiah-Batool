package com.example.paint_app

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.example.paint_app.paintactivity.Companion.cursor
import com.example.paint_app.paintactivity.Companion.path

class draw : View {
    var params : ViewGroup.LayoutParams? = null //to see the height and width of our canvas in comparison to the main layout's
    companion object{
        var canva = ArrayList<Path>()
        var colorPalette = ArrayList<Int>()
        var defaultColor = Color.BLUE
    }
    constructor(context: Context) : this(context, null){
        init()
    }
    constructor(context: Context, attribute: AttributeSet?) : this(context, attribute, 0){
        init()
    }
    constructor(context: Context, attribute: AttributeSet?, defStyleAttr:Int) : super(context,attribute,defStyleAttr){
        init()
    }
    private fun init(){
        cursor.isAntiAlias = true  //using 'isAntiAlias' so that we can draw smoothly
        cursor.color = defaultColor
        cursor.style = Paint.Style.STROKE
        cursor.strokeJoin = Paint.Join.ROUND
        cursor.strokeWidth = 0f
        params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
    }
    override fun onTouchEvent(event: MotionEvent): Boolean {
        var x = event.x
        var y = event.y

        when(event.action){
            MotionEvent.ACTION_DOWN ->{
                path.moveTo(x,y)
                return true
            }
            MotionEvent.ACTION_MOVE ->{
                path.lineTo(x,y)
                canva.add(path)
                colorPalette.add(defaultColor)
            }
            else ->
                return false
        }
        postInvalidate()
        return false
    }

    override fun onDraw(canvas: Canvas) {
        for(j in canva.indices){
            cursor.setColor(colorPalette[j])
            canvas.drawPath(canva[j], cursor)
            invalidate()
        }
    }
    }
