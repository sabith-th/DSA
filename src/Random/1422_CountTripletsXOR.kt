package Random

class CountTripletsXOR {
    fun countTriplets(arr: IntArray): Int {
        var ans = 0
        val xors = mutableListOf(0)
        var prefix = 0

        for (i in arr.indices) {
            prefix = prefix xor arr[i]
            xors.add(prefix)
        }

        for (j in 1..arr.lastIndex) {
            for (i in 0..<j) {
                val xors_i = xors[j] xor xors[i]
                for (k in j..arr.lastIndex) {
                    val xors_k = xors[k+1] xor xors[j]
                    if (xors_i == xors_k) {
                        ans++
                    }
                }
            }
        }

        return ans
    }
}