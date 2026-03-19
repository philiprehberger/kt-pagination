package com.philiprehberger.pagination

/** Keyset-based page. */
public data class KeysetPage<T>(public val items: List<T>, public val hasMore: Boolean)

/** Create a keyset page. If items.size > pageSize, truncate and set hasMore=true. */
public fun <T> keysetPaginate(items: List<T>, pageSize: Int): KeysetPage<T> {
    return if (items.size > pageSize) KeysetPage(items.take(pageSize), true)
    else KeysetPage(items, false)
}
