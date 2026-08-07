package l347topKFrequentElement

import java.util.PriorityQueue

open class Solution {
    open fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val count = IntArray(MAX_VALUE * 2 + 1)
        for (i in nums.indices) {
            ++count[getIndex(nums[i])]
        }
        val heap = PriorityQueue<Pair<Int, Int>>(k) {p1, p2 -> p1.first - p2.first}
        for (i in count.indices) {
            if (count[i] != 0) {
                heap.add(Pair(count[i], getValue(i)))
                if (heap.size > k) {
                    heap.poll()
                }
            }
        }
        return heap.map{it.second}.toIntArray()
    }

    private fun getIndex(value: Int): Int {
        return if (value >= 0) value else -value + MAX_VALUE
    }

    private fun getValue(index:Int): Int {
        return if (index <= MAX_VALUE) index else -index + MAX_VALUE
    }

    companion object {
        const val MAX_VALUE = 10_000
    }
}

class FasterSolution : Solution() {
    override fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val result = IntArray(k)
        val countMap = HashMap<Int, Int>()
        val frequencies = Array<MutableList<Int>>(nums.size + 1) { mutableListOf()}

        nums.forEach {
            countMap.compute(it) { _, count ->
                count?.let(Int::inc) ?: 1
            }
        }

        countMap.forEach{ (number, count) -> frequencies[count] += number }

        var taken = 0
        for (i in frequencies.size - 1 downTo 0) {
            val frequencyNumbers = frequencies[i]
            if (frequencyNumbers.isNotEmpty()) {
                for (number in frequencyNumbers) {
                    result[taken] = number
                    ++taken
                    if (taken == k) {
                        return result
                    }
                }
            }
        }
        return result
    }
}

class CleanerFasterSolution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        if (k == 0) return intArrayOf()
        val result = IntArray(k)
        val countMap = HashMap<Int, Int>()

        nums.forEach {
            countMap[it] = (countMap[it] ?: 0) + 1
        }

        val frequencies = arrayOfNulls<MutableList<Int>>(nums.size + 1)
        countMap.forEach { (num, count) ->
            val bucket = frequencies[count]
            if (bucket == null) {
                frequencies[count] = mutableListOf(num)
            } else {
                bucket.add(num)
            }
        }

        var taken = 0
        for (frequency in nums.size downTo 1) {
            for (num in frequencies[frequency].orEmpty()) {
                result[taken] = num
                ++taken
                if (taken >= k) {
                    return result
                }
            }
        }
        return result
    }
}