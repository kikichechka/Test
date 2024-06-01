package com.example.myapplication.data.model

import com.example.myapplication.entity.BankInfo

class BankDTO (
    override val name: String?,
    override val url: String?,
    override val phone: String?,
    override val city: String?
) : BankInfo
