package tree

import queue.ArrayListQueue

typealias Visitor <T> = (TreeNode<T>) -> Unit

class TreeNode<T>(val value: T) {

    private val children: MutableList<TreeNode<T>> = mutableListOf()

    fun add(child: TreeNode<T>) = children.add(child)

    fun forEachDepthFirst(visitor: Visitor<T>) {
        visitor(this)
        children.forEach {
            it.forEachDepthFirst(visitor)
        }
    }

    fun forEachLevelOrder(visitor: Visitor<T>) {
        visitor(this)
        val queue = ArrayListQueue<TreeNode<T>>()
        children.forEach {
            queue.enqueue(it)
        }
        var node = queue.dequeue()
        while (node != null) {
            visitor(node)
            node.children.forEach { queue.enqueue(it) }
            node = queue.dequeue()
        }
    }
}