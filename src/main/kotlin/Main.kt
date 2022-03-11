import linkedlist.LinkedList
import linkedlist.Node

fun main(args: Array<String>) {


    var node1 = Node(1)
    var node2 = Node(2)
    var node3 = Node(3)
    node1.next = node2
    node2.next = node3

    println(node2.toString())

    var list = LinkedList<Int>()
    list.push(5).push(4).push(3)
    println(list.toString())

    val list2 = LinkedList<Int>()
    list2.push(1)
    list2.push(2)
    list2.push(3)
    print("List before insert:")
    println(list2.toString())
    var middleNode = list2.nodeAt(1)!!
    for (i in 1..3)
        middleNode = list2.insert(i * -1, middleNode)

    print("List after insert:")
    println(list2.toString())


    var valueRemoved = list2.pop()
    print("List after pop:")
    println(list2.toString())
    println("value Removed: $valueRemoved")


    print("List before popLast:")
    println(list2.toString())
    valueRemoved = list2.popLast()
    print("List after popLast:")
    println(list2.toString())
    println("value Removed: $valueRemoved")

    print("List before removeAfter:")
    println(list2.toString())

    var index = list2.nodeAt(1)!!
    valueRemoved = list2.removeAfter(index)


    print("List after removeAfter:")
    println(list2.toString())
    println("value Removed: $valueRemoved")
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