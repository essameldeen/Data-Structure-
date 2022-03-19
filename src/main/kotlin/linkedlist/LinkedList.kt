package linkedlist


class LinkedList<T> : Iterable<T>, Collection<T>, MutableIterable<T>, MutableCollection<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    override var size = 0
        private set

    override fun isEmpty(): Boolean {
        return size == 0
    }

    private fun push(value: T): LinkedList<T> {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    private fun append(value: T) {
        if (isEmpty()) {
            push(value)
            return
        } else {
            tail?.next = Node(value)
            tail = tail?.next
            size++
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

    fun removeLast(): T? {
        val head = head ?: return null // case empty
        if (head.next == null) return pop() //case only have one element
        size--

        var prev = head
        var current = head
        var next = current.next

        while (next != null) {
            prev = current
            current = next
            next = current.next
        }
        prev.next = null
        tail = prev
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

    override fun iterator(): MutableIterator<T> {
        return LinkListIterator(this)
    }

    override fun contains(element: T): Boolean {
        for (item in this) {
            if (item == element) return true
        }
        return false
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        for (searched in elements) {
            if (!contains(searched)) return false
        }
        return true
    }

    override fun add(element: T): Boolean {
        append(element)
        return true
    }

    override fun addAll(elements: Collection<T>): Boolean {
        for (item in elements)
            append(item)
        return true
    }

    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    override fun remove(element: T): Boolean {
        val iterator = this.iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            if (item == element) {
                iterator.remove()
                return true
            }
        }
        return false
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        var result = false
        for (item in elements) {
            result = remove(item) || result
        }
        return result
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        var result = false
        val iterator = this.iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            if (!elements.contains(item)) {
                iterator.remove()
                result = true
            }
        }
        return result
    }

    fun getMiddleNode(): T? {
        if (size == 0) return null
        val iterator = this.iterator()
        var iteam = iterator.next()
        var index = 1
        if (size % 2 == 0) {
            var lastIndex = size / 2

            while (index <= lastIndex) {
                index++
                iteam = iterator.next()
            }

        } else {
            var lastIndex = size / 2

            while (index <= lastIndex) {
                index++
                iteam = iterator.next()
            }
        }
        return iteam
    }

}