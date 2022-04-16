import com.sun.source.tree.Tree
import linkedlist.LinkedList
import linkedlist.mergeSorted
import linkedlist.printIReverse
import linkedlist.reversed
import queue.ArrayListQueue
import stack.Stack
import stack.checkParentheses
import tree.TreeNode

fun makeBeverageTree(): TreeNode<String> {
    val tree = TreeNode("Beverage")

    val hot = TreeNode("Hot")
    val cold = TreeNode("Cold")

    val tea = TreeNode("Tea")
    val coffee = TreeNode("Coffee")
    val chocolate = TreeNode("Chocolate")

    val blackTea = TreeNode("Black")
    val greenTea = TreeNode("green")
    val chaiTea = TreeNode("Chai")

    val soda = TreeNode("Soda")
    val milk = TreeNode("Milk")

    val gingerAle = TreeNode("Ginger Ale")
    val bitterLemon = TreeNode("bitter Lemon")


    tree.add(hot)
    tree.add(cold)

    hot.add(tea)
    hot.add(coffee)
    hot.add(chocolate)

    cold.add(soda)
    cold.add(milk)

    tea.add(blackTea)
    tea.add(greenTea)
    tea.add(chaiTea)

    soda.add(gingerAle)
    soda.add(bitterLemon)

    return tree
}

fun main(args: Array<String>) {


    val tree = makeBeverageTree()

    tree.forEachDepthFirst {
        println(it.value)
    }
//    val queue = ArrayListQueue<Int>()
//    queue.enqueue(5)
//    queue.enqueue(4)
//    queue.enqueue(3)
//    queue.enqueue(2)
//
//    println(queue.peek())
//    println(queue.dequeue())
//    println(queue.peek())


//    var stack = Stack<Int>().apply {
//        push(5)
//        push(6)
//        push(7)
//        push(8)
//    }
//
//    println(stack.toString())
//    println(stack.pop())
//
//    var  str :String = "(5esam"
//    println(str.checkParentheses())

//
//    var node1 = Node(1)
//    var node2 = Node(2)
//    var node3 = Node(3)
//    node1.next = node2
//    node2.next = node3
//
//    println(node2.toString())
//
//    var list = LinkedList<Int>()
//    list.push(5).push(4).push(3)
//    println(list.toString())
//
//    val list2 = LinkedList<Int>()
//    list2.push(1)
//    list2.push(2)
//    list2.push(3)
//    print("List before insert:")
//    println(list2.toString())
//    var middleNode = list2.nodeAt(1)!!
//    for (i in 1..3)
//        middleNode = list2.insert(i * -1, middleNode)
//
//    print("List after insert:")
//    println(list2.toString())
//
//
//    var valueRemoved = list2.pop()
//    print("List after pop:")
//    println(list2.toString())
//    println("value Removed: $valueRemoved")
//
//
//    print("List before popLast:")
//    println(list2.toString())
//    valueRemoved = list2.popLast()
//    print("List after popLast:")
//    println(list2.toString())
//    println("value Removed: $valueRemoved")
//
//    print("List before removeAfter:")
//    println(list2.toString())
//
//    var index = list2.nodeAt(1)!!
//    valueRemoved = list2.removeAfter(index)
//
//
//    print("List after removeAfter:")
//    println(list2.toString())
//    println("value Removed: $valueRemoved")
//
//
//    for (item in list2) {
//        println(item * 10 )
//    }

    // remove item
//    val list: MutableCollection<Int> = LinkedList()
//    list.add(3)
//    list.add(2)
//    list.add(1)
//    println(list)
//    println(list.remove(1))
//    println(list)
//
//    // retain listOFItems
//    val list2: MutableCollection<Int> = LinkedList()
//    list2.add(3)
//    list2.add(2)
//    list2.add(1)
//    list2.add(4)
//    list2.add(5)
//    println(list2)
//    println(list2.retainAll(listOf(3, 4, 5)))
//    println(list2)
//
//    val list3 = LinkedList<Int>()
//    list3.add(6)
//    list3.add(5)
//    list3.add(4)
//    list3.add(3)
//    list3.add(2)
//
//    println(list3)
//    list3.printIReverse()
//    println()
//
//    val list4 = LinkedList<Int>()
//    list4.add(1)
//    list4.add(2)
//    list4.add(3)
//    println(list4)
//    println(list4.getMiddleNode())
//
//    val list5 = LinkedList<Int>()
//    list5.add(1)
//    list5.add(2)
//    list5.add(3)
//    list5.add(4)
//    println(list5.toString())
//    println(list5.getMiddleNode())
//
//    val list6 = LinkedList<Int>()
//    list6.add(1)
//    list6.add(2)
//    list6.add(3)
//    list6.add(4)
//    println(list6)
//    println(list6.reversed())
//
//    val left = LinkedList<Int>()
//    left.add(1)
//    left.add(2)
//    left.add(3)
//    left.add(4)
//    println(left)
//    val right = LinkedList<Int>()
//    right.add(-1)
//    right.add(5)
//    right.add(7)
//    right.add(8)
//    println(right)
//    println(left.mergeSorted(right))

//    val generic = Generic<Int>()
//    val x: Int = 5
//    generic.put(x)
//    println(generic.get())
//    println(generic.isEmpty())
//
//
//    val scopingFunction = ScopingFunction()
//    val value: String? = "Esam"
//    println(scopingFunction.isNotEmpty(value))
//
//    val value2: String? = ""
//    println(scopingFunction.isEmpty(value2))
//
//
//    val cl = Collections()
//    cl.print()
//
//    println()
//    var sum: Int = (1..10).reduce { sum, element -> sum + element }
//    println(
//        sum
//    )
//
//    println(10 * (10 + 1) / 2)
//    println(Int.MIN_VALUE)
//    var number = listOf(1, 10, 20, 30, 40, 50, 20, 14, 12, 30, 10000, -120, 15)
//
//    var minValue = Int.MIN_VALUE
//    var currentCounter = 0
//    for (value in number) {
//        if (value == minValue) {
//            print(value)
//            currentCounter += 1
//        }
//    }
//    println(currentCounter)


// for (i in 1..5) println(i)

//    val items = ArrayList<Int>(5)
//    items.add(5)
//    items.add(4)
//    items.add(3)
//    items.add(2)
//    items.add(1)
//    for (item in items) println(item)
//
//    var isTerminate = false
//    var i = 0
//    while (isTerminate) {
//        println(i)
//        i++
//        if (i > 5)
//            isTerminate = false
//    }

}