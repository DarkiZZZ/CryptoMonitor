package ru.msokolov.cryptomonitorapp.presentation.signin

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ru.msokolov.cryptomonitorapp.R
import ru.msokolov.cryptomonitorapp.databinding.FragmentSignInBinding
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.OperationState
import ru.msokolov.cryptomonitorapp.presentation.CryptoApplication
import ru.msokolov.cryptomonitorapp.presentation.ViewModelFactory
import javax.inject.Inject


class SignInFragment : Fragment(R.layout.fragment_sign_in) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[SignInViewModel::class.java]
    }

    private lateinit var binding: FragmentSignInBinding

    private val component by lazy {
        (requireActivity().application as CryptoApplication).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignInBinding.bind(view)
        observeViewModel()
        setupClickListeners()
    }

    private fun observeViewModel() {
        viewModel.getOperationState().observe(viewLifecycleOwner){
            when(it){
                is OperationState.Success -> {
                    longToast(it.message)
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

    private fun setupClickListeners() {
        with(binding) {
            signInButton.setOnClickListener {
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()
                viewModel.signIn(email = email, password = password)

            }
            registerTextView.setOnClickListener {
                goToRegistration(getEmail())
            }
            forgotPasswordTextView.setOnClickListener {
                shortToast(TODO_TEXT)
            }
        }
    }

    private fun shortToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun longToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    private fun goToRegistration(email: String) = findNavController()
        .navigate(SignInFragmentDirections.actionSignInFragmentToSignUpFragment(email)
    )

    private fun getEmail(): String {
        return binding.emailEditText.text.toString()
    }

    companion object {
        private const val TODO_TEXT = "Will come soon"
    }
}