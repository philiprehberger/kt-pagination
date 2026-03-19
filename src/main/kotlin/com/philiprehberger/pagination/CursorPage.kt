package com.philiprehberger.pagination

/** Cursor-based page of items. */
public data class CursorPage<T>(
    public val items: List<T>,
    public val cursor: String?,
    public val hasMore: Boolean,
)
