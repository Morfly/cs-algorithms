load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "define_kt_toolchain", "kt_jvm_library")

JVM_VERSION = "1.6"

KOTLIN_VERSION = "1.3"

define_kt_toolchain(
    name = "kotlin_toolchain",
    api_version = KOTLIN_VERSION,
    jvm_target = JVM_VERSION,
    language_version = KOTLIN_VERSION,
)

kt_jvm_library(
    name = "utils",
    srcs = [
        "_util/IntArrayUtils.kt",
        "_util/CollectionUtils.kt",
        "//sequential/shuffling/fisheryates:FisherYatesShuffle.kt",
    ],
    visibility = ["//:__subpackages__"]
)