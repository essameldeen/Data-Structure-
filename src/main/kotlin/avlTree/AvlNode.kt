package avlTree

import tree.BinaryNode
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

    private fun leftRotate(node: AvlNode<T>): AvlNode<T> {
        val pivot = node.rightChild!!

        node.rightChild = pivot.leftChild
        pivot.leftChild = node

        node.height = max(node.leftHeight, node.rightHeight) + 1
        pivot.height = max(pivot.leftHeight, pivot.rightHeight) + 1
        return pivot

    }

    private fun rightRotate(node: AvlNode<T>): AvlNode<T> {
        val pivot = node.leftChild!!

        node.leftChild = pivot.rightChild
        pivot.rightChild = node

        node.height = max(node.leftHeight, node.rightHeight) + 1
        pivot.height = max(pivot.leftHeight, pivot.rightHeight) + 1
        return pivot

    }

    private fun rightLeftRotate(node: AvlNode<T>): AvlNode<T> {
        val rightChild = node.rightChild ?: return node
        node.rightChild = rightRotate(rightChild)
        return leftRotate(node)
    }

    private fun leftRightRotate(node: AvlNode<T>): AvlNode<T> {
        val leftChild = node.leftChild ?: return node
        node.leftChild =leftRotate(leftChild)
        return rightRotate(node)
    }

    private fun balanced(node: AvlNode<T>):AvlNode<T>{
        return when(node.balanceFactory){
            2->{
              if(node.leftChild?.balanceFactory==-1){
                  leftRightRotate(node)
              }else{
                  rightRotate(node)
              }
            }
            -2->{
                if(node.rightChild?.balanceFactory==1){
                    rightLeftRotate(node)
                }else{
                    leftRotate(node)
                }
            }
            else ->node
        }
    }
    fun  insert(node: AvlNode<T>?,value: T):AvlNode<T>?{
       node ?: return AvlNode(value)

        (node.value < value){
            node.leftChild = node.leftChild?.let { insert(it,value) }
        }else{
            node.rightChild = node.rightChild?.let { insert(it,value) }
        }


        val balancedNode = balanced(node)
        balancedNode?.height = max(balancedNode?.leftHeight  , balancedNode?.rightHeight)+1
           return balancedNode
    }
    private fun remove(node: BinaryNode<T>?, value: T): BinaryNode<T>? {
        node ?: return null

        when {
            value == node.value -> {
                if (node.leftChild == null && node.rightChild == null) {
                    return null
                }
                if (node.leftChild == null) {
                    return node.rightChild
                }
                if (node.rightChild == null) {
                    return node.leftChild
                }
                node.rightChild?.min?.value?.let {
                    node.value = it
                }
                node.rightChild = remove(node.rightChild, node.value)
            }
            value < node.value -> remove(node.leftChild, value)
            value > node.value -> remove(node.rightChild, value)
        }
        return node
    }

    fun traversInOrder(visit: VisitorBinary<T>) {
        leftChild?.traversInOrder(visit)
        visit(value)
        rightChild?.traversInOrder(visit)
    }
}

