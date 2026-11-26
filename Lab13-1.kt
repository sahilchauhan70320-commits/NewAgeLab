fun calculateBonus(deptCode: String, years: Int, salary: Double): Double {
    val percentage = when {
        deptCode.equals("IT", ignoreCase = true) && years > 5 -> 0.20
        deptCode.equals("HR", ignoreCase = true) && years > 3 -> 0.15
        deptCode.equals("FIN", ignoreCase = true) && years > 4 -> 0.18
        else -> 0.10
    }
    return salary * percentage
}

fun calculateDigitAverage() {
    print("Enter an integer: ")
    val input = readLine() ?: "0"
    val number = input.toIntOrNull() ?: 0
    val absNum = kotlin.math.abs(number)
    var temp = absNum
    var sum = 0
    var count = 0
    
    if (temp == 0) {
        sum = 0
        count = 1
    } else {
        while (temp > 0) {
            sum += temp % 10
            temp /= 10
            count++
        }
    }
    
    val average = if (count > 0) sum.toDouble() / count else 0.0
    println("Average of digits for $number: $average")
}

fun main() {
    println("Hello Kotlin!!!")
    println()

    val dept = "IT"
    val years = 6
    val salary = 60000.0
    val bonus = calculateBonus(dept, years, salary)
    println("Department: $dept")
    println("Experience: $years years")
    println("Base Salary: $salary")
    println("Computed Bonus: $bonus")
    println()

    calculateDigitAverage()
}
