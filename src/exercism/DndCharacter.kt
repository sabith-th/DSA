package exercism

import org.testng.Assert.assertEquals
import org.testng.Assert.assertTrue
import org.testng.annotations.Test
import kotlin.math.floor

class DndCharacter {

    val strength: Int = ability()
    val dexterity: Int = ability()
    val constitution: Int = ability()
    val intelligence: Int = ability()
    val wisdom: Int = ability()
    val charisma: Int = ability()
    val hitpoints: Int = 10 + modifier(constitution)

    companion object {

        private val dice = 1..6
        private val rolls = 1..4

        fun ability(): Int =
            rolls
                .map { dice.random() }
                .sorted()
                .drop(1)
                .sum()


        fun modifier(score: Int): Int = floor((score-10.0) / 2).toInt()
    }
}


class DndCharacterTest {
    @Test
    fun `ability modifier for score 3 is n4`() = assertEquals(-4, DndCharacter.modifier(3))
    @Test
    fun `ability modifier for score 4 is n3`() = assertEquals(-3, DndCharacter.modifier(4))
    @Test
    fun `ability modifier for score 5 is n3`() = assertEquals(-3, DndCharacter.modifier(5))
    @Test
    fun `ability modifier for score 6 is n2`() = assertEquals(-2, DndCharacter.modifier(6))
    @Test
    fun `ability modifier for score 7 is n2`() = assertEquals(-2, DndCharacter.modifier(7))
    @Test
    fun `ability modifier for score 8 is n1`() = assertEquals(-1, DndCharacter.modifier(8))
    @Test
    fun `ability modifier for score 9 is n1`() = assertEquals(-1, DndCharacter.modifier(9))
    @Test
    fun `ability modifier for score 10 is 0`() = assertEquals(0, DndCharacter.modifier(10))
    @Test
    fun `ability modifier for score 11 is 0`() = assertEquals(0, DndCharacter.modifier(11))
    @Test
    fun `ability modifier for score 12 is 1`() = assertEquals(1, DndCharacter.modifier(12))
    @Test
    fun `ability modifier for score 13 is 1`() = assertEquals(1, DndCharacter.modifier(13))
    @Test
    fun `ability modifier for score 14 is 2`() = assertEquals(2, DndCharacter.modifier(14))
    @Test
    fun `ability modifier for score 15 is 2`() = assertEquals(2, DndCharacter.modifier(15))
    @Test
    fun `ability modifier for score 16 is 3`() = assertEquals(3, DndCharacter.modifier(16))
    @Test
    fun `ability modifier for score 17 is 3`() = assertEquals(3, DndCharacter.modifier(17))
    @Test
    fun `ability modifier for score 18 is 4`() = assertEquals(4, DndCharacter.modifier(18))
    @Test
    fun `random ability is within range`() {
        val score = DndCharacter.ability()
        assertTrue(score in (3..18))
    }
    @Test
    fun `random character is valid`() {
        with (DndCharacter()) {
            assertTrue(strength in (3..18))
            assertTrue(dexterity in (3..18))
            assertTrue(constitution in (3..18))
            assertTrue(intelligence in (3..18))
            assertTrue(wisdom in (3..18))
            assertTrue(charisma in (3..18))
            assertEquals(10 + DndCharacter.modifier(constitution), hitpoints)
        }
    }
    @Test
    fun `each ability is only calculated once`() {
        val char = DndCharacter()
        assertTrue(char.strength == char.strength)
    }
}