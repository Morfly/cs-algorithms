load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "bfs_lib",
    srcs = glob(["*.kt"]),
)

java_binary(
    name = "bfs",
    main_class = "sequential.graph.bfs.BreadthFirstTraversalKt",
    runtime_deps = [":bfs_lib"],
)