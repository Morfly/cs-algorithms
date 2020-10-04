load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "topological_sort_lib",
    srcs = glob([
        "*.kt",
    ]),
)

java_binary(
    name = "topological_sort",
    main_class = "sequential.graph.postorder.RecursiveTopologicalSortKt",
    runtime_deps = [":topological_sort_lib"],
)