package com.example.navigationcomponents.NavigationFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponents.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController: NavController? = Navigation.findNavController(view)

        viewTransactionsBtn.setOnClickListener {
            navController!!.navigate(R.id.action_mainFragment_to_viewTransactionFragment2)
        }

        sendMoneyBtn.setOnClickListener {
            navController!!.navigate(R.id.action_mainFragment_to_chooseRecipientFragment)
        }

        viewBalanceBtn.setOnClickListener {
            navController!!.navigate(R.id.action_mainFragment_to_viewBalanceFragment)
        }
    }

}