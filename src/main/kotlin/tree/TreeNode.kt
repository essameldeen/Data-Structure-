package tree

typealias Visitor <T> = (TreeNode<T>) -> Unit

class TreeNode<T>(val value: T) {

    private val children: MutableList<TreeNode<T>> = mutableListOf()

    fun add(child: TreeNode<T>) = children.add(child)

    fun forEachDepthFirst(visitor: Visitor<T>){
        visitor(this)
        children.forEach{
            it.forEachDepthFirst(visitor)
        }
    }
}