package com.philiprehberger.pagination

/** Metadata for an offset-based page. */
public data class PageInfo(
    public val currentPage: Int,
    public val pageSize: Int,
    public val totalItems: Long,
    public val totalPages: Int,
    public val hasNext: Boolean,
    public val hasPrevious: Boolean,
    public val nextPage: Int?,
    public val previousPage: Int?,
    public val offset: Long,
)
