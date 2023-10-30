package com.example.kupujemprodajemaplikacija.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.kupujemprodajemaplikacija.R
import com.example.kupujemprodajemaplikacija.databinding.FragmentDetailsBinding
import com.example.kupujemprodajemaplikacija.ui.ad.AdRepository
import com.example.kupujemprodajemaplikacija.utils.Utils
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DetailsAdFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val args: DetailsAdFragmentArgs by navArgs()

    private val viewModel: DetailsAdViewModel by viewModels {
        DetailsAdViewModelFactory(AdRepository(requireContext()))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        binding.ad = args.ad
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            observeViewModel()
        }
        buttonObserver()
    }

    private suspend fun observeViewModel() {
        binding.viewModelDetails = viewModel
        binding.lifecycleOwner = this
        val adId = args.ad.ad_id
        viewModel.name.set(args.ad.name)
        viewModel.price.set(Utils.adToCurrency(args.ad))
        viewModel.location.set(args.ad.location_name)
        adId?.let {
            viewModel.loadAd(adId)
            viewModel.loadAdDetails(adId)
        }
        viewModel.adDetails.collectLatest { adDetails ->
            adDetails?.description?.let { description ->
                val plainText =
                    HtmlCompat.fromHtml(description, HtmlCompat.FROM_HTML_MODE_LEGACY).toString()
                viewModel.setPlainTextDescription(plainText)
            }
        }
    }

    private fun buttonObserver() {
        binding.ivBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
}
