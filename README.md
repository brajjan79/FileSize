[![Java CI with Maven](https://github.com/brajjan79/FileSize/actions/workflows/maven.yml/badge.svg)](https://github.com/brajjan79/FileSize/actions/workflows/maven.yml)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/c866c4f4c44c4ea8bf539031c235a8a3)](https://app.codacy.com/gh/brajjan79/FileSize/dashboard?utm_source=gh&utm_medium=referral&utm_content=&utm_campaign=Badge_grade)
[![Codacy Badge](https://app.codacy.com/project/badge/Coverage/c866c4f4c44c4ea8bf539031c235a8a3)](https://app.codacy.com/gh/brajjan79/FileSize/dashboard?utm_source=gh&utm_medium=referral&utm_content=&utm_campaign=Badge_coverage)
[![JitPack](https://jitpack.io/v/brajjan79/FileSize.svg)](https://jitpack.io/#brajjan79/FileSize)

# FileSize
FileSize is a small JAVA plugin that provides a fast and easy way to get the size of a file in the format that is needed.

Note if file is not found will return a 0.0 double value.

When sizing up a file you can convert the size to:
*   Bytes
*   KiloBytes
*   MegaBytes
*   GigaBytes
*   GigaBytes
*   TeraBytes
*   PetaBytes
*   ExaBytes
*   ZettaBytes
*   YottaBytes

## Installation

The plugin is available in JitPack.
https://jitpack.io/#brajjan79/FileSize

## Usage

**Imports:**
```JAVA
import java.io.File;
import com.github.filesize.FileSize;
```

**Code:**
```JAVA
File someFile = new File("some path to file");

// Non static way
FileSize fileSize = new FileSize(someFile);

double bytes = fileSize.getBytes();
double KiloBytes = fileSize.getKiloBytes();
// This goes on up to YotaBytes

// Static way Deprecated
double bytes = FileSize.size(someFile).getBytes();
double KiloBytes = FileSize.size(someFile).getKiloBytes();

double bytes = FileSize.getBytes(someFile);
double KiloBytes = FileSize.getKiloBytes(someFile);
// This goes on up to YotaBytes
```