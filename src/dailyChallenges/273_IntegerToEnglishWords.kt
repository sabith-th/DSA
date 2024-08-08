package dailyChallenges

class IntegerToEnglishWords {
    fun numberToWords(num: Int): String {
        return if (num == 0) "Zero" else helper(num)
    }

    private val belowTwenty = arrayOf(
        "",        "One",     "Two",       "Three",    "Four",
        "Five",    "Six",     "Seven",     "Eight",    "Nine",
        "Ten",     "Eleven",  "Twelve",    "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    )
    private val tens = arrayOf(
        "",      "",      "Twenty",  "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    )

    private fun helper(n: Int): String {
        var num = n
        val s = StringBuilder()

        if (num < 20)
            s.append(belowTwenty[num]);
        else if (num < 100)
            s.append(tens[num / 10]).append(" ").append(belowTwenty[num % 10]);
        else if (num < 1000)
            s.append(helper(num / 100)).append(" Hundred ").append(helper(num % 100));
        else if (num < 1000000)
            s.append(helper(num / 1000)).append(" Thousand ").append(helper(num % 1000));
        else if (num < 1000000000)
            s.append(helper(num / 1000000)).append(" Million ").append(helper(num % 1000000));
        else
            s.append(helper(num / 1000000000)).append(" Billion ").append(helper(num % 1000000000));

        return s.toString().trim()
    }
}