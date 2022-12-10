package avlTree

import tree.VisitorBinary
import java.lang.Integer.max

typealias VisitorBinary <T> = (T) -> Unit

class AvlNode<T>(var value: T) {

    var leftChild: AvlNode<T>? = null
    var rightChild: AvlNode<T>? = null
    val min: AvlNode<T>?
        get() = leftChild?.min ?: this

    var height = 0
    val leftHeight: Int
        get() = leftChild?.height ?: -1

    val rightHeight: Int
        get() = rightChild?.height ?: -1

    val balanceFactory: Int
        get() = leftHeight - rightHeight


    override fun toString(): String = diagram(this)

    private fun diagram(node: AvlNode<T>?, top: String = "", root: String = "", bottom: String = ""): String {

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

    private fun  leftRotate(node:AvlNode<T>):AvlNode<T>{
        val pivot = node.rightChild!!

        node.rightChild = pivot.leftChild
        pivot.leftChild = node

        node.height = max(node.leftHeight , node.rightHeight) +1
        pivot.height = max(pivot.leftHeight , pivot.rightHeight) +1
        return pivot

    }
    fun traversInOrder(visit: VisitorBinary<T>) {
        leftChild?.traversInOrder(visit)
        visit(value)
        rightChild?.traversInOrder(visit)
    }
}