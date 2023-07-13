package com.mirodeon.eval_and2_exo1.form

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.mirodeon.eval_and2_exo1.MainActivity
import com.mirodeon.eval_and2_exo1.R
import com.mirodeon.eval_and2_exo1.databinding.FragmentFormLoginBinding
import com.mirodeon.eval_and2_exo1.message.MessageFragment

class FormLoginFragment() : Fragment() {
    private var binding: FragmentFormLoginBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFormLoginBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBtn()
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    private fun setupBtn() {
        binding?.btnLogin?.setOnClickListener {
            val connect = validate()
            if (connect.success) {
                (activity as MainActivity).show(
                    R.id.containerFragmentLogin,
                    MessageFragment(connect.message)
                )
            } else {
                val builder = AlertDialog.Builder(requireContext(), R.style.AppTheme_AlertDialog)
                builder
                    .setTitle("ERROR")
                    .setMessage(connect.message)
                    .setPositiveButton("OK") { dialog, which ->
                    }
                    .create()
                    .show()
            }
        }
    }

    private fun validate(): Validate {
        val result = Validate(false, "Something went wrong !")

        if (binding?.inputEmailLogin?.text.toString().isBlank()) {
            result.message = "L'email n'a pas été rempli."
            return result
        }
        if (!binding?.inputEmailLogin?.text.toString().contains('@')) {
            result.message = "L'email ne contient pas de '@'."
            return result
        }
        if (binding?.inputPasswordLogin?.text.toString().isBlank()) {
            result.message = "Le mot de passe n'a pas été rempli."
            return result
        }

        result.success = true
        result.message = getString(R.string.success_login)
        return result
    }
}