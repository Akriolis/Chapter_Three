import java.lang.StringBuilder

/**
 * Top level properties and functions
 */

// top-level properties allow tou to define constants in your code

/**
 * Extension functions
 */

fun <T> Collection<T>.joinToString (
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String{
    val result = StringBuilder(prefix)

    for ((index,element) in this.withIndex()){
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun Collection<String>.join(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) = joinToString(separator, prefix, postfix)

//calling join() on a list of objects which won't match String will give you Error

var opCount = 0

fun performOperation(){
    opCount++
}

fun reportOperationCount(){
    println("Operation performed $opCount times")
}

fun String.lastChar(): Char = this.get(this.length-1)

fun String.lastChar2(): Char = get(length - 1)

fun Pet.getName(): String = name

// extension function - it's a function that can be called as a member of a class,
// but is defined outside it

// String is receiver type
// this.get and this.length are receiver objects

// you can import functions with declaration to different name
// import strings.lastChar as last

fun View.showOff() = println("I'm a view!")

fun Button.showOff() = println("I'm a button!")


/**
 * Extension properties
 */

val String.lastChar: Char
    get() = get(length - 1)

// the getter must always be defined

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value){
        this.setCharAt(length - 1, value)
    }

/**
 * Working with collections
 */

/**
 * Varargs
 */

// * spread operator

/**
 * Infix calls
 */

infix fun Any.to(other: Any) = Pair (this, other)

/**
 * Splitting strings
 */

/**
 * Triple-quoted strings
 */

/**
 * Local functions
 */

fun main(args: Array<String>){
    val strings = listOf("first", "second", "fourteenth")
    println(strings.last())

    val numbers: Collection<Int> = setOf(1,14,20,53)
    println(numbers.max())

    println(strings)
    println(numbers)

    val list = listOf(1,2,3)
    println(list.joinToString("; ","(",")"))
    println(list.joinToString(separator = "$", prefix = "!", postfix = "("))
    println(list.joinToString())
    println(list.joinToString("; "))
    println(numbers.joinToString())

    var x = 0
    while(x<5) {
        performOperation()
        x++
    }
    println(reportOperationCount())

    val myPet = Pet()

    println("Kotlin".lastChar())
    println("Kotlin".lastChar2())
    println(myPet.getName())

    println(listOf("one", "two", "eight").join("! ", "", "! "))

    val view: View = Button()
    view.click()
    view.showOff()

    println("myTest".lastChar)

    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)

    val list2 = listOf("args: ", *args)
    println(list2)

    val map = mapOf(0.to("zero"), 1 to "one", 7 to "seven", 53 to "fifty-three")

    val (number, name) = 1 to "one"

    val xMap = 1
    val yMap = 2
    val zMap = 3

    val myMap = mapOf(xMap to "First value", yMap to "Second value", zMap to "Third value")

    println("12.345-6.A".split("\\.|-".toRegex()))
    println("12-405,2552@2512/21251".split("-",",","@","/"))

    val kotlinLogo = """| //
        .|//
        .|/ \        
    """.trimMargin(".")
    println(kotlinLogo)

    val myDollar = """${'$'} 99.9"""
    println(myDollar)

    val testUser = (User(1, "Bilbo","Shire"))
    testUser.saveUser2(testUser)




}



