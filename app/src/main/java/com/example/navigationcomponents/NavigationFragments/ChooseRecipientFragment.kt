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
import kotlinx.android.synthetic.main.fragment_choose_recipient.*

class ChooseRecipientFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController: NavController? = Navigation.findNavController(view)

        cancelNameBtn.setOnClickListener {
            navController!!.popBackStack()
        }

        nextBtn.setOnClickListener {
            val name = enterNameTV.text.toString()
            if(name.isEmpty()) {
                Toast.makeText(context , "Name is empty", Toast.LENGTH_SHORT).show()
            } else {
                val bundle = bundleOf("name" to name)

                navController!!.navigate(R.id.action_chooseRecipientFragment_to_specifyAmountFragment,
                bundle)
            }

        }
    }
}