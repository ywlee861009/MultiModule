package com.example.multimodule.presentation.test

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.view.updateLayoutParams
import com.example.multimodule.presentation.R

class ExpandableCardView @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyle: Int = 0
): CardView(context, attr, defStyle) {
    private lateinit var titleView: View
    private lateinit var contentLayout: ViewGroup
    private lateinit var arrow: View

    private var expanded = false

    private var animating = false

    private var animDuration = 150L

    private val expandAnimator: ValueAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
        duration = animDuration

        addUpdateListener {
            val progress = it.animatedValue as Float
            val wrapContentHeight = contentLayout.measureWrapContentHeight()
            contentLayout.updateLayoutParams {
                height = (wrapContentHeight * progress).toInt()
            }

            arrow.rotation = progress * 180
        }
        addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator) {
                super.onAnimationStart(animation)
                animating = true
            }

            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                animating = false
            }
        })
    }


    override fun onFinishInflate() {
        super.onFinishInflate()

        val parentLayout = getChildAt(0) as ViewGroup

        titleView = parentLayout.getChildAt(0)
        contentLayout = parentLayout.getChildAt(1) as ViewGroup
        arrow = parentLayout.findViewById(R.id.iv_arrow)

        if (expanded) {
            arrow.rotation = 180f
        } else {
            contentLayout.updateLayoutParams {
                height = 0
            }
            arrow.rotation = 0f
        }

        titleView.setOnClickListener {
            expanded = when {
                animating -> {
                    expandAnimator.reverse()
                    !expanded
                }
                expanded -> {
                    expandAnimator.reverse()
                    false
                }
                else -> {
                    expandAnimator.start()
                    true
                }
            }
        }
    }
}

fun ViewGroup.measureWrapContentHeight(): Int {
    this.measure(
        View.MeasureSpec
            .makeMeasureSpec((this.parent as View).measuredWidth, View.MeasureSpec.EXACTLY),
        View.MeasureSpec
            .makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
    )
    return measuredHeight
}