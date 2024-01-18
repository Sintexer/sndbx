package l271encodeAndDecodeStrings

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.Ignore

class SolutionTest {

    @Ignore
    @Test
    fun encodeThenDecodeTest() {
        val source = listOf("ab", "v", "|", "ac|", "|d|", "||ee||||||");
        val actual = Solution().encode(source);
        println(actual)
        println(Solution().decode(actual))
        assertEquals(source, Solution().decode(actual));
    }
}