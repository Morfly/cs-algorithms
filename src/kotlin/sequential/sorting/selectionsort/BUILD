load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "selection_sort_lib",
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
    name = "selection_sort",
    main_class = "sequential.sorting.selectionsort.SelectionSortKt",
    runtime_deps = [":selection_sort_lib"],
)

java_binary(
    name = "selection_sort_measured",
    main_class = "sequential.sorting.selectionsort._measurement.MeasuredSelectionSortKt",
    runtime_deps = [":selection_sort_lib"],
)