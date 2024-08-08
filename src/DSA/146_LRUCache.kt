package DSA

class LRUCache(val capacity: Int) {
    class Item(val key: Int, var value: Int) {
        var prev: Item? = null
        var next: Item? = null
    }

    var front: Item? = null
    var back: Item? = null
    val itemMap = mutableMapOf<Int, Item>()

    fun get(key: Int): Int {
        if (key in itemMap) {
            val item = itemMap[key]!!
            put(key, item.value)
            return item.value
        } else {
            return -1
        }
    }

    fun put(key: Int, value: Int) {
        if (key in itemMap) {
            val item = itemMap[key]!!
            item.value = value
            if (item == front) {
                return
            } else if (item == back) {
                back?.prev?.next = null
                back = back?.prev
            }
            item.next = null
            item.prev = null
            insert(item)
        } else {
            val item = Item(key, value)
            insert(item)
        }
    }

    private fun insert(item: Item) {
        itemMap[item.key] = item
        if (front == null) {
            front = item
            back = item
        } else {
            front?.prev = item
            item.next = front
            front = item
            if (itemMap.size > capacity) {
                itemMap.remove(back!!.key)
                back?.prev?.next = null
                back = back?.prev
            }
        }
    }
}

fun main() {
    val cache = LRUCache(2)
    cache.put(1, 1)
    cache.put(2, 2)
    println(cache.get(1))
    cache.put(3, 3)
    println(cache.get(2))
    println(cache.get(1))
}