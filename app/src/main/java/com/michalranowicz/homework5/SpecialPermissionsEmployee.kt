package com.michalranowicz.homework5

//Dekorator (Decorator Pattern)
class SpecialPermissionsEmployee(private val employee: Employee) : Employee {
    override val name: String
        get() = employee.name
    override val position: String
        get() = employee.position
    override val salary: Double
        get() = employee.salary
    override var vacationDays: Int
        get() = employee.vacationDays
        set(value) {
            employee.vacationDays = value
        }
    override val employeeInfo: EmployeeInfo
        get() = employee.employeeInfo

    override fun getInfo(): String {
        return "${employee.getInfo()}, Specjalne uprawnienia: TAK"
    }

    override fun processRequest(request: String, daysOff: Int) {
        employee.processRequest(request, daysOff)
    }

    override fun clone(): Employee {
        return employee.clone()
    }

    fun giveRaiseToEmployee(employee: BaseEmployee, raiseAmount: Double) {
        val newSalary = employee.salary + (employee.salary * raiseAmount / 100)
        employee.salary = newSalary
        println("Kierownik ${this.name} dał podwyżkę pracownikowi ${employee.name}. Nowe wynagrodzenie: $newSalary")
    }
}