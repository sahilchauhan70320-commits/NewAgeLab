class Student(var rollNo: Int, var name: String, var course: String, var percentage: Double) {
    fun updateData() {
        print("Enter new Roll No: ")
        rollNo = readLine()?.toIntOrNull() ?: rollNo
        print("Enter new Name: ")
        name = readLine() ?: name
        print("Enter new Course: ")
        course = readLine() ?: course
        print("Enter new Percentage: ")
        percentage = readLine()?.toDoubleOrNull() ?: percentage
    }

    fun display() {
        println("Roll No: $rollNo")
        println("Name: $name")
        println("Course: $course")
        println("Percentage: $percentage%")
        println()
    }
}

fun main() {
    val student1 = Student(101, "Alice Smith", "Computer Science", 88.5)
    val student2 = Student(102, "Bob Jones", "Information Technology", 76.0)

    println("Initial Details of Student 1:")
    student1.display()

    println("Initial Details of Student 2:")
    student2.display()

    println("Update Student 1 Details:")
    student1.updateData()

    println("\nUpdated Details of Student 1:")
    student1.display()
}
