package com.philiprehberger.pagination

import kotlin.test.*

class PaginateTest {
    @Test fun `first page`() { val p = paginate(100, 1, 10); assertEquals(10, p.totalPages); assertTrue(p.hasNext); assertFalse(p.hasPrevious); assertEquals(0L, p.offset) }
    @Test fun `last page`() { val p = paginate(100, 10, 10); assertFalse(p.hasNext); assertTrue(p.hasPrevious) }
    @Test fun `zero items`() { val p = paginate(0, 1, 10); assertEquals(0, p.totalPages); assertFalse(p.hasNext) }
    @Test fun `cursor round trip`() { val v = "user:123"; assertEquals(v, Cursor.decode(Cursor.encode(v))) }
    @Test fun `keyset has more`() { val p = keysetPaginate(listOf(1,2,3,4,5,6), 5); assertTrue(p.hasMore); assertEquals(5, p.items.size) }
    @Test fun `keyset no more`() { val p = keysetPaginate(listOf(1,2,3), 5); assertFalse(p.hasMore) }
    @Test fun `pageResponse`() { val r = pageResponse(listOf("a","b"), 1, 10, 50); assertEquals(5, r.totalPages); assertTrue(r.hasNext) }
}
