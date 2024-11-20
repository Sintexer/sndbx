package binarySearch

// 20.11.2024
fun binarySearch2(array: IntArray, value: Int): Int {
    var l = 0
    var r = array.size - 1
    while (l <= r) {
        val i = l + (r - l) / 2
        val element = array[i]
        if (element == value) return i
        if (element < value) {
            l = i + 1
        } else {
            r = i - 1
        }
    }
    return -1
}