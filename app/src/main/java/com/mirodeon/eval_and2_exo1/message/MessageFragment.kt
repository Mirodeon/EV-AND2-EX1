package com.mirodeon.eval_and2_exo1.message

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mirodeon.eval_and2_exo1.R
import com.mirodeon.eval_and2_exo1.databinding.FragmentMessageBinding

class MessageFragment(private val message: String) : Fragment() {
    private var binding: FragmentMessageBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupTxt()
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    private fun setupTxt() {
        binding?.txtMessageForm?.text = message
    }
}