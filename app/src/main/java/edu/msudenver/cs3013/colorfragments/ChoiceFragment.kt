package edu.msudenver.cs3013.colorfragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.widget.TextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ChoiceFragment : Fragment(R.layout.fragment_choice) {

    interface ChoiceListener {
        fun onSelected(id: Int)
    }

    private var choiceListener: ChoiceListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ChoiceListener) {
            choiceListener = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val redT = view.findViewById<TextView>(R.id.redText)
        val blueT = view.findViewById<TextView>(R.id.blueText)

        redT.setOnClickListener {
            choiceListener?.onSelected(2)
        }

        blueT.setOnClickListener {
            choiceListener?.onSelected(1)
        }
    }
}