package com.example.myapplication.presenter.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.databinding.FragmentHistoryBinding
import com.example.myapplication.presenter.adapter.ListCardsAdapter
import com.example.myapplication.presenter.viewmodel.HistoryViewModel
import com.example.myapplication.presenter.viewmodel.MainViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HistoryFragment : Fragment() {
    private var _binding: FragmentHistoryBinding? = null
    private val binding: FragmentHistoryBinding
        get() = _binding!!

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory
    private val historyViewModel: HistoryViewModel by viewModels { mainViewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            historyViewModel.listData.observe(viewLifecycleOwner) {
                val adapter = ListCardsAdapter(it)
                binding.recyclerView.adapter = adapter
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
