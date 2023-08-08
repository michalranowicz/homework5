package com.michalranowicz.homework5

data class BaseEmployee(
    override val name: String,
    override val surname: String,
    override val position: String,
    override var salary: Double,
    override var vacationDays: Int = 20,
    override var company: Company,
) : Employee {
    private var usedVacationDays: Int = 0
    override fun getInfo(): String {
        return "Pracownik: $name, Stanowisko: $position, Wynagrodzenie: $salary, firma: $company"
    }

    override fun printVacationInfo() {
        println("Imię: $name, Nazwisko: $surname")
        println("Firma: ${company.name}")
        println("Dni wzięte na urlop: ${usedVacationDays}/$vacationDays")
        println()
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
                    usedVacationDays += availableDaysOff
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