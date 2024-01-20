package l271encodeAndDecodeStrings

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun encodeThenDecodeTest() {
        val source = listOf("ab", "v", "~|~", "~|~",
            "|", "ac|", "avav vvsd ~~~ sf ~|  sdf ~|~ asdfs ~||| asdf",
            "~~||||~~~", "~|~", "~|~|~|~|~|||~||~~|~",
            "|d|", "||ee||||||");
        val actual = Solution().encode(source);
        println(actual)
        println(Solution().decode(actual))
        assertEquals(source, Solution().decode(actual));
    }

    @Test
    fun encodeEmptyTest() {
        val source = listOf("");
        val actual = Solution().encode(source);
        println(actual)
        println(Solution().decode(actual))
        assertEquals(source, Solution().decode(actual));
    }
}