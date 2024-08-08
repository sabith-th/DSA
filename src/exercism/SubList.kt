package exercism

enum class Relationship {

    EQUAL, SUBLIST, SUPERLIST, UNEQUAL

}

fun <E> List<E>.relationshipTo(list2: List<E>): Relationship {
    return when {
        this == list2 -> Relationship.EQUAL
        this.isEmpty() -> Relationship.SUBLIST
        list2.windowed(this.size).any { it == this } -> Relationship.SUBLIST
        list2.isEmpty() -> Relationship.SUPERLIST
        this.windowed(list2.size).any { it == list2 } -> Relationship.SUPERLIST
        else -> Relationship.UNEQUAL
    }
}