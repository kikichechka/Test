package com.example.myapplication.presenter.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.data.BankDTO
import com.example.myapplication.data.CardDTO
import com.example.myapplication.data.CountryCardDTO
import com.example.myapplication.data.NumberCardDTO
import com.example.myapplication.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cardDTO = CardDTO(
            number = NumberCardDTO(16, true),
            scheme = "visa",
            type = "debit",
            brand = "Visa/Dankort",
            prepaid = false,
            country = CountryCardDTO(
                name = "Denmark",
                latitude = 56868686L,
                longitude = 108686988986L
            ),
            bank = BankDTO(
                name = "Jyske Bank",
                url = "www.jyskebank.dk",
                phone = "+4589893300",
                city = "Hjørring"
            )
        )

        binding.buttonSearch.setOnClickListener {
            binding.detailsInformation.setSchemeType(cardDTO.scheme)
            binding.detailsInformation.setNumber(cardDTO.number)
            binding.detailsInformation.setBrand(cardDTO.brand)
            binding.detailsInformation.setCardType(cardDTO.type)
            binding.detailsInformation.setPrepaid(cardDTO.prepaid)
            binding.detailsInformation.setCountry(cardDTO.country)
            binding.detailsInformation.setBankInformation(cardDTO.bank)
        }
    }
}
