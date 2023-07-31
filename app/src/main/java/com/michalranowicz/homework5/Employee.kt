package com.michalranowicz.homework5

// Prototyp (Prototype Pattern)
interface Employee : Cloneable {
    val name: String
    val position: String
    val salary: Double
    var vacationDays: Int
    val employeeInfo: EmployeeInfo
    fun getInfo(): String
    fun processRequest(request: String, daysOff: Int = 0)
    public override fun clone(): Employee
}