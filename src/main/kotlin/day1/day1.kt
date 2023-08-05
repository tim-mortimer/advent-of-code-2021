package day1

import readLinesInFile

fun main() {
    fun part1(): Int {
        val input = readLinesInFile("day1/input.txt").map { it.toInt() }
        return input.windowed(2).count { (a, b) -> b > a }
    }

    fun part2(): Int {
        val input = readLinesInFile("day1/input.txt").map { it.toInt() }
        return input.windowed(3)
            .map { a -> a.sum() }
            .windowed(2)
            .count { (a, b) -> b > a }
    }

    println(part1())
    println(part2())
}