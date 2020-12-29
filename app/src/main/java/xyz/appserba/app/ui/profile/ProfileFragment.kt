package xyz.appserba.app.ui.profile

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import xyz.appserba.app.R
import xyz.appserba.app.databinding.ActivityMainBinding
import xyz.appserba.app.databinding.FragmentProfileBinding
import xyz.appserba.app.ui.auth.AppserbaAuth
import xyz.appserba.app.ui.auth.AuthActivity
import xyz.appserba.app.ui.home.MainActivity

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    lateinit var viewModel: ProfileViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = activity?.let { DataBindingUtil.setContentView(it, R.layout.fragment_profile) }!!
        binding.btnLogout.setOnClickListener {
            AppserbaAuth.logout(requireActivity()) {
                activity?.let {
                    val intent = Intent(it, AuthActivity::class.java)
                    startActivity(intent)
                }
            }
        }
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        // TODO: Use the ViewModel
    }

}