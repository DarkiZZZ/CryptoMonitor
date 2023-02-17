package ru.msokolov.cryptomonitorapp.presentation.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.navOptions
import ru.msokolov.cryptomonitorapp.R
import ru.msokolov.cryptomonitorapp.databinding.FragmentProfileBinding
import ru.msokolov.cryptomonitorapp.presentation.CryptoApplication
import ru.msokolov.cryptomonitorapp.presentation.ViewModelFactory
import ru.msokolov.cryptomonitorapp.presentation.utils.findTopNavController
import ru.msokolov.cryptomonitorapp.presentation.utils.shortToast
import javax.inject.Inject

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[ProfileViewModel::class.java]
    }

    private lateinit var binding: FragmentProfileBinding

    private val component by lazy {
        (requireActivity().application as CryptoApplication).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)
        observeViewModel()
        setupClickListeners()

    }

    private fun setupClickListeners(){
        binding.editProfileButton.setOnClickListener {
            shortToast(TODO_TEXT)
        }
        binding.logoutButton.setOnClickListener {
            onLogoutButtonPressed()
        }
    }

    /*private fun onEditProfileButtonPressed() {
        findTopNavController().navigate(R.id.editProfileFragment)
    }*/

    private fun observeViewModel() {
        viewModel.getCallback().observe(viewLifecycleOwner) {
            if (it != null) {
                findTopNavController().navigate(R.id.signInFragment, null, navOptions {
                    popUpTo(R.id.tabsFragment) {
                        inclusive = true
                    }
                })
            }
        }
    }

    private fun onLogoutButtonPressed() {
        viewModel.logout()
    }

    companion object{
        private const val TODO_TEXT = "Will come soon"
    }
}