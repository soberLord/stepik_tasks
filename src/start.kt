import java.math.BigInteger

fun main() {
//    println(task1())
//    println(task2(listOf("5", "4", "3", "2", "1", "6", "7", "8", "9", "10")).map{it})
//    task3(7)
//    println(useTask4())
//    println(task5(listOf("5", "4", "3", "2", "1", "6", "7", "8", "9", "10")))
//    task6()
//    println(task7(listOf(1, 2, 4, 3, 2, 1, 5)))
//    println(task7(listOf()))
    task8(arrayOf(
        "64361863847308796002886528604013323768035602644",
        "60587804274606460837016609279605443939335348830",
        "22095112273333910450241918992726924732820572493"))
}

// hello world
fun task1(): String = "Hello, World"

// bubble sort
fun task2(inputList: List<String>) : IntArray {
    for (i in inputList) {
        i.toInt()
    }
    val outputArray = inputList.map{it.toInt()}.toIntArray()
    for (i in outputArray.indices) {
        for (j in 1 until outputArray.size - i) {
            if (outputArray[j-1] > outputArray[j]) {
                val tmp = outputArray[j-1]
                outputArray[j-1] = outputArray[j]
                outputArray[j] = tmp
            }
        }
    }
    return outputArray
}

// pascalTriangle
fun task3(rows: Int) {
    for (i in 0 until rows) {
        var array = emptyArray<Int>()
        var el = 1
        array += el
        for (j in 1..i) {
            el *= (i - j + 1)
            el /= j
            array += el
        }
        println(array.joinToString(separator = "."))
    }
}

fun task4(name: String, number: Int? = null, toUpperCase: Boolean = false) =
    (if (toUpperCase) name.toUpperCase() else name) + (number ?: "")

fun useTask4() = listOf(
    task4("a"),
    task4("b", number = 1),
    task4("c", toUpperCase = true),
    task4(name = "d", number = 2, toUpperCase = true)
)

fun task5(options: Collection<String>) = options.joinToString(prefix = "[", postfix = "]")

fun task6() {
    val input = readLine()!!
    val outputChar = ArrayList<String>()
    var count = 1
    var old = input[0]
    for (i in 1 until input.length) {
        if (old == input[i]) {
            count++
        } else {
            outputChar.add(old.toString())
            outputChar.add("$count")
            count = 1
            old = input[i]
        }
    }
    outputChar.add(old.toString())
    outputChar.add("$count")
    println(outputChar.joinToString(separator = ""))
}

// toJson
fun task7(collection: Collection<Int>): String = collection.joinToString(separator = ", ", prefix = "[", postfix = "]")

fun task8(array: Array<String>) {
    var sum:BigInteger = BigInteger.valueOf(0)
    while(true) {
        val str: String = readLine()?:return
        if (str.isEmpty()) {
            println(if (sum.toString().length > 9) {
                sum.toString().substring(range = 0..9)
            } else {
                sum.toString()
            })
            return
        }
        sum += str.toBigInteger()
    }
}

