package linkedlist

fun <T> LinkedList<T>.printIReverse() {
    this.nodeAt(0)?.printIReverse()
}

fun <T> Node<T>?.printIReverse() {
    this?.next?.printIReverse()
    if (this?.next != null) {
        print(" -> ")
    }
    print(this?.value?.toString())
}
