package day2

import readLinesInFile

fun main() {
    data class Instruction(val command: String, val amount: Int)
    data class Position(var horizontal: Int, var vertical: Int)

    fun getInstructions(): List<Instruction> {
        return readLinesInFile("day2/input.txt")
            .map { line -> line.split(" ") }
            .map { split -> Instruction(split[0], split[1].toInt()) }
    }

    fun part1(): Int {
        val endPosition = getInstructions()
            .fold(Position(0, 0)) { position, instruction ->
                when (instruction.command) {
                    "forward" -> Position(position.horizontal + instruction.amount, position.vertical)
                    "up" -> Position(position.horizontal, position.vertical - instruction.amount)
                    "down" -> Position(position.horizontal, position.vertical + instruction.amount)
                    else -> throw IllegalArgumentException("Command must be one of: forward, up, down")
                }
            }

        return endPosition.horizontal * endPosition.vertical
    }

    fun part2(): Int {
        data class PositionAndAim(var position: Position, var aim: Int)

        val endPositionAndAim = getInstructions()
            .fold(PositionAndAim(Position(0, 0), 0)) { positionAndAim, instruction ->
                when (instruction.command) {
                    "forward" -> PositionAndAim(
                        Position(
                            positionAndAim.position.horizontal + instruction.amount,
                            positionAndAim.position.vertical + positionAndAim.aim * instruction.amount
                        ), positionAndAim.aim
                    )

                    "up" -> PositionAndAim(positionAndAim.position, positionAndAim.aim - instruction.amount)
                    "down" -> PositionAndAim(positionAndAim.position, positionAndAim.aim + instruction.amount)
                    else -> throw IllegalArgumentException("Command must be one of: forward, up, down")
                }
            }

        val (horizontal, vertical) = endPositionAndAim.position
        return horizontal * vertical
    }

    println(part1())
    println(part2())
}
