package android.kotlin.demo

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.Color
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var mHandler: Handler
    private lateinit var mRunnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mHandler = Handler()
        button_run.setOnClickListener {
            mRunnable = Runnable {
                text_view.text = "Running....\n${Random().nextInt(9999)}"
                // repeat handler thread every 3 seconds
                mHandler.postDelayed(
                    mRunnable,
                    3 * 1000
                )
            }
            // first time do in 1 second
            mHandler.postDelayed(
                mRunnable,
                1 * 1000
            )
        }

        // Set a click listener for stop button
        button_stop.setOnClickListener {
            // Stop the periodic task
            mHandler.removeCallbacks(mRunnable)

            // Change the text view text
            text_view.text = getString(R.string.handler_call_back_removed)
        }

    }
}

