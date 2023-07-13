package com.mirodeon.eval_and2_exo1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getDrawable
import androidx.navigation.fragment.navArgs
import com.mirodeon.eval_and2_exo1.databinding.FragmentLoginBinding
import com.mirodeon.eval_and2_exo1.form.FormLoginFragment
import com.mirodeon.eval_and2_exo1.message.MessageFragment

class LoginFragment : Fragment() {
    private var binding: FragmentLoginBinding? = null
    private val args: LoginFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupImgHeader()
        (activity as MainActivity).show(R.id.containerFragmentLogin, FormLoginFragment())
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    private fun setupImgHeader() {
        val img = activity?.let {
            getDrawable(
                it,
                args.social.imgId
            )
        }
        binding?.imageLogin?.setImageDrawable(img)
    }
}