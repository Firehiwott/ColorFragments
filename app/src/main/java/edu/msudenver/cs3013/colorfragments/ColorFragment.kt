package edu.msudenver.cs3013.colorfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.view.ViewGroup


class ColorFragment : Fragment(R.layout.fragment_color) {

    companion object {
        var fragmentCount = 0

        fun newInstance(choice: Int): ColorFragment {
            val fragment = ColorFragment()
            val args = Bundle()
            args.putInt("COLOR_CHOICE", choice)
            fragment.arguments = args
            return fragment
        }
    }

    private var myIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            fragmentCount++
            myIndex = fragmentCount
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val choiceId = arguments?.getInt("COLOR_CHOICE", 0) ?: 0
        val chosenColorTV = view.findViewById<TextView>(R.id.mycolor)

        when (choiceId) {
            1 -> {
                chosenColorTV.text = "GENERIC BLUE FRAGMENT – UID $myIndex"
                view.setBackgroundColor(Color.rgb(150, 150, 255))
            }
            2 -> {
                chosenColorTV.text = "GENERIC RED FRAGMENT – UID $myIndex"
                view.setBackgroundColor(Color.rgb(255, 150, 150))
            }
            else -> {
                chosenColorTV.text = "NO COLOR CHOSEN – UID $myIndex"
                view.setBackgroundColor(Color.LTGRAY)
            }
        }
    }
}