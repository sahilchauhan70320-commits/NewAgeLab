class Student(val id: Int, val name: String, val course: String, val percentage: Double)

fun main() {
    println("=== 1. COLLECTIONS (READ-ONLY & MUTABLE) ===")
    val readOnlyList = listOf("Apple", "Banana", "Cherry")
    val mutableList = mutableListOf("Dog", "Cat")
    mutableList.add("Rabbit")
    mutableList.remove("Cat")
    println("List get index 1: ${mutableList[1]}")
    println("List contains 'Dog': ${mutableList.contains("Dog")}")
    println("Mutable List: $mutableList")
    println("Read-only List: $readOnlyList\n")

    val readOnlySet = setOf(1, 2, 3)
    val mutableSet = mutableSetOf(10, 20)
    mutableSet.add(30)
    mutableSet.remove(10)
    println("Set contains 20: ${mutableSet.contains(20)}")
    println("Mutable Set: $mutableSet")
    println("Read-only Set: $readOnlySet\n")

    val readOnlyMap = mapOf(1 to "One", 2 to "Two")
    val mutableMap = mutableMapOf("a" to 1, "b" to 2)
    mutableMap["c"] = 3
    mutableMap.remove("a")
    println("Map get 'b': ${mutableMap["b"]}")
    println("Map contains key 'c': ${mutableMap.containsKey("c")}")
    println("Mutable Map: $mutableMap")
    println("Read-only Map: $readOnlyMap\n")

    println("=== 2. FUNCTIONAL TRANSFORMATIONS ===")
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println("Original: $numbers")
    
    val filtered = numbers.filter { it % 2 == 0 }
    println("After filter (evens): $filtered")
    
    val mapped = filtered.map { it * it }
    println("After map (squares): $mapped")
    
    val reduced = mapped.reduce { acc, i -> acc + i }
    println("After reduce (sum): $reduced\n")

    println("=== 3. SORTING AND GROUPING OBJECTS ===")
    val students = listOf(
        Student(1, "Alice", "CS", 85.5),
        Student(2, "Bob", "IT", 92.0),
        Student(3, "Charlie", "CS", 78.0),
        Student(4, "Diana", "IT", 88.5),
        Student(5, "Eve", "ECE", 95.0)
    )

    val sortedStudents = students.sortedByDescending { it.percentage }
    println("Students sorted by percentage (descending):")
    for (s in sortedStudents) {
        println("${s.name} - ${s.percentage}%")
    }
    println()

    val groupedByCourse = students.groupBy { it.course }
    println("Students grouped by course:")
    for ((course, group) in groupedByCourse) {
        println("Course: $course -> ${group.map { it.name }}")
    }
}
