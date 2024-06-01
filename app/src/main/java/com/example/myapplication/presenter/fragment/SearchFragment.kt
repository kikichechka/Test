package com.example.myapplication.presenter.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.data.model.CardDTO
import com.example.myapplication.databinding.FragmentSearchBinding
import com.example.myapplication.entity.StateType
import com.example.myapplication.presenter.viewmodel.MainViewModelFactory
import com.example.myapplication.presenter.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private val regex = Regex("""^([0-9]{6,8})$""")
    private var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding
        get() = _binding!!

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory
    private val searchViewModel: SearchViewModel by viewModels { mainViewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        findOutData()
        clickButtonSearch()
        trackStatusChanges()
        doOnTextChanged()
    }

    private fun doOnTextChanged() {
        binding.editText.doOnTextChanged { text, _, _, _ ->
            if (!text!!.matches(regex)) {
                binding.textField.isErrorEnabled = true
                binding.textField.error = getString(R.string.input_error)
                binding.buttonSearch.isEnabled = false
            } else {
                binding.textField.isErrorEnabled = false
                binding.buttonSearch.isEnabled = true
            }
        }
    }

    private fun clickButtonSearch() {
        binding.buttonSearch.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                val editText = binding.editText.text.toString().toLong()
                searchViewModel.getData(editText)
            }
        }
    }

    private fun trackStatusChanges() {
        viewLifecycleOwner.lifecycleScope.launch {
            searchViewModel.stateShow.collect{ state ->
                when (state) {
                    StateType.Display -> {
                        binding.progress.visibility = View.GONE
                        binding.buttonSearch.isEnabled = true
                        binding.detailsInformation.isVisible = true
                    }

                    is StateType.Hide -> {
                        binding.progress.visibility = View.GONE
                        binding.buttonSearch.isEnabled = true
                        binding.detailsInformation.isVisible = false
                        state.error?.let {
                            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                        }
                    }

                    StateType.Loading -> {
                        binding.progress.visibility = View.VISIBLE
                        binding.buttonSearch.isEnabled = false
                    }
                }
            }
        }
    }

    private fun findOutData() {
        viewLifecycleOwner.lifecycleScope.launch {
            searchViewModel.dataStateFlow.collect {
                if (it != null) {
                    showResult(it)
                }
            }
        }
    }

    private fun showResult(cardDTO: CardDTO) {
        with(binding.detailsInformation) {
            setSchemeType(cardDTO.scheme)
            setNumber(cardDTO.number)
            setBrand(cardDTO.brand)
            setCardType(cardDTO.type)
            setPrepaid(cardDTO.prepaid)
            setCountry(cardDTO.country)
            setBankInformation(cardDTO.bank)
        }
    }
}
