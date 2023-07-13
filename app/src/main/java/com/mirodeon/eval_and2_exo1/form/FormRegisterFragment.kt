package com.mirodeon.eval_and2_exo1.form

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.mirodeon.eval_and2_exo1.MainActivity
import com.mirodeon.eval_and2_exo1.R
import com.mirodeon.eval_and2_exo1.databinding.FragmentFormRegisterBinding
import com.mirodeon.eval_and2_exo1.message.MessageFragment

class FormRegisterFragment : Fragment() {
    private var binding: FragmentFormRegisterBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFormRegisterBinding.inflate(inflater, container, false)
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
        binding?.btnRegister?.setOnClickListener {
            val connect = validate()
            if (connect.success) {
                (activity as MainActivity).show(
                    R.id.containerFragmentRegister,
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

        if (binding?.inputEmailRegister?.text.toString().isBlank()) {
            result.message = "L'email n'a pas été rempli."
            return result
        }
        if (!binding?.inputEmailRegister?.text.toString().contains('@')) {
            result.message = "L'email ne contient pas de '@'."
            return result
        }
        if (binding?.inputLoginRegister?.text.toString().isBlank()) {
            result.message = "Le login n'a pas été rempli."
            return result
        }
        if (binding?.inputPasswordRegister?.text.toString().isBlank()) {
            result.message = "Le mot de passe n'a pas été rempli."
            return result
        }
        if (binding?.inputPasswordRegister?.text.toString() != binding?.inputConfirmationRegister?.text.toString()) {
            result.message = "La confirmation du mot de passe ne correspond pas."
            return result
        }

        result.success = true
        result.message = "Bienvenue ${binding?.inputLoginRegister?.text} !"
        return result
    }
}