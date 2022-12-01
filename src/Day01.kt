fun main() {
    val inputs = readInput("Day01")
    println("inputs=${max(inputs)}")
    println("topThree=${topThree(inputs)}")
}

fun max(testInput: List<String>) = total(testInput).max()

fun total(testInput: List<String>): List<Int> {
    val res = mutableListOf<Int>()
    testInput.scan(0) { total, input ->
        if (input.isEmpty()) {
            res.add(total)
            0
        } else {
            total + input.toInt()
        }
    }
    return res
}

fun topThree(testInput: List<String>) = total(testInput)
    .sortedDescending()
    .take(3)
    .fold(0) { init, acc -> init + acc }
