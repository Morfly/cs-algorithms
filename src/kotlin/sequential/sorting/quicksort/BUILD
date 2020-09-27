load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_binary")

package(default_visibility = ["//src/kotlin/__subpackages__"])


kt_jvm_binary(
    name = "quicksort",
    srcs = [
        "QuickSort.kt"
    ],
    main_class = "sequential.sorting.quicksort.QuickSortKt",
    deps = [
        "//src/kotlin/_util:utils",
    ]
)