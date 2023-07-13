package com.mirodeon.eval_and2_exo1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mirodeon.eval_and2_exo1.databinding.FragmentHomeBinding
import com.mirodeon.eval_and2_exo1.social.SocialCategories

class HomeFragment : Fragment() {
    private var binding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
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
        binding?.btnToTwitter?.setOnClickListener {
            val direction =
                HomeFragmentDirections.actionHomeFragmentToLoginFragment(SocialCategories.TWITTER)
            findNavController().navigate(direction)
        }
        binding?.btnToFacebook?.setOnClickListener {
            val direction =
                HomeFragmentDirections.actionHomeFragmentToLoginFragment(SocialCategories.FACEBOOK)
            findNavController().navigate(direction)
        }
        binding?.btnToBloggies?.setOnClickListener {
            val direction =
                HomeFragmentDirections.actionHomeFragmentToRegisterFragment()
            findNavController().navigate(direction)
        }
    }
}