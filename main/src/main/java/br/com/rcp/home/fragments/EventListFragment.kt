package br.com.rcp.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import br.com.rcp.commons.utils.ResponseHandler
import br.com.rcp.domain.models.Event
import br.com.rcp.home.adapters.EventListAdapter
import br.com.rcp.home.databinding.FragmentHomeBinding
import br.com.rcp.home.viewmodels.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventListFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {
    private val viewmodel by viewModel<HomeViewModel>()
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: EventListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setRecyclerViewAdapter()
        setRecyclerView()
        setObservers()
        viewmodel.getEventList(requireActivity())
        binding.swipe.setOnRefreshListener(this)
    }

    override fun onRefresh() {
        adapter.clear()
        viewmodel.getEventList(requireActivity())
        setObservers()
    }

    private fun setObservers() {
        viewmodel.loading.observe(requireActivity()) { loading ->
            if (loading) {
                binding.progress.visibility = View.VISIBLE
            } else {
                binding.progress.visibility = View.GONE
                binding.swipe.isRefreshing = false
            }
        }

        viewmodel.getEventList(requireContext())

        viewmodel.getEventList(requireContext()).observe(requireActivity()) {
            it?.let { resource ->
                when (resource) {
                    is ResponseHandler.Success -> {
                        retrieve(resource.data)
                        if (resource.data.isEmpty()) {
                            binding.empty.visibility = View.VISIBLE
                        } else {
                            binding.empty.visibility = View.GONE
                        }
                    }

                    is ResponseHandler.Failure -> {
                        Toast.makeText(requireContext(), resource.exception, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    private fun setRecyclerViewAdapter() {
        adapter = EventListAdapter(requireContext(), arrayListOf()) {
            requireView().findNavController().navigate(EventListFragmentDirections.toDetail(it.id))
        }
        binding.events.adapter = adapter
    }

    private fun setRecyclerView() {
        binding.events.layoutManager = LinearLayoutManager(requireContext())
        binding.events.setHasFixedSize(true)
    }

    private fun retrieve(events: List<Event>) {
        adapter.apply {
            add(events)
            notifyDataSetChanged()
        }
    }
}
