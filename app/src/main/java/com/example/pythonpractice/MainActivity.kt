package com.example.pythonpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform

class MainActivity : AppCompatActivity() {
    lateinit var py: Python

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initPython()

        val pyObj = py.getModule("hello")

        pyObj.callAttr("greet", "name")

        val result = pyObj.callAttr("add", 2, 3)
        findViewById<TextView>(R.id.main_text).text = "Hello ${result.toInt()}"
    }

    fun initPython() {
        if(!Python.isStarted()) {
            Python.start(AndroidPlatform(this))
            py = Python.getInstance()
        }
    }
}