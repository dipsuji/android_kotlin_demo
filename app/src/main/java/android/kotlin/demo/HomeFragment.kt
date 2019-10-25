package android.kotlin.demo


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.view.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        Log.d("HomeFragment TAG", "message")

        val v = inflater.inflate(R.layout.fragment_home, container, false)

        v.handler_demo.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_handlerFragment)
        }
        v.broadcast_demo.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_broadcastReceiverFragment)
        }
        return v
    }
}
