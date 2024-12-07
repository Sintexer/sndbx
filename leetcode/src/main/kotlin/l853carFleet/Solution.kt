package l853carFleet

class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val timeToArrive = Array<Float?>(target) {null}
        for (i in position.indices) {
            val pos = position[i]
            timeToArrive[pos] = (target - pos).toFloat() / speed[i]
        }

        var headTta: Float = -1.toFloat()
        var fleets = 0
        for (i in timeToArrive.size - 1 downTo 0) {
            val curTta = timeToArrive[i] ?: continue
            if (curTta > headTta) {
                headTta = curTta
                ++fleets
            }
        }

        // val dp: Array<IntArray> = Array(n) {i -> intArrayOf(position[i], speed[i])}
        // dp.sortWith(compareByDescending{it[0]})
        // var fleets = 1
        // var headTta = getTimeToArrive(target, dp[0])
        // for (i in 1 until n) {
        //     val curTta = getTimeToArrive(target, dp[i])
        //     if (curTta > headTta) {
        //         ++fleets
        //         headTta = curTta
        //     }
        // }
        return fleets
    }
}
