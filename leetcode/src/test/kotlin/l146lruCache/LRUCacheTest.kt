package l146lruCache

import org.junit.jupiter.api.Test
import org.junit.platform.commons.util.LruCache
import kotlin.test.assertEquals

class LRUCacheTest {


    private val lruCache: LRUCacheFast
        get() {
            val cache = LRUCacheFast(2)
            return cache
        }

    @Test
    fun sampleCaseTest() {
        val cache = lruCache
        cache.put(1, 1); // cache is {1=1}
        cache.put(2, 2); // cache is {1=1, 2=2}
        cache.get(1);    // return 1
        cache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        cache.get(2);    // returns -1 (not found)
        cache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        assertEquals(-1, cache.get(1))    // return -1 (not found)
        assertEquals(3, cache.get(3));    // return 3
        cache.get(4);    // return 4

        //
    }

    @Test
    fun updateTest() {
        val cache = lruCache
        cache.put(2, 6);
        cache.put(1, 5);
        cache.put(1, 2);
        assertEquals(2, cache.get(1))
        assertEquals(6, cache.get(2))
    }

    @Test
    fun refreshTest() {
        val cache = lruCache
        cache.put(2, 1);
        cache.put(3, 2);
        cache.get(3)
        cache.get(2)
        cache.put(4, 3);
        assertEquals(1, cache.get(2))
        assertEquals(-1, cache.get(3))
        assertEquals(3, cache.get(4))
    }
}