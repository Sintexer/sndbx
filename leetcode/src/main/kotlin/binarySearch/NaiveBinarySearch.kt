package binarySearch

// 15.11.2024
fun binarySearch(array: IntArray, value: Int): Int {
    var l = 0
    var r = array.size - 1
    while (l <= r) {  // <=
        val i = (l + r) / 2 // (_ + _) / _
        val element = array[i]
        if (array[i] == value) return i
        if (element > value) {
            r = i - 1 // -1
        } else {
            l = i + 1 // + 1
        }
    }
    return -1
}