package stack

interface StackInterface<Element> {
    fun push(element: Element)
    fun pop(): Element?

    fun  peek():Element?
    val count: Int
        get

    val isEmpty: Boolean
        get() = count == 0
}