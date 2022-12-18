import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SinglyLinkedListTest {

    private lateinit var list: SinglyLinkedList

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
        list.removeLast()
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
        list.removeLast()
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

        list.removeLast()
        assertEquals("$LIST_KEY(50 -> 60 -> null)", list.toString())
        list.removeLast()
        assertEquals("$LIST_KEY(50 -> null)", list.toString())
        list.removeLast()
        assertEmpty()
    }

    @Test
    fun `after adding and removing from middle`() {
        list.addLast(0)
        list.addLast(2)
        list.addAt(index = 1, value = 1)
        list.addFirst(-1)
        list.removeAt(2)
        list.removeFirst()
        assertEquals("$LIST_KEY(0 -> 2 -> null)", list.toString())
    }
}