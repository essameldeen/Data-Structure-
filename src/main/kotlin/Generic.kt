class Generic<T> {
    private var content: T? = null

    fun put(content: T?) {
        this.content = content
    }

    fun get(): T? {
        return this.content
    }

    fun isEmpty(): Boolean {
        return content == null
    }
}