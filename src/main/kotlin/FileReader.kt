fun readLinesInFile(file: String) = object {}.javaClass
    .getResourceAsStream(file)
    ?.bufferedReader()
    ?.readLines()
    ?: throw IllegalArgumentException()