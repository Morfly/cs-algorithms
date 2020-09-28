package sequential.sorting._utils


fun IntArray.exch(i: Int, j: Int) {
    this[i] = this[j].also { this[j] = this[i] }
}