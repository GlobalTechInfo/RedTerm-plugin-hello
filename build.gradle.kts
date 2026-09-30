// The aapt2 binary fetched from Maven does not run under proot on the build host,
// so local builds need a host binary. The override is supplied on the command line
// rather than in gradle.properties, because a path from this machine would fail on
// any other host, including CI.
//
//   ./gradlew assembleDebug -Pandroid.aapt2FromMavenOverride=/path/to/aapt2

plugins {
    id("com.android.application") version "9.2.1" apply false
}
