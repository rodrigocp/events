package br.com.rcp.details.fragments

import android.content.Context
import android.location.Geocoder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import br.com.rcp.commons.utils.Binding
import br.com.rcp.commons.utils.ResponseHandler
import br.com.rcp.details.R
import br.com.rcp.details.databinding.FragmentDetailBinding
import br.com.rcp.details.viewmodels.DetailViewModel
import br.com.rcp.domain.models.Event
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.math.BigDecimal
import java.util.*

class DetailFragment : Fragment() {
    private val viewmodel by viewModel<DetailViewModel>()
    private lateinit var binding: FragmentDetailBinding
    private var identifier: Long? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        identifier = arguments?.getLong("id")

        if (identifier == null) {
            Toast.makeText(requireContext(), getString(R.string.event_error), Toast.LENGTH_LONG)
                .show()
            findNavController().popBackStack()
        } else {
            viewmodel.getDetail(requireActivity(), identifier!!)
            setDetailObserver()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    private fun initializeClickListeners(event: Event) {
        binding.checkin.setOnClickListener {
            CheckDialogFragment(identifier!!).show(
                childFragmentManager,
                null
            )
        }
        binding.local.setOnClickListener {
            requireView().findNavController().navigate(DetailFragmentDirections.toMaps("${event.latitude}:${event.longitude}"))
        }
    }

    private fun setLocationEvent(context: Context, longitude: BigDecimal, latitude: BigDecimal) {
        val geocoder = Geocoder(context, getLocale())
        val address = geocoder.getFromLocation(latitude.toDouble(), longitude.toDouble(), 1)
        binding.local.bind(address[0].subAdminArea)
    }

    private fun retrieve(event: Event) {
        binding.description.text = event.description
        binding.date.bind(event.date)
        binding.hour.bind(event.date)
        setLocationEvent(requireContext(), event.longitude, event.latitude)
        Binding.loadImage(binding.photo, event.image)
    }

    private fun getLocale(): Locale {
        return Locale("pt", "BR")
    }

    private fun setDetailObserver() {
        viewmodel.loading.observe(requireActivity()) { loading ->
            if (loading) {
                binding.progress.visibility = View.VISIBLE
            } else {
                binding.progress.visibility = View.GONE
            }
        }

        viewmodel.getDetail(requireContext(), identifier ?: 0L).observe(requireActivity()) {
            it?.let { resource ->
                when (resource) {
                    is ResponseHandler.Success -> {
                        retrieve(resource.data)
                        initializeClickListeners(resource.data)
                    }
                    is ResponseHandler.Failure -> {
                        Toast.makeText(requireContext(), resource.exception, Toast.LENGTH_LONG)
                            .show()
                        findNavController().popBackStack()
                    }
                }
            }
        }
    }
}
