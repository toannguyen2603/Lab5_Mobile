package com.lab5.healthMeasure

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class StartupFragment : Fragment(R.layout.fragment_startup) {

    @Inject
    lateinit var healthServicesManager: HealthServicesManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                val destination = if (healthServicesManager.hasExerciseCapability()) {
                    R.id.prepareFragment
                } else {
                    R.id.notAvailableFragment
                }
                findNavController().navigate(destination)
            }
        }
    }
}

@AndroidEntryPoint
class NotAvailableFragment : Fragment(R.layout.fragment_not_available)
