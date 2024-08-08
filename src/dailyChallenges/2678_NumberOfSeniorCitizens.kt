package dailyChallenges

class NumberOfSeniorCitizens {
    fun countSeniors(details: Array<String>): Int {
        return details.count { it[11] > '6' || (it[11] == '6' && it[12] > '0') }
    }
}