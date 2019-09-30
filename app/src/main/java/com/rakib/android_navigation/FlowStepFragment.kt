package com.rakib.android_navigation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_flow_step_one.*

/**
 * A simple [Fragment] subclass.
 */
class FlowStepFragment : Fragment() {

    var name = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val safeArgs: FlowStepFragmentArgs by navArgs()
        val flowStepNumber = safeArgs.flowStepNumber
        name = safeArgs.testName

        // Inflate the layout for this fragment
        return when (flowStepNumber) {
            1 -> inflater.inflate(R.layout.fragment_flow_step_one, container, false)
            else -> inflater.inflate(R.layout.fragment_flow_step_two, container, false)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        next_button.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_next)
        )
        Toast.makeText(activity,name,Toast.LENGTH_SHORT).show()
    }

}
