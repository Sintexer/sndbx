package l875kokoEatingBananas

class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var l: Int = 1
        var r: Int = Int.MAX_VALUE

        while (l <= r) {
            val mid = l + (r - l) / 2

            if (fits(piles, h, mid)) {
                r = mid - 1
            } else {
                l = mid + 1
            }
        }
        return l

    }

    fun fits(piles: IntArray, h: Int, attempt: Int): Boolean {
        var temp = 0
        piles.forEach{temp += ((it + attempt - 1) / attempt)}

        // return piles.map { (it + attempt - 1) / attempt }.sum() <= h
        return temp <= h
    }
}