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
) {
    /** Return all pagination metadata as a map for easy JSON serialization. */
    public fun toMap(): Map<String, Any> = buildMap {
        put("currentPage", currentPage)
        put("pageSize", pageSize)
        put("totalItems", totalItems)
        put("totalPages", totalPages)
        put("hasNext", hasNext)
        put("hasPrevious", hasPrevious)
        if (nextPage != null) put("nextPage", nextPage)
        if (previousPage != null) put("previousPage", previousPage)
        put("offset", offset)
    }
}
