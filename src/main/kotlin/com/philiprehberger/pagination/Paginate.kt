package com.philiprehberger.pagination

/** Calculate page metadata for offset-based pagination. */
public fun paginate(totalItems: Long, page: Int, pageSize: Int): PageInfo {
    require(page >= 1) { "page must be >= 1" }
    require(pageSize >= 1) { "pageSize must be >= 1" }
    val totalPages = ((totalItems + pageSize - 1) / pageSize).toInt()
    val hasNext = page < totalPages
    val hasPrevious = page > 1
    return PageInfo(
        currentPage = page, pageSize = pageSize, totalItems = totalItems,
        totalPages = totalPages, hasNext = hasNext, hasPrevious = hasPrevious,
        nextPage = if (hasNext) page + 1 else null,
        previousPage = if (hasPrevious) page - 1 else null,
        offset = (page - 1).toLong() * pageSize,
    )
}
