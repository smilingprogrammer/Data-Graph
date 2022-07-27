package com.example.graphdisplay.line.renderer.point

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.example.graphdisplay.line.renderer.point.PointDrawer

object NoPointDrawer : PointDrawer {
  override fun drawPoint(
    drawScope: DrawScope,
    canvas: Canvas,
    center: Offset
  ) {
    // Leave empty on purpose, we do not want to draw anything.
  }
}