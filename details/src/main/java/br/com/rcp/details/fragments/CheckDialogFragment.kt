package br.com.rcp.details.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import br.com.rcp.commons.utils.ResponseHandler
import br.com.rcp.details.databinding.FragmentDialogBinding
import br.com.rcp.details.viewmodels.DialogViewModel
import br.com.rcp.domain.models.CheckIn
import org.koin.androidx.viewmodel.ext.android.viewModel

class CheckDialogFragment(private val identifier: Long) : DialogFragment() {
    private          val viewmodel  by viewModel<DialogViewModel>()
    private lateinit var binding    : FragmentDialogBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDialogBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.dialog.bind(identifier) {
            setCheckInObserver(it)
        }
    }

    private fun setCheckInObserver(checkIn: CheckIn) {
        viewmodel.doCheckIn(requireContext(), checkIn).observe(requireActivity(), {
            it?.let { resource ->
                when (resource) {
                    is ResponseHandler.Success -> {
                        if (resource.data.isSuccessful) {
                            Toast.makeText(requireContext(), "Sucesso!", Toast.LENGTH_LONG).show()
                        } else {
                            Toast.makeText(requireContext(), "Erro!", Toast.LENGTH_LONG).show()
                        }
                        dismiss()
                    }
                    is ResponseHandler.Failure -> {
                        Toast.makeText(requireContext(), "Erro!", Toast.LENGTH_LONG).show()
                        dismiss()
                    }
                }
            }
        })
    }
}