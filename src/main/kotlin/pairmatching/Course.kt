package pairmatching

enum class Course (private val course : String, private val filePath : String) {
    BACKEND("백엔드", "src/main/resources/backend-crew.md"), FRONTEND("프론트엔드", "src/main/resources/frontend-crew.md");

    fun returnCourseName() = course
    fun returnCourseFilePath() = filePath
}