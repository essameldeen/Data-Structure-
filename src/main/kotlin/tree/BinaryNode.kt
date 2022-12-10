package tree

typealias VisitorBinary <T> = (T) -> Unit

class BinaryNode<T>(var value: T) {

    var leftChild: BinaryNode<T>? = null
    var rightChild: BinaryNode<T>? = null
    val min: BinaryNode<T>?
        get() = leftChild?.min ?: this

    override fun toString(): String = diagram(this)

    private fun diagram(node: BinaryNode<T>?, top: String = "", root: String = "", bottom: String = ""): String {

        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}"
            } else {
                diagram(node.rightChild, "$top ", "----", "$top| ") +
                        root + "${node.value}\n" + diagram(
                    node.leftChild, "${bottom}| ",
                    "$bottom|---", "$bottom"
                )
            }
        } ?: "${root}null\n"

    }

    fun traversInOrder(visit: VisitorBinary<T>) {
        leftChild?.traversInOrder(visit)
        visit(value)
        rightChild?.traversInOrder(visit)
    }
}