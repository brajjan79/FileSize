[![Build Status](https://travis-ci.com/brajjan79/FileSize.svg?branch=main)](https://travis-ci.com/brajjan79/FileSize)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/c866c4f4c44c4ea8bf539031c235a8a3)](https://www.codacy.com/gh/brajjan79/FileSize/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=brajjan79/FileSize&amp;utm_campaign=Badge_Grade)
[![Codacy Badge](https://app.codacy.com/project/badge/Coverage/c866c4f4c44c4ea8bf539031c235a8a3)](https://www.codacy.com/gh/brajjan79/FileSize/dashboard?utm_source=github.com&utm_medium=referral&utm_content=brajjan79/FileSize&utm_campaign=Badge_Coverage)
[![JitPack](https://jitpack.io/v/brajjan79/FileSize.svg)](https://jitpack.io/#brajjan79/FileSize)

# FileSize
FileSize is a small JAVA plugin that provides a fast and easy way to get the size of a file in the format that is needed.

When sizing up a file you can convert the size to:
* Bytes
* KiloBytes
* MegaBytes
* GigaBytes
* GigaBytes
* TeraBytes
* PetaBytes
* ExaBytes
* ZettaBytes
* YottaBytes

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

// Static way
double bytes = FileSize.size(someFile).getBytes();
double KiloBytes = FileSize.size(someFile).getKiloBytes();
// This goes on up to YotaBytes
```