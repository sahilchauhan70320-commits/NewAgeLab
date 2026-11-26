fun printEmployeeDetails(name: String = "Unknown", department: String = "General", salary: Double = 30000.0) {
    println("Name: $name, Dept: $department, Salary: $salary")
}

fun printNumbers(vararg numbers: Int) {
    print("Vararg numbers: ")
    for (n in numbers) {
        print("$n ")
    }
    println()
}

fun applyTransform(numbers: List<Int>, transform: (Int) -> Int): List<Int> {
    val result = mutableListOf<Int>()
    for (n in numbers) {
        result.add(transform(n))
    }
    return result
}

fun main() {
    printEmployeeDetails()
    printEmployeeDetails("Bob", "HR", 45000.0)
    printEmployeeDetails(salary = 60000.0, department = "IT", name = "Charlie")
    println()

    printNumbers(1, 2, 3, 4, 5)
    printNumbers(10, 20)
    println()

    val list = listOf(1, 2, 3, 4)
    val squared = applyTransform(list) { it * it }
    println("Original list: $list")
    println("Transformed list: $squared")
}
