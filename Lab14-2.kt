fun main() {
    val nonNullableStr: String = "Hello"
    val nullableStr: String? = null
    
    println("Non-nullable string: $nonNullableStr")
    println("Nullable string: $nullableStr")
    println()

    val length1: Int? = nullableStr?.length
    val length2: Int = nonNullableStr.length
    println("Length using safe call on null: $length1")
    println("Length of non-nullable string: $length2")
    println()

    val result1: String = nullableStr ?: "Default Value"
    val result2: String = nonNullableStr ?: "Default Value"
    println("Elvis operator with null: $result1")
    println("Elvis operator with non-null: $result2")
    println()

    try {
        val forcedValue: String? = null
        println(forcedValue!!.length)
    } catch (e: NullPointerException) {
        println("Caught expected NullPointerException using !! operator: ${e.message}")
    }
}
