package com.example.androidhomeworkseven

import android.animation.*
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class AnimationFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_animation, container, false).also {
            it.findViewById<Button>(R.id.start_btn).setOnClickListener {
                startAnimation()
            }
        }

    private fun startAnimation() {
        val square = requireView().findViewById<View>(R.id.square)
        val rectangle = requireView().findViewById<View>(R.id.rectangle)

        val squareParams = square.layoutParams
        val rectangleParams = rectangle.layoutParams

        val squareWidth = resources.getDimension(R.dimen.square)
        val squareBigWidth = resources.getDimension(R.dimen.big_square)

        val rectangleHeight = resources.getDimension(R.dimen.rectangle_height)
        val rectangleBigHeight = resources.getDimension(R.dimen.big_rectangle_height)

        ValueAnimator.ofArgb(Color.parseColor("#FF6200EE"), Color.parseColor("#FFFF2903")).apply {
            duration = 400L
            addUpdateListener { valueAnimator: ValueAnimator ->
                val animatedColor = valueAnimator.animatedValue as Int
                square.setBackgroundColor(animatedColor)
            }
            start()
        }

        ValueAnimator.ofFloat(squareWidth, squareBigWidth).apply {
            duration = 400L
            addUpdateListener { valueAnimator: ValueAnimator ->
                val animatedSize = valueAnimator.animatedValue as Float
                squareParams.width = animatedSize.toInt()
                squareParams.height = animatedSize.toInt()
                square.layoutParams = squareParams
            }
            start()
        }

        ValueAnimator.ofFloat(rectangleHeight, rectangleBigHeight).apply {
            duration = 400L
            addUpdateListener { valueAnimator: ValueAnimator ->
                val animatedHeight = valueAnimator.animatedValue as Float
                rectangleParams.height = animatedHeight.toInt()
                rectangle.layoutParams = rectangleParams
            }
            start()
        }
    }
}