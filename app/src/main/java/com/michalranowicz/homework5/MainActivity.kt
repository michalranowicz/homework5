package com.michalranowicz.homework5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val employeeInfo = EmployeeInfo("Firma ABC", "ul. Główna 123")
//
//        val employees: MutableList<Employee> = mutableListOf()
//
//        while (true) {
//            println("Co chcesz zrobić?")
//            println("1. Dodaj nowego pracownika")
//            println("2. Wystaw żądanie urlopu")
//            println("3. Dawaj podwyżkę")
//            println("4. Wyświetl wszystkich pracowników")
//            println("5. Wyjdź z programu")
//
//            val input = readLine()?.toIntOrNull() ?: 0
//
//            when (input) {
//                1 -> {
//                    println("Podaj imię pracownika: ")
//                    val name = readLine() ?: ""
//
//                    println("Podaj nazwisko pracownika: ")
//                    val surname = readLine() ?: ""
//
//                    println("Podaj liczbę dni urlopu pracownika: ")
//                    val vacationDays = readLine()?.toIntOrNull() ?: 20
//
//                    println("Czy pracownik jest kierownikiem? (Tak/Nie): ")
//                    val isManager = readLine()?.toLowerCase() == "tak"
//                    println(isManager)
//
//                    val position = if (isManager) {
//
//                        "Kierownik"
//                    } else {
//                        "Pracownik"
//                    }
//
//                    if (isManager) {
//                        val specialPermissionsEmployee = SpecialPermissionsEmployee(
//                            BaseEmployee(
//                                name,
//                                position,
//                                4000.0,
//                                vacationDays,
//                                employeeInfo
//                            )
//                        )
//                        employees.add(specialPermissionsEmployee)
//                    } else {
//                        val employee = BaseEmployee(name, position, 4000.0, vacationDays, employeeInfo)
//                        employees.add(employee)
//                    }
//                    println("Pracownik dodany!\n")
//                }
//                2 -> {
//                    println("Podaj imię pracownika, który składa żądanie urlopu: ")
//                    val employeeName = readLine() ?: ""
//
//                    val employee = employees.find { it.name == employeeName }
//                    if (employee != null) {
//                        println("Podaj liczbę dni urlopu: ")
//                        val daysOff = readLine()?.toIntOrNull() ?: 0
//                        employee.processRequest("Żądanie urlopu", daysOff)
//                    } else {
//                        println("Pracownik o podanym imieniu nie istnieje.")
//                    }
//                }
//                3 -> {
//                    println("Podaj imię kierownika, który daje podwyżkę: ")
//                    val managerName = readLine() ?: ""
//
//                    var manager =
//                        employees.find { it.name == managerName && it.position == "Kierownik" }
//                    if (manager != null) {
//                        println("Podaj imię pracownika, któremu chcesz dać podwyżkę: ")
//                        val employeeName = readLine() ?: ""
//                        val employee = employees.find { it.name == employeeName }
//
//                        if (employee != null) {
//                            println("Podaj ile % podwyżki chcesz dać pracownikowi")
//                            val raiseAmount = readLine()?.toDoubleOrNull() ?: 0.0
//                            println(raiseAmount)
//                            (manager as SpecialPermissionsEmployee).giveRaiseToEmployee(
//                                employee as BaseEmployee,
//                                raiseAmount
//                            )
//
//                        } else {
//                            println("Pracownik o podanym imieniu nie istnieje.")
//                        }
//                    } else {
//                        println("Kierownik o podanym imieniu nie istnieje.")
//                    }
//                }
//                4 -> {
//                    println("Wszyscy pracownicy:")
//                    employees.forEach { println(it.getInfo()) }
//                    println()
//                }
//                5 -> {
//                    println("Zamykanie programu...")
//                    return
//                }
//                else -> {
//                    println("Niepoprawny wybór, spróbuj ponownie.")
//                }
//            }
//        }
//    }
//}

