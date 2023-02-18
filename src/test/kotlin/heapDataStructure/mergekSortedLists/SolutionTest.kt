package heapDataStructure.mergekSortedLists

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun mergeKLists0() {
        val list1 = ListNode(1, ListNode(4, ListNode(5)))
        val list2 = ListNode(1, ListNode(3, ListNode(4)))
        val list3 = ListNode(2, ListNode(6))
        val lists = arrayListOf<ListNode?>(list1, list2, list3)
        val solution = Solution()
        val result = solution.mergeKLists(lists)
        assertEquals(result?.`val`, 1)
        assertEquals(result?.next?.`val`, 1)
        assertEquals(result?.next?.next?.`val`, 2)
        assertEquals(result?.next?.next?.next?.`val`, 3)
        assertEquals(result?.next?.next?.next?.next?.`val`, 4)
        assertEquals(result?.next?.next?.next?.next?.next?.`val`, 4)
        assertEquals(result?.next?.next?.next?.next?.next?.next?.`val`, 5)
        assertEquals(result?.next?.next?.next?.next?.next?.next?.next?.`val`, 6)
    }
}
