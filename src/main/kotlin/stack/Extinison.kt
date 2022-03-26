package stack


fun String.checkParentheses(): Boolean {
    val stack = Stack<Char>()
    for (ch in this) {
        when (ch) {
            '(' -> stack.push(ch)
            ')' -> {
                if (stack.isEmpty) return false
                stack.pop()
            }
        }
    }
    return stack.isEmpty
}