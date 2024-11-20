package binarySearch

// 19.11.2024
fun binarySearch1(array: IntArray, value: Int): Int {
    var l = 0
    var r = array.size - 1
    while (l <= r) {
        val mid = (l + r) / 2
        val currentValue = array[mid]
        if (currentValue == value) return mid
        if (currentValue < value) {
            l = mid + 1
        } else {
            r = mid - 1
        }
    }
    return -1
}