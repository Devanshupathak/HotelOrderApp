package com.vishwa.hotelorderapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.vishwa.hotelorderapp.databinding.FragmentLoginBinding
import com.vishwa.hotelorderapp.util.Validate
import com.vishwa.hotelorderapp.util.ValidationException

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogin.setOnClickListener {
            try {
                Validate(binding.edtEmail).isEmptyWithTrim("Please enter email")
                    .checkEmail("Please enter valid email")
                Validate(binding.edtPassword).isEmpty("Please enter password")
            }catch (ex:ValidationException){
                Snackbar.make(view,ex.localizedMessage,Snackbar.LENGTH_LONG).show()
            }
        }

        binding.tvSignup.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }
    }




}