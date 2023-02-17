package ru.msokolov.cryptomonitorapp.presentation.signup

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ru.msokolov.cryptomonitorapp.R
import ru.msokolov.cryptomonitorapp.databinding.FragmentSignUpBinding
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.OperationState
import ru.msokolov.cryptomonitorapp.presentation.CryptoApplication
import ru.msokolov.cryptomonitorapp.presentation.ViewModelFactory
import javax.inject.Inject

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[SignUpViewModel::class.java]
    }

    private val args by navArgs<SignUpFragmentArgs>()

    private lateinit var binding: FragmentSignUpBinding

    private val component by lazy {
        (requireActivity().application as CryptoApplication).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignUpBinding.bind(view)
        setEmailFromSignInField(args.email)
        observeViewModel()
        setupClickListeners()
    }

    private fun observeViewModel(){
        viewModel.getOperationState().observe(viewLifecycleOwner){
            when(it){
                is OperationState.Success -> {
                    longToast(getString(R.string.success_sign_up_toast))
                    findNavController().popBackStack()
                }
                is OperationState.Error -> {
                    longToast(it.message)
                }
            }
        }
        viewModel.emptyFieldsListener.observe(viewLifecycleOwner){
            if (it != null){
                shortToast(getString(R.string.empty_fields_toast))
            }
        }
    }

    private fun setupClickListeners(){
        binding.signUpButton.setOnClickListener {
            binding.apply {
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()
                val firstName = firstNameEditText.text.toString()
                val lastName = lastNameEditText.text.toString()
                val age = ageEditText.text.toString()
                viewModel.signUp(
                    email = email,
                    password = password,
                    firstName = firstName,
                    lastName = lastName,
                    age = age
                )
            }
        }
    }

    private fun setEmailFromSignInField(email: String){
        binding.emailEditText.setText(email)
    }

    private fun longToast(message: String){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    private fun shortToast(message: String){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}