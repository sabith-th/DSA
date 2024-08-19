package DSA

class LRUCache(val capacity: Int) {
    class Item(val key: Int, var value: Int) {
        var prev: Item? = null
        var next: Item? = null
    }

    val front: Item = Item(-1, -1)
    val back: Item = Item(-1, -1)
    val itemMap = mutableMapOf<Int, Item>()

    init {
        front.next = back
        back.prev = front
    }

    fun get(key: Int): Int {
        if (key in itemMap) {
            val item = itemMap[key]!!
            delete(item)
            put(key, item.value)
            return item.value
        } else {
            return -1
        }
    }

    fun put(key: Int, value: Int) {
        if (key in itemMap) {
            val item = itemMap[key]!!
            delete(item)
            val newItem = Item(key, value)
            insert(newItem)
        } else {
            val item = Item(key, value)
            insert(item)
        }
    }

    private fun delete(item: Item) {
        item.prev?.next = item.next
        item.next?.prev = item.prev
        itemMap.remove(item.key)
    }

    private fun insert(item: Item) {
        if (itemMap.size == capacity) {
            back.prev?.let {
                delete(it)
            }
        }
        item.next = front.next
        front.next?.prev = item
        item.prev = front
        front.next = item
        itemMap[item.key] = item
    }
}

class LRUCacheWithLinkedHashMap(val capacity: Int) {
    val dict: LinkedHashMap<Int, Int> = object : LinkedHashMap<Int, Int>(capacity, 0.75f, true) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<Int, Int>?): Boolean {
            return size > capacity
        }
    }

    fun get(key: Int): Int = dict.getOrDefault(key, -1)

    fun put(key: Int, value: Int) = dict.put(key, value)
}

fun main() {
    val cache = LRUCache(2)
    cache.put(1, 1)
    cache.put(2, 2)
    println(cache.get(1))
    cache.put(3, 3)
    println(cache.get(2))
    println(cache.get(1))
    println(cache.get(3))
    cache.put(4, 4)
    println(cache.get(1))

    val cache2 = LRUCacheWithLinkedHashMap(2)
    cache2.put(10, 10)
    cache2.put(20, 20)
    println(cache2.get(10))
    cache2.put(30, 30)
    println(cache2.get(20))
    println(cache2.get(10))
    println(cache2.get(30))
    cache2.put(40, 40)
    println(cache2.get(10))
}