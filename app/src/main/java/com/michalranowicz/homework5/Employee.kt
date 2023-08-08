package com.michalranowicz.homework5

// Prototyp (Prototype Pattern)
interface Employee : Cloneable {
    val name: String
    val surname: String
    val position: String
    val salary: Double
    var vacationDays: Int
    var company: Company

    fun getInfo(): String

    fun printVacationInfo()
    fun processRequest(request: String, daysOff: Int = 0)
    public override fun clone(): Employee
}