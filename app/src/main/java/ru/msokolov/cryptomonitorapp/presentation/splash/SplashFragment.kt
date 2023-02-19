package ru.msokolov.cryptomonitorapp.presentation.splash

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.msokolov.cryptomonitorapp.R
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.OperationState
import ru.msokolov.cryptomonitorapp.presentation.CryptoApplication
import ru.msokolov.cryptomonitorapp.presentation.MainActivity
import ru.msokolov.cryptomonitorapp.presentation.MainActivityArgs
import ru.msokolov.cryptomonitorapp.presentation.ViewModelFactory
import javax.inject.Inject


class SplashFragment : Fragment(R.layout.fragment_splash) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[SplashViewModel::class.java]
    }

    private val component by lazy {
        (requireActivity().application as CryptoApplication).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    private fun observeViewModel(){
        viewModel.getOperationState().observe(viewLifecycleOwner){
            when(it){
                is OperationState.Success -> launchMainScreen(isAuthorized = true)
                is OperationState.Error -> launchMainScreen(isAuthorized = false)
            }
        }
    }

    private fun launchMainScreen(isAuthorized: Boolean) {
        val intent = Intent(requireContext(), MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        val args = MainActivityArgs(isAuthorized)
        intent.putExtras(args.toBundle())
        startActivity(intent)
    }
}