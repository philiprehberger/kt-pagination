package com.philiprehberger.pagination

import java.util.Base64

/** Opaque cursor encoding/decoding. */
public object Cursor {
    /** Encode a value as a URL-safe cursor string. */
    public fun encode(value: String): String = Base64.getUrlEncoder().withoutPadding().encodeToString(value.toByteArray())
    /** Decode a cursor string back to its original value. */
    public fun decode(encoded: String): String = String(Base64.getUrlDecoder().decode(encoded))
}
