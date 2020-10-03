load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "dfs_lib",
    srcs = glob([
        "*.kt",
    ]),
)

java_binary(
    name = "dfs_iterative",
    main_class = "sequential.graph.dfs.iterative.IterativeDepthFirstTraversalKt",
    runtime_deps = [":dfs_lib"],
)

java_binary(
    name = "dfs_recursive",
    main_class = "sequential.graph.dfs.RecursiveDepthFirstTraversalKt",
    runtime_deps = [":dfs_lib"],
)