package DSA

import java.util.TreeMap

class TimeMap {
    val store = mutableMapOf<String, TreeMap<Int, String>>()

    fun set(key: String, value: String, timestamp: Int) {
        val item = store.getOrPut(key) { TreeMap<Int, String>() }
        item.put(timestamp, value)
    }

    fun get(key: String, timestamp: Int): String {
        var ans = ""
        store[key]?.let { item ->
            item.floorKey(timestamp)?.let { key ->
                ans = item.get(key) ?: ""
            }
        }
        return ans
    }
}