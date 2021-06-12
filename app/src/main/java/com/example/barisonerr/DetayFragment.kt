package com.example.barisonerr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.barisonerr.databinding.FragmentDetayBinding
import kotlinx.android.synthetic.main.fragment_detay.*
import kotlinx.android.synthetic.main.fragment_listeleme.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DetayFragment : Fragment() {

    private var _binding: FragmentDetayBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetayBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        listView.setOnItemClickListener { adapterView, view, i, l ->

        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}