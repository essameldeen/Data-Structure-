class Collections {
    private val places = listOf("Shoubra", "Obaur", "six octoabr")
    private val places2 = mutableListOf("Shoubra", "Obaur", "six octoabr")
    var pre = mutableListOf<String>()
    var map = mutableMapOf("esms" to 10, "mohamed" to 20)

    fun print() {
        for (item in places) {
            print("$item ")
        }
        for (item in places2) {
            print("$item ")
        }
        pre.add("Esam")
        pre.add("Mohamed")
        print(pre)
  println()
        for (item in map) {
            print(item.value)
            print(" :")
            print(item.key)
        }
    }
}