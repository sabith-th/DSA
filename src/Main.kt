import java.text.DecimalFormat
import java.util.PriorityQueue
import kotlin.math.nextUp
import kotlin.math.pow

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
//    val name = "Kotlin"
//    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//    // to see how IntelliJ IDEA suggests fixing it.
//    println("Hello, $name!")
//
//    for (i in 1..5) {
//        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//        println("i = $i")
//    }
//
//    var num = 149
//    val digits: MutableList<Int> = mutableListOf()
//    while (num != 0) {
//        digits.add(num % 10)
//        num /= 10
//    }
//    digits.reverse()
//    println(digits)
    var s = ""
    s = s + "B"
    s = s + 'A'
    "ABC".contains("AB")
    "ABC".substring(1, 4)
    val keyToAnagrams = mutableMapOf<String, MutableList<String>>()
    keyToAnagrams.getOrDefault("A", mutableListOf<String>()).add("str")
    keyToAnagrams.getOrPut("B"){ mutableListOf() }.let { it.add("Bee") }
    Integer.toBinaryString(5)
    (5 shr 5)
    (5 xor 8).countOneBits()
    Integer.bitCount(4)
    Integer.MIN_VALUE
    mutableListOf("A")
    "ABC".toCharArray().toString()
    val set = intArrayOf(1, 2, 3).toSet()
    val i = 5
    val seen = mutableSetOf<Char>('a', 'b', 'c')
    intArrayOf(1, 2, 3).sum()
    var chars  = CharArray(5)
    mutableListOf<IntArray>().toTypedArray()
    intArrayOf(1,2,3)
    mutableListOf<Int>(1, 5, 3,4, 2).sortBy { it }
    val sb = StringBuilder()
    IntArray(5)
    Integer.numberOfLeadingZeros(5)
    val k: Long = 5
    val j: Int = k.toInt()
    Int.MAX_VALUE
    5.0.nextUp()

    "A Good day to Die-Hard".split(Regex("[ ]|-")).filter { it.isNotEmpty() }.map { it.first().uppercase() }.joinToString("")
    "A GOod Do".filter { it.isLetter() || it == '-' || it == ' ' }.split(Regex("[ ]|-")).map { it.first().uppercase() }.joinToString("")
    val st = "A Good Day".filter { it.isLetter() }.map { it.lowercaseChar() }
    mutableListOf<StringBuilder>()

    val adList = mutableMapOf<Int, List<Pair<Int, Int>>>()
    arrayOf("A" to 1, "B" to 2, "D" to 4, "C" to 3).sortedBy { -it.second }.map { it.first }.toTypedArray()
    println("${adList[0]}")
    val decFormat = DecimalFormat("#,##0.0")
    val abd = "ABC" + "DEF"
    abd.startsWith("A")
    abd.contains("CDE")
    sb.append(5%2).toString().reversed()
    val ans = Math.pow(2.0, 10.0) % 10
    PriorityQueue<Pair<Int, Int>>()
    ArrayDeque<Int>()
    Long.MAX_VALUE
    intArrayOf(1,5,6,2)
    mutableSetOf<Int>()
    listOf<Pair<String, Int>>().forEach {
        
    }
    mutableListOf<IntArray>().toTypedArray()
}

