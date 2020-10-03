load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "shellsort_lib",
    srcs = glob([
        "*.kt",
        "gapsequence/*.kt",
        "_measurement/MeasuredShellSort.kt"
    ]) + [
        "//sequential/math:3SmoothNumbers.kt"
    ],
    deps = [
        "//sequential/sorting/_measurement:measurement",
        "//:utils",
    ]
)

java_binary(
    name = "shellsort",
    main_class = "sequential.sorting.shellsort.ShellSortKt",
    runtime_deps = [":shellsort_lib"],
)

java_binary(
    name = "shellsort_measured",
    main_class = "sequential.sorting.shellsort._measurement.MeasuredShellSortKt",
    runtime_deps = [":shellsort_lib"],
)