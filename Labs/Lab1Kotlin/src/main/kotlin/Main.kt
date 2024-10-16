fun main() {
    val train = makeForward()
    for (i in train.indices) {
        for (j in 0..<train[i].size) {
            print(train[i][j])
        }
        println()
    }

    val mirrorTrain = makeMirror(train)
    for (i in mirrorTrain.indices) {
        for (j in 0..<mirrorTrain[i].size) {
            print(mirrorTrain[i][j])
        }
        println()
    }

    val trainWreck = makeTogether(train, mirrorTrain)
    for (i in trainWreck.indices) {
        for (j in 0..<trainWreck[i].size) {
            print(trainWreck[i][j])
        }
        println()
    }
}

fun makeForward(): Array<CharArray> {
    val pixel = Array(4) { CharArray(13) }
    pixel[0][0] = ' '
    pixel[0][1] = ' '
    pixel[0][2] = '_'
    pixel[0][3] = '_'
    pixel[0][4] = '_'
    pixel[0][5] = '_'
    pixel[0][6] = '_'
    pixel[0][7] = '_'
    pixel[0][8] = ' '
    pixel[0][9] = ' '
    pixel[0][10] = ' '
    pixel[0][11] = ' '
    pixel[0][12] = ' '
    pixel[1][0] = ' '
    pixel[1][1] = '/'
    pixel[1][2] = '|'
    pixel[1][3] = '_'
    pixel[1][4] = '|'
    pixel[1][5] = '|'
    pixel[1][6] = '_'
    pixel[1][7] = '\\'
    pixel[1][8] = '\''
    pixel[1][9] = '.'
    pixel[1][10] = '_'
    pixel[1][11] = '_'
    pixel[1][12] = ' '
    pixel[2][0] = '('
    pixel[2][1] = ' '
    pixel[2][2] = ' '
    pixel[2][3] = ' '
    pixel[2][4] = '_'
    pixel[2][5] = ' '
    pixel[2][6] = ' '
    pixel[2][7] = ' '
    pixel[2][8] = ' '
    pixel[2][9] = '_'
    pixel[2][10] = ' '
    pixel[2][11] = '_'
    pixel[2][12] = '\\'
    pixel[3][0] = '='
    pixel[3][1] = '\''
    pixel[3][2] = '-'
    pixel[3][3] = '('
    pixel[3][4] = '_'
    pixel[3][5] = ')'
    pixel[3][6] = '-'
    pixel[3][7] = '-'
    pixel[3][8] = '('
    pixel[3][9] = '_'
    pixel[3][10] = ')'
    pixel[3][11] = '-'
    pixel[3][12] = '\''
    return pixel
}

fun makeMirror(array: Array<CharArray>): Array<CharArray> {
    val rowVal = array.size
    val colVal = array[0].size
    val pixel = Array(rowVal) { CharArray(colVal) }
    for (i in array.indices) {
        val rowLength = array[i].size
        for (j in 0..<rowLength / 2) {
            var temp = array[i][j]
            temp = when (temp) {
                '(' -> ')'
                ')' -> '('
                '/' -> '\\'
                '\\' -> '/'
                else -> temp
            }
            pixel[i][j] = when (array[i][rowLength - j - 1]) {
                '(' -> ')'
                ')' -> '('
                '/' -> '\\'
                '\\' -> '/'
                else -> array[i][rowLength - j - 1]
            }
            pixel[i][rowLength - j - 1] = temp
        }
        if (rowLength % 2 != 0) {
            pixel[i][rowLength / 2] = array[i][rowLength / 2]
        }
    }
    return pixel
}

fun makeTogether(array: Array<CharArray>, array2: Array<CharArray>): Array<CharArray> {
    val rowVal = array.size
    val colVal = array[0].size + array2[0].size
    val pixel = Array(rowVal) { CharArray(colVal) }
    for (i in pixel.indices) {
        val rowLength = pixel[i].size
        val halfRowLength = (rowLength / 2)
        for (j in 0..<halfRowLength) {
            pixel[i][j] = array[i][j]
        }
        for (k in halfRowLength..<rowLength) {
            pixel[i][k] = array2[i][k - halfRowLength]
        }
    }
    return pixel
}