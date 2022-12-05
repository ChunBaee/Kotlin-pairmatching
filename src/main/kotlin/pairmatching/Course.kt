package pairmatching

enum class Course (private val course : String) {
    BACKEND("백엔드"), FRONTEND("프론트엔드");

    fun returnCourseName() = course
}