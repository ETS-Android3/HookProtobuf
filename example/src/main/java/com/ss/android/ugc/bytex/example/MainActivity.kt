package com.ss.android.ugc.bytex.example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ss.android.ugc.bytex.example.coverage.CoverageReportTask
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Handle coverage log info, send to the server
        CoverageReportTask.init()
        textView.text = TestAsm().test()
    }
}
