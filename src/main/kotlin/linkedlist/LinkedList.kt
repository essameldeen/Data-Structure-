package linkedlist


class LinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0
    fun isEmpty(): Boolean {
        return size == 0
    }

    fun push(value: T): LinkedList<T> {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    fun append(value: T) {
        if (isEmpty()) {
            push(value)
            return
        } else {
            tail?.next = Node(value)
            tail = tail?.next
        }
    }

    fun nodeAt(index: Int): Node<T>? {
        var currentIndex = 0
        var currentNode = head
        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    fun insert(value: T, afterNode: Node<T>): Node<T> {
        if (tail == afterNode) {
            append(value)
            return tail!!
        }
        val newNode = Node(value = value, next = afterNode.next)

        afterNode.next = newNode
        size++
        return newNode

    }

    fun pop(): T? {
        if (!isEmpty()) size--
        val result = head?.value
        head = head?.next

        if (isEmpty()) {
            tail = null
        }
        return result
    }

    fun popLast(): T? {
        val head = head ?: return null // case empty
        if (head.next == null) return pop() //case only have one element
        size--

        var pref = head
        var current = head
        var next = current.next

        while (next != null) {
            pref = current
            current = next
            next = current.next
        }
        pref.next = null
        tail = pref

        return current.value
    }

    fun removeAfter(node: Node<T>): T? {
        val result = node.next?.value
        if (node.next == tail) {
            tail = node
        }
        if (node.next != null)
            size--

        node.next = node.next?.next
        return result
    }

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty List"
        } else {
            head.toString()
        }
    }
}