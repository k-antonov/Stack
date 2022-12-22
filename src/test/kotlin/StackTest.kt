import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class StackTest {

    private lateinit var stack: Stack<Int>

    private fun assertEmpty() {
        assertTrue(stack.isEmpty)
        assertEquals("Stack[]", stack.toString())
    }

    @BeforeEach
    fun init() {
        stack = Stack()
    }

    @Test
    fun `after created must be empty`() {
        assertEmpty()
    }

    @Test
    fun `after element pushed must not be empty`() {
        stack.push(10)
        assertFalse(stack.isEmpty)
        assertEquals("Stack[10]", stack.toString())
    }

    @Test
    fun `after three elements pushed size must be three`() {
        stack.push(10)
        stack.push(20)
        stack.push(30)
        assertEquals(3, stack.size)
        assertEquals("Stack[10, 20, 30]", stack.toString())
    }

    @Test
    fun `after popping element from empty stack must throw exception`() {
        assertThrows<IndexOutOfBoundsException> { stack.pop() }
    }

    @Test
    fun `after element pushed then removed must be empty`() {
        stack.push(10)
        val removedElement = stack.pop()
        assertEquals(10, removedElement)
        assertEquals("Stack[]", stack.toString())
    }

    @Test
    fun `after one pushed and two popped must throw exception`() {
        stack.push(10)
        stack.pop()
        assertThrows<IndexOutOfBoundsException> { stack.pop() }
    }

    @Test
    fun `after X, Y pushed popping must return Y`() {
        stack.push(10)
        stack.push(20)
        val removedElement = stack.pop()
        assertEquals(20, removedElement)
    }

    @Test
    fun `after X, Y, Z pushed popping must return Z, Y, X`() {
        stack.push(10)
        stack.push(20)
        stack.push(30)
        var removedElement = stack.pop()
        assertEquals(30, removedElement)
        removedElement = stack.pop()
        assertEquals(20, removedElement)
        removedElement = stack.pop()
        assertEquals(10, removedElement)
        assertEmpty()
    }

    @Test
    fun `peeking empty stack must throw exception`() {
        assertThrows<IndexOutOfBoundsException> { stack.peek() }
    }

    @Test
    fun `after adding three peeking must return last without modifying stack`() {
        stack.push(10)
        stack.push(20)
        stack.push(30)
        val lastElement = stack.peek()
        assertEquals(30, lastElement)
        assertEquals("Stack[10, 20, 30]", stack.toString())
    }

    @Test
    fun `clearing empty stack should result in empty stack`() {
        stack.clear()
        assertEmpty()
    }

    @Test
    fun `after three elements pushed clear must remove all`() {
        stack.push(10)
        stack.push(20)
        stack.push(30)
        stack.clear()
        assertEmpty()
    }
}