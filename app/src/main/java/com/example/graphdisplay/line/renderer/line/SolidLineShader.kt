package com.example.graphdisplay.line.renderer.line

import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.example.graphdisplay.line.renderer.line.LineShader

class SolidLineShader(val color: Color = Color.Blue) : LineShader {
    override fun fillLine(drawScope: DrawScope, canvas: Canvas, fillPath: Path) {
        drawScope.drawPath(
            path = fillPath,
            color = color
        )
    }
}
