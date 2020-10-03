load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "bubble_sort_lib",
    srcs = glob([
        "*.kt",
        "_measurement/*.kt",
    ]),
    deps = [
        "//sequential/sorting/_measurement:measurement",
        "//:utils",
    ],
    visibility = ["//visibility:public"],
)

java_binary(
    name = "bubble_sort",
    main_class = "sequential.sorting.bubblesort.BubbleSortKt",
    runtime_deps = [":bubble_sort_lib"],
)

java_binary(
    name = "bubble_sort_ranged",
    main_class = "sequential.sorting.bubblesort.ranged.RangedBubbleSortKt",
    runtime_deps = [":bubble_sort_lib"],
)

java_binary(
    name = "bubble_sort_measured",
    main_class = "sequential.sorting.bubblesort._measurement.MeasuredBubbleSortKt",
    runtime_deps = [":bubble_sort_lib"],
)