fun main() {
    val inputs = readInput("Day03")
    println("first=${part1(inputs)}")
    println("part2=${part2(inputs)}")
}

fun priority(c: Char) = if (c in 'a'..'z') c.code - 'a'.code + 1 else c.code - 'A'.code + 27

fun part1(input: List<String>) =
    input.sumOf { rucksack ->
        val half = rucksack.length / 2
        val (first, second) = rucksack.windowed(half, half)
        val common = first.find { it in second } ?: ' '
        priority(common)
    }

fun part2(input: List<String>) =
    input.windowed(3, 3).sumOf { group ->
        val (r1, r2, r3) = group
        val common = r1.find { it in r2 && it in r3 } ?: ' '
        priority(common)
    }