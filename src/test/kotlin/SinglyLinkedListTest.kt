import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SinglyLinkedListTest {

    private lateinit var list: SinglyLinkedList<Int>

    private companion object {
        const val LIST_KEY = "SinglyLinkedList"
    }

    private fun assertEmpty() {
        assertTrue(list.isEmpty)
        assertEquals("$LIST_KEY(null)", list.toString())
    }

    @BeforeEach
    fun init() {
        list = SinglyLinkedList()
    }

    @Test
    fun `after created must be empty`() {
        assertEmpty()
    }

    @Test
    fun `after last element added must not be empty`() {
        list.addLast(1)
        assertFalse(list.isEmpty)
        assertEquals("$LIST_KEY(1 -> null)", list.toString())
    }

    @Test
    fun `after first element added must not be empty`() {
        list.addFirst(1)
        assertFalse(list.isEmpty)
        assertEquals("$LIST_KEY(1 -> null)", list.toString())
    }

    @Test
    fun `after element added then removed must be empty`() {
        list.addLast(1)
        val removedElement = list.removeLast()
        assertEquals(1, removedElement)
        assertEmpty()
    }

    @Test
    fun `after removing element from empty list must throw exception`() {
        assertThrows<IndexOutOfBoundsException> { list.removeLast() }
    }

    @Test
    fun `after removing element at index greater than list size must throw exception`() {
        list.addLast(1)
        assertThrows<IndexOutOfBoundsException> { list.removeAt(1) }
    }

    @Test
    fun `after removing element at negative index must throw exception`() {
        list.addLast(1)
        assertThrows<IndexOutOfBoundsException> { list.removeAt(-1) }
    }

    @Test
    fun `after two elements added and last removed`() {
        list.addLast(0)
        list.addLast(1)
        val removedElement = list.removeLast()
        assertEquals(1, removedElement)
        assertFalse(list.isEmpty)
        assertEquals("$LIST_KEY(0 -> null)", list.toString())
    }

    @Test
    fun `after two elements added and first removed`() {
        list.addLast(0)
        list.addLast(1)
        list.removeAt(0)
        assertFalse(list.isEmpty)
        assertEquals("SinglyLinkedList(1 -> null)", list.toString())
    }

    @Test
    fun `after adding three to end, then removing last 3 times`() {
        list.addLast(50)
        list.addLast(60)
        list.addLast(70)

        var removedElement = list.removeLast()
        assertEquals(70, removedElement)
        assertEquals("$LIST_KEY(50 -> 60 -> null)", list.toString())

        removedElement = list.removeLast()
        assertEquals(60, removedElement)
        assertEquals("$LIST_KEY(50 -> null)", list.toString())

        removedElement = list.removeLast()
        assertEquals(50, removedElement)
        assertEmpty()
    }

    @Test
    fun `after adding and removing from middle`() {
        list.addLast(0)
        list.addLast(2)
        list.addAt(index = 1, value = 1)
        list.addFirst(-1)
        var removedElement = list.removeAt(2)
        assertEquals(1, removedElement)

        removedElement = list.removeFirst()
        assertEquals(-1, removedElement)
        assertEquals("$LIST_KEY(0 -> 2 -> null)", list.toString())
    }

    @Test
    fun `getting element from empty list must throw exception`() {
        assertThrows<IndexOutOfBoundsException> { list.get(index = 0) }
    }

    @Test
    fun `after adding three getting first element must return first`() {
        list.addLast(10)
        list.addLast(20)
        list.addLast(30)
        val firstElement = list.get(index = 0)
        assertEquals(10, firstElement)
    }

    @Test
    fun `after adding three getting last element must return last`() {
        list.addLast(10)
        list.addLast(20)
        list.addLast(30)
        val lastElement = list.get(index = list.size - 1)
        assertEquals(30, lastElement)
    }

    @Test
    fun `after adding three getting element in the middle must return middle`() {
        list.addLast(10)
        list.addLast(20)
        list.addLast(30)
        val middleElement = list.get(index = 1)
        assertEquals(20, middleElement)
    }

    @Test
    fun `clearing empty list should result in empty list`() {
        list.clear()
        assertEmpty()
    }

    @Test
    fun `after three elements added clear must remove all`() {
        list.addLast(10)
        list.addLast(20)
        list.addLast(30)
        list.clear()
        assertEmpty()
    }
}