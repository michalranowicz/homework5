package com.michalranowicz.homework5

data class Company(val name: String, val address: String, val phone:String){
     object CompanyRegistry {
        val companies: MutableMap<String, Company> = mutableMapOf()

        fun addCompany(name: String, address: String, phone: String): Company {
            val key = name
            return companies.getOrPut(key) { Company(name, address,phone) }
        }
        fun getAllCompanies(): List<Company> {
            return companies.values.toList()
        }
        fun getCompanyByName(companyName: String): Company? {
            return companies[companyName]
        }
    }

}