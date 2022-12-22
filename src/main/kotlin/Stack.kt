class Stack<T> {

    private val singlyLinkedList: SinglyLinkedList<T> = SinglyLinkedList()

    val size: Int
        get() = singlyLinkedList.size
    val isEmpty: Boolean
        get() = singlyLinkedList.isEmpty

    fun push(value: T) = singlyLinkedList.addLast(value)

    fun pop(): T = singlyLinkedList.removeLast()

    fun peek(): T = singlyLinkedList.get(size - 1)

    fun clear() = singlyLinkedList.clear()

    override fun toString(): String {
        var resultString = "["
        for (i in 0 until size) {
            resultString += "${singlyLinkedList.get(i)}, "
        }
        if (resultString.length > 1)
            resultString = resultString.dropLast(2)
        resultString += "]"
        return "Stack$resultString"
    }

}