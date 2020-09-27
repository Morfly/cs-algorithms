workspace(name = "alrogithms")

# ------
# Kotlin
# ------
local_repository(
    name = "kotlin",
    path = "src/kotlin",
)

load("@kotlin//:kotlin.bzl", "io_bazel_rules_kotlin")

io_bazel_rules_kotlin()

load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kotlin_repositories")

kotlin_repositories()

register_toolchains("//:kotlin_toolchain")
