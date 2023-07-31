package com.michalranowicz.homework5

data class BaseEmployee(
    override val name: String,
    override val position: String,
    override var salary: Double,
    override var vacationDays: Int = 20,
    override val employeeInfo: EmployeeInfo
) : Employee {
    override fun getInfo(): String {
        return "Pracownik: $name, Stanowisko: $position, Wynagrodzenie: $salary"
    }

    override fun processRequest(request: String, daysOff: Int) {

        if (request == "Żądanie urlopu" || (request == "Podwyżka wynagrodzenia" && position == "Kierownik")) {
            if (daysOff > 0) {
                val availableDaysOff = if (daysOff <= vacationDays) {
                    daysOff
                } else {
                    vacationDays
                }
                if (availableDaysOff > 0) {
                    vacationDays -= availableDaysOff
                    println("Pracownik $name może wziąć $availableDaysOff dni urlopu. Pozostałe dni urlopowe: $vacationDays")
                } else {
                    println("Pracownik $name nie posiada już dni urlopowych.")
                }
            } else {
                println("Pracownik $name nie może obsłużyć żądania.")
            }
        }
    }

    override fun clone(): Employee {
        return copy()
    }
}