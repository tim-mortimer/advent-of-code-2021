package day3

import readLinesInFile

fun main() {
    fun part1(): Int {
        val input = readLinesInFile("day3/input.txt")

        val gammaRate = input[0]
            .mapIndexed { index, _ ->
                input.groupingBy { reading -> reading[index] }.eachCount().maxBy { it.value }.key
            }
            .joinToString("")

        val decimalGammaRate = gammaRate.toInt(2)

        val epsilonRate = input[0]
            .mapIndexed { index, _ ->
                input.groupingBy { reading -> reading[index] }.eachCount().minBy { it.value }.key
            }
            .joinToString("")

        val decimalEpsilonRate = epsilonRate.toInt(2)

        return decimalGammaRate * decimalEpsilonRate
    }

    println(part1())
}