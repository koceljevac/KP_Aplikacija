package com.example.kupujemprodajemaplikacija.ui.ad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kupujemprodajemaplikacija.databinding.FragmentHomeBinding
import com.example.kupujemprodajemaplikacija.models.Ad
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val adViewModel: AdViewModel by viewModels {
        AdViewModelFactory(AdRepository(requireContext()))
    }
    private val adapter: AdPagingAdapter by lazy {
        AdPagingAdapter(object : AdClickListener {
            override fun onAdClick(ad: Ad) {
                if (ad.ad_id != null) {
                    val showDetailsFragment =
                        HomeFragmentDirections.actionHomeFragmentToDetailsFragment(ad)
                    findNavController().navigate(showDetailsFragment)
                } else {
                    val showNoDetailsFragment =
                        HomeFragmentDirections.actionHomeFragmentToNoDetailsFragment()
                    findNavController().navigate(showNoDetailsFragment)
                }
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            adViewModel.getAds().collectLatest { pagingData ->
                adapter.submitData(pagingData)
            }
        }
    }
}
