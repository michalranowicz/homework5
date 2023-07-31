package com.michalranowicz.homework5

// Wzorzec Pyłek (Flyweight Pattern)
data class EmployeeInfo(private val company: String, private val address: String) {
    fun getInfo(): String {
        return "Firma: $company, Adres: $address"
    }
}