load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "insertion_sort_lib",
    srcs = [
        "InsertionSort.kt",
        "RangedInsertionSort.kt",
        "_measurement/MeasuredInsertionSort.kt"
    ],
    deps = [
        "//sequential/sorting/_measurement:measurement",
        "//:utils",
    ],
    visibility = ["//visibility:public"],
)

java_binary(
    name = "insertion_sort",
    main_class = "sequential.sorting.insertionsort.InsertionSortKt",
    runtime_deps = [":insertion_sort_lib"],
)

java_binary(
    name = "insertion_sort_ranged",
    main_class = "sequential.sorting.insertionsort.RangedInsertionSortKt",
    runtime_deps = [":insertion_sort_lib"],
)

java_binary(
    name = "insertion_sort_measured",
    main_class = "sequential.sorting.insertionsort._measurement.MeasuredInsertionSortKt",
    runtime_deps = [":insertion_sort_lib"],
)