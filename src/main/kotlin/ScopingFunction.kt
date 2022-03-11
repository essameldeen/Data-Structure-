class ScopingFunction {


    fun isNotEmpty(obj: String?): Boolean? {
        val isEmpty = obj?.let {
            it.isNotEmpty()
        }
        return isEmpty ?: false
    }

    fun isEmpty(obj: String?): Boolean? {
        val isEmpty = obj?.run {
            this.isEmpty()
        }
        return isEmpty ?: false // if isEmpty =null return false
    }

    fun isEmptyAlso(obj: String?): Boolean? {
        var isEmpty = false
        obj?.also {
            // return the same obj
        }.let {
            isEmpty = it?.isEmpty() == true
        }
        return isEmpty
    }

    fun isEmptyApply(obj: String?): Boolean? {
        var isEmpty = false
        obj?.apply {
            this.length
            // return the same obj
        }.let {
            isEmpty = it?.isEmpty() == true
        }
        return isEmpty
    }
}