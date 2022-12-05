package pairmatching

enum class Functions (private val number : String, private val title : String) {
    FUN1("1", "페어 매칭"), FUN2("2", "페어 조회"), FUN3("3", "페어 초기화"), FUN4("Q", "종료");

    fun returnNumber() = number
    fun returnTitle() = title
}