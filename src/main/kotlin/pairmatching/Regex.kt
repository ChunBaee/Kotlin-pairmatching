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

    private fun checkFunctionSelectInputLength(userInput : String) {
        if(userInput.length != 1) throw IllegalArgumentException("LEN")
    }

    private fun checkFunctionSelectInputIsRight(userInput: String) {
        if(!Pattern.matches("^[1-3]*$", userInput) && userInput != "Q") throw IllegalArgumentException("REG")
    }
}