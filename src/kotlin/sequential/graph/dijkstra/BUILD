load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "dijkstra_lib",
    srcs = glob([
        "*.kt",
    ]),
)

java_binary(
    name = "dijkstra",
    main_class = "sequential.graph.dijkstra.DijkstraKt",
    runtime_deps = [":dijkstra_lib"],
)