package com.example.myapplication.presenter

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.myapplication.R
import com.example.myapplication.data.model.BankDTO
import com.example.myapplication.data.model.CountryCardDTO
import com.example.myapplication.data.model.NumberCardDTO
import com.example.myapplication.databinding.BlockViewDetailsInformationBinding

class BlockViewDetailsInformation(context: Context, attributeSet: AttributeSet? = null) :
    ConstraintLayout(context, attributeSet) {
    private var binding: BlockViewDetailsInformationBinding

    init {
        val inflatedView = inflate(context, R.layout.block_view_details_information, this)
        binding = BlockViewDetailsInformationBinding.bind(inflatedView)
    }

    @SuppressLint("SetTextI18n")
    fun setSchemeType(scheme: String?) {
        scheme?.let {
            binding.schemeType.text = it
        }
    }

    @SuppressLint("SetTextI18n")
    fun setNumber(numberCardDTO: NumberCardDTO?) {
        with(binding) {
            numberCardDTO?.let {
                cardLength.text = it.length?.toString()
                cardLuhn.text = when (it.luhn) {
                    true -> resources.getString(R.string.yes)
                    false -> resources.getString(R.string.no)
                    null -> ""
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun setBrand(brand: String?) {
        brand?.let {
            binding.cardBrand.text = it
        }
    }

    @SuppressLint("SetTextI18n")
    fun setCardType(type: String?) {
        type?.let {
            binding.cardType.text = it
        }
    }

    @SuppressLint("SetTextI18n")
    fun setPrepaid(prepaid: Boolean?) {
        prepaid?.let {
            binding.cardPrepaid.text = if (it) resources.getString(R.string.yes) else resources.getString(R.string.no)
//            when (it) {
//                true -> {
//                    binding.cardPrepaid.text = resources.getString(R.string.yes)
//                }
//
//                false -> {
//                    binding.cardPrepaid.text = resources.getString(R.string.no)
//                }
//            }
        }

    }

    @SuppressLint("SetTextI18n")
    fun setCountry(country: CountryCardDTO?) {
        with(binding) {
            country?.let {
                cardCountry.text = it.name
                cardCountryLatitude.text = it.latitude.toString()
                cardCountryLongitude.text = it.longitude.toString()
            }
//            cardCountry.text = country?.name
//            cardCountryLatitude.text = country?.latitude.toString()
//            cardCountryLongitude.text = country?.longitude.toString()
        }
    }

    @SuppressLint("SetTextI18n")
    fun setBankInformation(bank: BankDTO?) {
        with(binding) {
            bank?.let {
                bankName.text = it.name
                bankCity.text = it.city
                bankUrl.text = it.url
                bankPhone.text = it.phone
            }
//            bankName.text = bank?.name
//            bankCity.text = bank?.city
//            bankUrl.text = bank?.url
//            bankPhone.text = bank?.phone
        }
    }
}
