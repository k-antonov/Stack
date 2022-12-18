class SinglyLinkedList<T> {

    private var head: Node<T>? = null
    var size = 0

    val isEmpty: Boolean
        get() = size == 0

    fun addFirst(value: T) {
        val newNode = Node(value)
        newNode.next = head
        head = newNode
        size++
    }

    fun addLast(value: T) {
        if (isEmpty) {
            addFirst(value)
            return
        }

        val newNode = Node(value)
        var currentNode = head
        while (currentNode?.next != null) {
            currentNode = currentNode.next
        }
        currentNode?.next = newNode
        size++
    }

    fun addAt(index: Int, value: T) {
        if (index < 0 || index > size)
            throw IndexOutOfBoundsException()
        if (index == 0) {
            addFirst(value)
            return
        }
        if (index == size) {
            addLast(value)
            return
        }

        val newNode = Node(value)
        var currentNode = head
        var counter = 0
        while (counter != index - 1) {
            currentNode = currentNode?.next
            counter++
        }
        newNode.next = currentNode?.next
        currentNode?.next = newNode
        size++
    }

    fun removeAt(index: Int) {
        if (index < 0 || index >= size)
            throw IndexOutOfBoundsException()

        var currentNode = head
        var prevNode: Node<T>? = null
        var counter = 0

        if (index == 0) {
            head = currentNode?.next
            size--
            return
        }

        while (counter != index) {
            prevNode = currentNode
            currentNode = prevNode?.next
            counter++
        }
        prevNode?.next = currentNode?.next
        size--
    }

    fun removeLast() = removeAt(size - 1)

    fun removeFirst() = removeAt(0)

    fun get(index: Int): T {
        if (index < 0 || index >= size)
            throw IndexOutOfBoundsException()

        var currentNode = head
        var counter = 0
        while (counter != index) {
            currentNode = currentNode?.next
            counter++
        }
        return currentNode!!.data
    }

    override fun toString(): String {
        var currentNode = head
        var resultString = ""

        while (currentNode != null) {
            resultString += "${currentNode.data} -> "
            currentNode = currentNode.next
        }

        resultString += "null"
        return "SinglyLinkedList($resultString)"
    }

    private inner class Node<T>(val data: T) {
        var next: Node<T>? = null

        override fun toString(): String {
            return "Node(data=$data, next=${next?.data})"
        }
    }
}
