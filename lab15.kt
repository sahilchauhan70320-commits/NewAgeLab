data class Student(
    val id: Int,
    val name: String,
    val email: String?
)

data class Course(
    val courseId: Int,
    val title: String,
    val fee: Double,
    val instructor: String?
)

data class Registration(
    val student: Student,
    val course: Course,
    val grade: Double?
)
fun Student.hasEmail(): Boolean {
    return !email.isNullOrBlank()
}

fun Course.discountedFee(discount: Double): Double {
    require(discount in 0.0..100.0)
    return fee - (fee * discount / 100)
}
class CourseBuilder {
    var courseId: Int = 0
    var title: String = ""
    var fee: Double = 0.0
    var instructor: String? = null

    fun build(): Course {
        require(courseId > 0) { "Invalid course ID" }
        require(title.isNotBlank()) { "Course title is required" }
        require(fee >= 0) { "Invalid course fee" }

        return Course(courseId, title, fee, instructor)
    }
}
fun course(block: CourseBuilder.() -> Unit): Course {
    val builder = CourseBuilder()
    builder.block()
    return builder.build()
}
fun main() {
    println("   COURSE REGISTRATION SYSTEM:")

    val student1 = Student(1, "Rahul", "rahul@gmail.com")
    val student2 = Student(2, "Priya", null)
    val student3 = Student(3, "Aman", "aman@gmail.com")

    val course1 = Course(101, "Kotlin Programming", 3000.0, "Mr. Sharma")
    val course2 = Course(102, "Android Development", 4000.0, "Ms. Verma")
    val course3 = Course(103, "Database Management", 2500.0, null)

    val registrations = listOf(
        Registration(student1, course1, 90.0),
        Registration(student2, course1, 75.0),
        Registration(student3, course2, 85.0),
        Registration(student1, course3, null),
        Registration(student2, course2, 60.0)
    )
    println("\n--- NULL SAFETY ---")

    registrations.forEach {
        println("Student: ${it.student.name}")
        println("Email: ${it.student.email ?: "Not available"}")
        println("Instructor: ${it.course.instructor ?: "Not assigned"}")
        println("Grade: ${it.grade?.toString() ?: "Pending"}")
    }
    println("\n--- MAP: COURSE NAMES ---")

    val courseNames = registrations.map {
        it.course.title
    }

    println(courseNames)

    println("\n--- FILTER: STUDENTS SCORING ABOVE 70 ---")

    val passedStudents = registrations.filter {
        (it.grade ?: 0.0) > 70
    }

    passedStudents.forEach {
        println(it.student.name + " - " + it.grade)
    }

    println("\n--- REDUCE: TOTAL REGISTRATION FEES ---")

    val totalFees = registrations
        .map { it.course.fee }
        .reduce { total, fee -> total + fee }

    println("Total fees: Rs. $totalFees")

    println("\n--- GROUP BY: STUDENTS PER COURSE ---")

    val groupedCourses = registrations.groupBy {
        it.course.title
    }

    groupedCourses.forEach { (courseName, records) ->
        println("$courseName:")
        records.forEach {
            println("  ${it.student.name}")
        }
    }

    println("\n--- EXTENSION FUNCTIONS ---")

    println("${student1.name} has email: ${student1.hasEmail()}")
    println("${student2.name} has email: ${student2.hasEmail()}")

    println(
        "Kotlin course after 10% discount: " +
        course1.discountedFee(10.0)
    )

    println(
        "Android course after 15% discount: " +
        course2.discountedFee(15.0)
    )

    println("\n--- COURSE DSL ---")

    val newCourse = course {
        courseId = 104
        title = "Advanced Kotlin"
        fee = 5000.0
        instructor = "Mr. Kumar"
    }

    println("New course created:")
    println(newCourse)
}
