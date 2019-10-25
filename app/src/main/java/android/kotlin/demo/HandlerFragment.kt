package android.kotlin.demo


import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_handler.view.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class HandlerFragment : Fragment() {

    private var handler: Handler = Handler()
    private var runnable: Runnable? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_handler, container, false)
        v.button_run.setOnClickListener {
            runnable = Runnable {
                v.text_view.text = "Running....\n${Random().nextInt(9999)}"
                // repeat handler thread every 3 seconds
                handler.postDelayed(
                    runnable,
                    3 * 1000
                )
            }
            // first time do in 1 second
            handler.postDelayed(
                runnable,
                1 * 1000
            )
        }

        // Set a click listener for stop button
        v.button_stop.setOnClickListener {
            // Stop the periodic task
            handler.removeCallbacks(runnable)

            // Change the text view text
            v.text_view.text = getString(R.string.handler_call_back_removed)
        }

//        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
//            // Handle the back button event
//            Log.d("test", "on back press");
//            handler.removeCallbacks(runnable)
//            requireActivity().onBackPressedDispatcher.onBackPressed()
//        }

        return v
    }

    override fun onPause() {
        super.onPause()
        // handler null error
        runnable?.let {
            handler.removeCallbacks(it)
        }
    }
}
