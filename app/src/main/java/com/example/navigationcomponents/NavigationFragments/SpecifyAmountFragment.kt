package com.example.navigationcomponents.NavigationFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponents.R
import kotlinx.android.synthetic.main.fragment_specify_amount.*

class SpecifyAmountFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController: NavController? = Navigation.findNavController(view)

        cancelAmountBtn.setOnClickListener {
            navController!!.popBackStack()
        }

        val name = arguments?.getString("name")

        sendAmountBtn.setOnClickListener {
            val amount = enterAmountTV.text.toString()
            if(amount.isEmpty())
                Toast.makeText(context, "Amount is empty", Toast.LENGTH_SHORT).show()
            else {
                val bundle = bundleOf("name" to name,
                        "amount" to amount.toDouble())
                navController!!.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment ,
                bundle)
            }
        }
    }

}