load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library", "kt_jvm_binary")

exports_files(
    ["FisherYatesShuffle.kt"],
    visibility = ["//:__pkg__"]
)

kt_jvm_library(
    name = "fisheryates_shuffle_lib",
    srcs = ["FisherYatesShuffle.kt"],
    deps = ["//:utils"],
)

java_binary(
    name = "fisheryates_shuffle",
    main_class = "sequential.shuffling.fisheryates.FisherYatesShuffleKt",
    runtime_deps = [":fisheryates_shuffle_lib"],
)