package ru.msokolov.cryptomonitorapp.presentation.signin

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ru.msokolov.cryptomonitorapp.R
import ru.msokolov.cryptomonitorapp.databinding.FragmentSignInBinding
import ru.msokolov.cryptomonitorapp.domain2.entity.SignInState
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
        setClickListeners()
    }

    private fun observeViewModel(email: String, password: String){
        viewModel.login(email, password).observe(viewLifecycleOwner){
            when(it){
                 is SignInState.Success-> {
                     toast(it.message)
                    findNavController().navigate(R.id.action_signInFragment_to_tabsFragment)
                 }
                is SignInState.Error -> {
                    toast(it.message)
                }
            }
        }
    }

    private fun setClickListeners(){
        with(binding){
            signInButton.setOnClickListener {
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()
                if(viewModel.isLoginDataCorrect(email, password)){
                    observeViewModel(email, password)
                }
                else{
                    toast(ERROR_DATA_VALIDATION)
                }

            }
            registerTextView.setOnClickListener {
                toast(TODO_TEXT)
            }
            forgotPasswordTextView.setOnClickListener {
                toast(TODO_TEXT)
            }
        }
    }

    private fun toast(message: String){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    companion object{
        private const val ERROR_DATA_VALIDATION = "Please, fill all fields!"
        private const val TODO_TEXT = "Will come soon"
    }

}