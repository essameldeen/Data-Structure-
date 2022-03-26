package stack

import javax.lang.model.element.Element

class Stack<Element : Any>() : StackInterface<Element> {
    private val storage = arrayListOf<Element>()


    override fun toString() = buildString {
        appendLine("-------top------")
        storage.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("----------")
    }


    override fun pop(): Element? {
        if (isEmpty) return null
        return storage.removeAt(storage.size - 1)
    }

    override fun push(element: Element) {
        storage.add(element)
    }

    override fun peek(): Element? {
        return storage.lastOrNull()
    }

    override val count: Int
        get() = storage.size
}