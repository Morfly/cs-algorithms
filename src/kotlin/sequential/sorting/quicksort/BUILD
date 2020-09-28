load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "quicksort_lib",
    srcs = ["QuickSort.kt"] + glob(["partition/*.kt"]),
    deps = [
        "//sequential/sorting/insertionsort:insertion_sort_lib",
        "//sequential/sorting/_analysis:sort_analysis",
        "//:utils"
    ]
)

java_binary(
    name = "quicksort",
    main_class = "sequential.sorting.quicksort.QuickSortKt",
    runtime_deps = [":quicksort_lib"],
)
