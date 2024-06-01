package com.example.myapplication.data.model

import com.example.myapplication.entity.NumberCard

class NumberCardDTO (
    override val length: Int?,
    override val luhn: Boolean?
) : NumberCard
