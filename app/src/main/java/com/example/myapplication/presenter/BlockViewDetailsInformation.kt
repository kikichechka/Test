package com.example.myapplication.presenter

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.myapplication.R
import com.example.myapplication.data.BankDTO
import com.example.myapplication.data.CountryCardDTO
import com.example.myapplication.data.NumberCardDTO
import com.example.myapplication.databinding.BlockViewDetailsInformationBinding

class BlockViewDetailsInformation(context: Context, attributeSet: AttributeSet? = null) :
    ConstraintLayout(context, attributeSet) {
    private var binding: BlockViewDetailsInformationBinding

    init {
        val inflatedView = inflate(context, R.layout.block_view_details_information, this)
        binding = BlockViewDetailsInformationBinding.bind(inflatedView)
    }

    @SuppressLint("SetTextI18n")
    fun setSchemeType(scheme: String) {
        binding.schemeType.text = scheme
    }

    @SuppressLint("SetTextI18n")
    fun setNumber(numberCardDTO: NumberCardDTO) {
        with(binding) {
            cardLength.text = numberCardDTO.length.toString()
            cardLuhn.text = when (numberCardDTO.luhn) {
                true -> resources.getString(R.string.yes)
                false -> resources.getString(R.string.no)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun setBrand(brand: String) {
        binding.cardBrand.text = brand

    }

    @SuppressLint("SetTextI18n")
    fun setCardType(type: String) {
        binding.cardType.text = type

    }

    @SuppressLint("SetTextI18n")
    fun setPrepaid(prepaid: Boolean) {
        when (prepaid) {
            true -> {
                binding.cardPrepaid.text = resources.getString(R.string.yes)
            }

            false -> {
                binding.cardPrepaid.text = resources.getString(R.string.no)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun setCountry(country: CountryCardDTO) {
        with(binding) {
            cardCountry.text = country.name
            cardCountryLatitude.text = country.latitude.toString()
            cardCountryLongitude.text = country.longitude.toString()
        }
    }

    @SuppressLint("SetTextI18n")
    fun setBankInformation(bank: BankDTO) {
        with(binding) {
            bankName.text = bank.name
            bankCity.text = bank.city
            bankUrl.text = bank.url
            bankPhone.text = bank.phone
        }
    }
}
