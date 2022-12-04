fun main() {
    fun part1(input: List<String>) =
        input.parsedPairs().count { (p1, p2) ->
            (p1.first in p2 && p1.last in p2) || (p2.first in p1 && p2.last in p1)
        }

    fun part2(input: List<String>) =
        input.parsedPairs().count { (p1, p2) ->
            p1.first in p2 || p1.last in p2 || p2.first in p1 || p2.last in p1
        }

    val inputs = readInput("Day04")
    println("first=${part1(inputs)}")
    println("part2=${part2(inputs)}")

}

fun List<String>.parsedPairs() = this.map { line ->
    line.split(",").map { pairs ->
        val (a, b) = pairs.split("-").map { it.toInt() }
        a..b
    }
}

