package binarySearch

import kotlin.math.min

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

/**
 * Returns a pair of same elements start and end indexes, start inclusive, end exclusive.
 * Pair of -1 to -1 if no element found
 */
fun binarySliceSearch(array: IntArray, element: Int): Pair<Int, Int> {
    var l = 0
    var r = array.size - 1
    var mid = -1
    while (l <= r) {  // <=
        val i = (l + r) / 2
        val current = array[i]
        if (current == element) {
            mid = i
            break
        }
        if (current > element) {
            r = i - 1
        } else {
            l = i + 1
        }
    }
    if (l > r) return Pair(-1, -1)

    return Pair(getSliceStart(array, element, l, mid), getIndexAfter(array, element, mid, r))

}

fun getSliceStart(array: IntArray, element: Int, start: Int, end: Int): Int {
    var from = start
    var to = end
    if (array[from] == element) return from

    while (from <= to) {
        val i = (from + to) / 2
        val current = array[i]
        if (current >= element) {
            to = i - 1
        } else if (array[i + 1] == element) {
            return i + 1
        } else {
            from = i + 1
        }
    }
    return -1
}

fun getIndexAfter(array: IntArray, element: Int, start: Int, end: Int): Int {
    var from = start
    var to = end

    if (array[to] == element) return to + 1

    while (from <= to) {
        val i = (from + to) / 2
        val current = array[i]
        if (current <= element) {
            from = i + 1
        } else if (i > 0 && array[i - 1] == element) {
            return i
        } else {
            to = i - 1
        }
    }
    return -1
}