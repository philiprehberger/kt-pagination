package com.philiprehberger.pagination

/** Page of items with pagination metadata. */
public data class PageResponse<T>(
    public val items: List<T>,
    public val page: Int,
    public val pageSize: Int,
    public val totalItems: Long,
    public val totalPages: Int,
    public val hasNext: Boolean,
    public val hasPrevious: Boolean,
)

/** Create a page response. */
public fun <T> pageResponse(items: List<T>, page: Int, pageSize: Int, totalItems: Long): PageResponse<T> {
    val info = paginate(totalItems, page, pageSize)
    return PageResponse(items, info.currentPage, info.pageSize, info.totalItems, info.totalPages, info.hasNext, info.hasPrevious)
}
