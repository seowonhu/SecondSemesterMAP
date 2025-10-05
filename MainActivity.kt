package com.example.project4_2_homework

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project4_2_homework.R.*

class MainActivity : AppCompatActivity() {
    // 뷰 선언
    lateinit var startSwitch: Switch
    lateinit var textView2: TextView
    lateinit var rGroup1: RadioGroup
    lateinit var rdoOreo: RadioButton
    lateinit var rdoPie : RadioButton
    lateinit var rdoQ : RadioButton
    lateinit var btnOK: Button
    lateinit var btnRestart: Button
    lateinit var btnQuit : Button
    lateinit var imgAnd: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        startSwitch = findViewById<Switch>(id.switch1)
        textView2 = findViewById<TextView>(id.textView)
        rGroup1 = findViewById<RadioGroup>(id.rdoGroup)
        rdoOreo = findViewById<RadioButton>(id.rdoOreo)
        rdoPie = findViewById<RadioButton>(id.rdoPie)
        rdoQ = findViewById<RadioButton>(id.rdoQ)

        btnRestart = findViewById<Button>(id.button2)
        btnQuit= findViewById<Button>(id.button)
        imgAnd = findViewById<ImageView>(id.imageView)

        // 초기  숨김 처리
        textView2.visibility = View.INVISIBLE
        rGroup1.visibility = View.INVISIBLE
        btnRestart.visibility = View.INVISIBLE
        btnQuit.visibility = View.INVISIBLE
        imgAnd.visibility = View.INVISIBLE

        // 체크박스 체크 시 나머지 요소들 보이기/숨기기
        startSwitch.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                textView2.visibility = View.VISIBLE
                rGroup1.visibility = View.VISIBLE
                btnRestart.visibility = View.VISIBLE
                btnQuit.visibility = View.VISIBLE
            } else {
                textView2.visibility = View.INVISIBLE
                rGroup1.visibility = View.INVISIBLE
                btnRestart.visibility = View.INVISIBLE
                btnQuit.visibility = View.INVISIBLE
                imgAnd.visibility = View.INVISIBLE
                rGroup1.clearCheck()
            }
        }

        rGroup1.setOnCheckedChangeListener { group, checkedId ->
            imgAnd.visibility = View.VISIBLE
            when (checkedId) { // 선택된 라디오 버튼의 ID에 따라
                id.rdoOreo -> imgAnd.setImageResource(drawable.oreo) // 이미지 설정
                id.rdoPie -> imgAnd.setImageResource(drawable.pie)
                id.rdoQ -> imgAnd.setImageResource(drawable.q10)
            }
        }

        btnQuit.setOnClickListener {
            finish()
        }

        btnRestart.setOnClickListener {
            startSwitch.isChecked = false
        }
    }
}
