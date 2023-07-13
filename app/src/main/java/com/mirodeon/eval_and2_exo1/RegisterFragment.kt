package com.mirodeon.eval_and2_exo1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mirodeon.eval_and2_exo1.databinding.FragmentRegisterBinding
import com.mirodeon.eval_and2_exo1.form.FormLoginFragment
import com.mirodeon.eval_and2_exo1.form.FormRegisterFragment

class RegisterFragment : Fragment() {
    private var binding: FragmentRegisterBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).show(R.id.containerFragmentRegister, FormRegisterFragment())
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}