load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "merge_sort_lib",
    srcs = glob([
        "*.kt",
        "_measurement/*.kt"
    ]),
    deps = [
        "//sequential/sorting/_measurement:measurement",
        "//:utils",
    ]
)

java_binary(
    name = "merge_sort",
    main_class = "sequential.sorting.mergesort.MergeSortKt",
    runtime_deps = [":merge_sort_lib"],
)

java_binary(
    name = "merge_sort_measured",
    main_class = "sequential.sorting.mergesort._measurement.MeasuredMergeSortKt",
    runtime_deps = [":merge_sort_lib"],
)