fun main() {
    val employees: MutableList<Employee> = mutableListOf()
    val employeesOnVacation: MutableList<Employee> = mutableListOf()

    while (true) {
        println("Co chcesz zrobić?")
        println("1. Dodaj nową firmę jako partnera")
        println("2. Dodaj nowego pracownika")
        println("3. Wystaw żądanie urlopu")
        println("4. Dawaj podwyżkę")
        println("5. Wyświetl wszystkich pracowników")
        println("6. Wyświetl wszystkich pracowników którzy brali urlop")
        println("7. Wyświetl wszystkie firmy")
        println("8. Wyjdź z programu")

        val input = readLine()?.toIntOrNull() ?: 0

        when (input) {
            1 -> {
                println("Podaj nazwę firmy")
                val name = readLine() ?: ""

                println("Podaj adres firmy")
                val address = readLine() ?: ""

                println("Podaj telefon kontaktowy")
                val phone = readLine() ?: ""

                val company = Company.CompanyRegistry.addCompany(name, address, phone)
                println("Firma dodana jako partner!\n")
            }
            2 -> {
                println("Podaj nazwę firmy, dla której chcesz dodać pracownika:")
                val companyName = readLine() ?: ""

                val company = Company.CompanyRegistry.getCompanyByName(companyName)

                if (company != null) {
                    println("Podaj imię pracownika: ")
                    val name = readLine() ?: ""

                    println("Podaj nazwisko pracownika: ")
                    val surname = readLine() ?: ""

                    println("Podaj liczbę dni urlopu pracownika: ")
                    val vacationDays = readLine()?.toIntOrNull() ?: 20

                    println("Czy pracownik jest kierownikiem? (Tak/Nie): ")
                    val isManager = readLine()?.lowercase() == "tak"

                    val position = if (isManager) {

                        "Kierownik"
                    } else {
                        "Pracownik"
                    }

                    if (isManager) {
                        val specialPermissionsEmployee = SpecialPermissionsEmployee(
                            BaseEmployee(
                                name,
                                surname,
                                position,
                                4000.0,
                                vacationDays,
                                company
                            )
                        )
                        employees.add(specialPermissionsEmployee)
                        println("Pracownik dodany!\n")
                    } else {
                        val employee =
                            BaseEmployee(name, surname, position, 4000.0, vacationDays, company)
                        employees.add(employee)
                        println("Pracownik dodany!\n")
                    }
                } else {
                    println("Firma o nazwie '$companyName' nie istnieje.")
                    println("Aby dodać pracownika, najpierw dodaj firmę jako partnera.")
                }
            }
            3 -> {
                println("Podaj imię pracownika, który składa żądanie urlopu: ")
                val employeeName = readLine() ?: ""

                val employee = employees.find { it.name == employeeName }
                if (employee != null) {
                    println("Podaj liczbę dni urlopu: ")
                    val daysOff = readLine()?.toIntOrNull() ?: 0
                    employee.processRequest("Żądanie urlopu", daysOff)

                    if (daysOff > 0) {
                        val clonedEmployee = employee.clone()
                        println(clonedEmployee)
                        employeesOnVacation.add(clonedEmployee)
                    }

                } else {
                    println("Pracownik o podanym imieniu nie istnieje.")
                }
            }
            4 -> {
                println("Podaj imię kierownika, który daje podwyżkę: ")
                val managerName = readLine() ?: ""

                var manager =
                    employees.find { it.name == managerName && it.position == "Kierownik" }
                if (manager != null) {
                    println("Podaj imię pracownika, któremu chcesz dać podwyżkę: ")
                    val employeeName = readLine() ?: ""
                    val employee = employees.find { it.name == employeeName }

                    if (employee != null) {
                        println("Podaj ile % podwyżki chcesz dać pracownikowi ")
                        val raiseAmount = readLine()?.toDoubleOrNull() ?: 0.0
                        println(raiseAmount)
                        try {
                            (manager as SpecialPermissionsEmployee).giveRaiseToEmployee(
                                employee as BaseEmployee,
                                raiseAmount
                            )
                        } catch (e: Exception) {
                            println("Nie udało sie udzielić podwyżki. Posiadając uprawnienia kierownika można tylko udzielać podwyżki pracownikom niższego szczebla")
                        }
                    } else {
                        println("Pracownik o podanym imieniu nie istnieje.")
                    }
                } else {
                    println("Kierownik o podanym imieniu nie istnieje.")
                }
            }
            5 -> {
                println("Wszyscy pracownicy:")
                employees.forEach { println(it.getInfo()) }
                println("-------------")
            }
            6 -> {
                println("Pracownicy na urlopie:")
                for (employee in employeesOnVacation) {
                    employee.printVacationInfo()
                }
                println("------------")
            }
            7 -> {
                val allCompanies = Company.CompanyRegistry.getAllCompanies()
                if (allCompanies.isEmpty()) {
                    println("Brak firm w ewidencji.")
                } else {
                    println("Wszystkie firmy w ewidencji:")
                    for (company in allCompanies) {
                        println("Nazwa: ${company.name}, Adres: ${company.address}")
                    }
                }
            }
            8 -> {
                println("Zamykanie programu...")
                return
            }
            else -> {
                println("Niepoprawny wybór, spróbuj ponownie.")
            }
        }
    }
}


