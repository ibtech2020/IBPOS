package com.infobooktechnologies.ibpos

import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout

abstract class BaseActivity : AppCompatActivity() {
    lateinit var  coordinatorLayout : CoordinatorLayout
    lateinit var toolbar: Toolbar


    override fun setContentView(layoutResID: Int) {
        coordinatorLayout = layoutInflater.inflate(R.layout.activity_base, null) as CoordinatorLayout
        var activityContainer: FrameLayout = coordinatorLayout.findViewById(R.id.layout_container)
        layoutInflater.inflate(layoutResID, activityContainer, true)
        toolbar = coordinatorLayout.findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        super.setContentView(coordinatorLayout)
    }
}