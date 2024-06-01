package com.example.myapplication.data.model

import com.example.myapplication.entity.CountryCard

class CountryCardDTO (
    override val name: String?,
    override val latitude: Long?,
    override val longitude: Long?
) : CountryCard
