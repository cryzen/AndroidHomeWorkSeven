package com.example.androidhomeworkseven

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_press).setOnClickListener {
            replaceFragment(AnimationFragment())
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val btn = findViewById<Button>(R.id.btn_press)
        btn.isInvisible = false
    }

    private fun replaceFragment(fragment: Fragment) {

        val btn = findViewById<Button>(R.id.btn_press)
        btn.isInvisible = true

        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .setCustomAnimations(R.anim.up_in, R.anim.up_out, R.anim.up_in, R.anim.up_out)
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}