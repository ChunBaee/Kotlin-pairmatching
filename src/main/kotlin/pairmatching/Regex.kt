package pairmatching

import java.util.regex.Pattern

class Regex {

    fun checkFunctionSelectRegex(userInput: String) : Boolean {
        return try {
            checkFunctionSelectInputLength(userInput)
            checkFunctionSelectInputIsRight(userInput)
            true
        } catch (exception : IllegalArgumentException) {
            println(exception.message)
            false
        }
    }

    fun checkCourseLevelClassRegex(userInput : String) : Boolean {
        return try {
            divideCourseLevelMission(userInput)
            true
        } catch (exception : IllegalArgumentException) {
            println(exception.message)
            false
        }
    }

    fun checkUserWannaRematchRegex(userInput: String) : Boolean {
        return try {
            checkWannaRematch(userInput)
            true
        } catch (exception : IllegalArgumentException) {
            println(exception.message)
            false
        }
    }
    private fun checkFunctionSelectInputLength(userInput : String) {
        if(userInput.length != 1) throw IllegalArgumentException("LEN")
    }

    private fun checkFunctionSelectInputIsRight(userInput: String) {
        if(!Pattern.matches("^[1-3]*$", userInput) && userInput != "Q") throw IllegalArgumentException("REG")
    }

    private fun divideCourseLevelMission(userInput: String) {
        val totalList = userInput.split(",").filter { it != "" }
        checkIsItHaveRightSize(totalList)
        checkIsRightCourse(totalList[0])
        checkIsRightLevelAndClass(totalList[1], totalList[2])
    }

    private fun checkIsItHaveRightSize(totalList : List<String>) {
        if(totalList.size != 3) throw IllegalArgumentException()
    }

    private fun checkIsRightCourse(inputCourse : String) {
        if(!Course.values().any { it.returnCourseName() == inputCourse }) throw IllegalArgumentException("COU")
    }

    private fun checkIsRightLevelAndClass(inputLevel : String, inputClass : String) {
        if(!Class.values().any{ it.returnClassName() == inputClass.trim() && it.returnLevel() == inputLevel.trim()}) throw IllegalArgumentException("CLA")
    }

    private fun checkWannaRematch(inputWannaRematch : String) {
        if(inputWannaRematch != "네" && inputWannaRematch != "아니오") throw IllegalArgumentException()
    }
}