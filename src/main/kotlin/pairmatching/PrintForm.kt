package pairmatching

import kotlin.Pair

class PrintForm {

    fun printFunctionList() {
        println("기능을 선택하세요.")
        for (i in Functions.values()) {
            println("${i.returnNumber()}. ${i.returnTitle()}")
        }
    }

    fun printProcessAndMission() {
        printDividerLines()
        printProcess()
        printDividerLines()
    }

    private fun printDividerLines() {
        for (i in 0 until 30) print("#")
        println("")
    }

    private fun printProcess() {
        print("과정: ${returnEnumNames(0)}\n")
        println("미션: ")
        returnEnumNames(1)
    }

    private fun returnEnumNames(type: Int): Any {
        return when (type) {
            0 -> returnCourseEnumNameList()
            1 -> printLevelAndClass()
            else -> {"1"}
        }
    }

    private fun returnCourseEnumNameList() : String {
        val courseList = mutableListOf<String>()
        for (course in Course.values()) {
            courseList.add(course.returnCourseName())
        }
        return courseList.joinToString(" | ")
    }


    private fun printLevelAndClass() {
        for(level in Level.values()) {
            println(" - ${level.returnLevelName()}: ${returnClassEnumNameList(level.returnLevelName())}")
        }
    }

    private fun returnClassEnumNameList(level : String) : String {
        val classList = mutableListOf<String>()
        for(mClass in Class.values().filter { it.returnLevel() == level }) {
            classList.add(mClass.returnClassName())
        }
        return classList.joinToString(" | ")
    }

    fun printNoticeInputProcessLevelClass() {
        println("과정, 레벨, 미션을 선택하세요.")
        println("ex) 백엔드, 레벨1, 자동차경주")
    }

    fun printPairMatchingResult (pairList : MutableList<MutableList<String>>) {
        println("페어 매칭 결과입니다.")
        for(pair in pairList) {
            println(pair.joinToString(" : "))
        }
    }

}
