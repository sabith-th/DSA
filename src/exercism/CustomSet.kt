package exercism

class CustomSet(vararg items: Int) {

    val set = items.toMutableSet()


    fun isEmpty(): Boolean = set.isEmpty()

    fun isSubset(other: CustomSet): Boolean {
        for (item in set) {
            if (item !in other.set) {
                return false
            }
        }
        return true
    }

    fun isDisjoint(other: CustomSet): Boolean {
        for (item in set) {
            if (item in other.set) {
                return false
            }
        }
        return true
    }

    fun contains(other: Int): Boolean = set.contains(other)

    fun intersection(other: CustomSet): CustomSet {
        val intersection = CustomSet()
        for (item in set) {
            if (item in other.set) {
                intersection.set.add(item)
            }
        }
        return intersection
    }

    fun add(other: Int) = set.add(other)

    override fun equals(other: Any?): Boolean {
//        if (this == other) return true
        if (javaClass != other?.javaClass) return false
        return (other.hashCode() == this.hashCode())
    }

    operator fun plus(other: CustomSet): CustomSet {
        val addSet = CustomSet()
        for (item in set) {
            addSet.add(item)
        }
        for (item in other.set) {
            addSet.add(item)
        }
        return addSet
    }

    operator fun minus(other: CustomSet): CustomSet {
        val minusSet = CustomSet()
        for (item in set) {
            minusSet.add(item)
        }
        for (item in other.set) {
            minusSet.set.remove(item)
        }
        return minusSet
    }

    override fun hashCode(): Int {
        return set.hashCode()
    }

}

fun main() {
    val customSet = CustomSet(1, 2)
    val customSet2 = CustomSet(2, 1)
    println(customSet == customSet2)
}