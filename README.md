# pagination

[![Tests](https://github.com/philiprehberger/kt-pagination/actions/workflows/publish.yml/badge.svg)](https://github.com/philiprehberger/kt-pagination/actions/workflows/publish.yml)
[![Maven Central](https://img.shields.io/maven-central/v/com.philiprehberger/pagination)](https://central.sonatype.com/artifact/com.philiprehberger/pagination)
[![License](https://img.shields.io/github/license/philiprehberger/kt-pagination)](LICENSE)

Framework-agnostic pagination for offset, cursor, and keyset patterns.

## Installation

### Gradle (Kotlin DSL)

```kotlin
implementation("com.philiprehberger:pagination:0.1.3")
```

### Maven

```xml
<dependency>
    <groupId>com.philiprehberger</groupId>
    <artifactId>pagination</artifactId>
    <version>0.1.3</version>
</dependency>
```

## Usage

```kotlin
import com.philiprehberger.pagination.*

// Offset-based
val page = paginate(totalItems = 250, page = 3, pageSize = 20)
page.totalPages   // 13
page.hasNext      // true
page.offset       // 40

// Cursor-based
val encoded = Cursor.encode("user:123")
val decoded = Cursor.decode(encoded) // "user:123"

// Keyset
val result = keysetPaginate(items, pageSize = 20)
result.hasMore // true if more items available
```

## API

| Function / Class | Description |
|------------------|-------------|
| `paginate(totalItems, page, pageSize)` | Calculate page metadata |
| `pageResponse(items, page, pageSize, totalItems)` | Page of items with metadata |
| `CursorPage<T>` | Cursor-based page with items, cursor, hasMore |
| `Cursor.encode(value)` / `Cursor.decode(encoded)` | Opaque cursor encoding |
| `keysetPaginate(items, pageSize)` | Keyset-based pagination |

## Development

```bash
./gradlew test       # Run tests
./gradlew build      # Build JAR
```

## License

MIT
