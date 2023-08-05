package day2

import readLinesInFile
import java.lang.IllegalArgumentException

fun main() {
    data class Instruction(val command: String, val amount: Int)
    data class Position(var horizontal: Int, var vertical: Int)

    fun part1(): Int {
        val instructions = readLinesInFile("day2/input.txt")
            .map { line -> line.split(" ") }
            .map { split -> Instruction(split[0], split[1].toInt()) }

        val endPosition = instructions.fold(Position(0, 0)) { position, instruction ->
            when (instruction.command) {
                "forward" -> Position(position.horizontal + instruction.amount, position.vertical)
                "up" -> Position(position.horizontal, position.vertical - instruction.amount)
                "down" -> Position(position.horizontal, position.vertical + instruction.amount)
                else -> throw IllegalArgumentException("Command must be one of: forward, up, down")
            }
        }

        return endPosition.horizontal * endPosition.vertical
    }

    println(part1())
}