package day1

import java.io.File

fun main() {
    fun part1(): Int {
        val input = File("src/main/kotlin/day1/part1input.txt").readLines().map { it.toInt() }
        return input.windowed(2).count { (a, b) -> b > a }
    }

    fun part2(): Int {
        val input = File("src/main/kotlin/day1/part2input.txt").readLines().map { it.toInt() }
        return input.windowed(3)
            .map { a -> a.sum() }
            .windowed(2)
            .count { (a, b) -> b > a }
    }

    println(part1())
    println(part2())
}