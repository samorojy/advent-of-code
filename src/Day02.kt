fun main() {
    val inputs = readInput("Day02")
    println("first=${calculateScore(inputs,true)}")
    println("second=${calculateScore(inputs,false)}")
}

fun calculateScore(input: List<String>, withPlay: Boolean): Int {
    val lose = mapOf(1 to 0, 2 to 1, 0 to 2)
    val won = mapOf(0 to 1, 1 to 2, 2 to 0)

    return input.sumOf { round ->
        val (op, result) = round.split(" ").map { it[0].code }
        val opCode = op - 'A'.code
        val meCode = result - 'X'.code

        val (resultScore, playScore) = if (withPlay) {
            when {
                opCode == meCode -> 3
                won[opCode]!! == meCode -> 6
                else -> 0
            } to meCode + 1
        } else {
            3 * meCode to when (meCode) {
                0 -> lose[opCode]!!
                1 -> opCode
                else -> won[opCode]!!
            } + 1
        }

        resultScore + playScore
    }
}