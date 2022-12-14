package pairmatching

import camp.nextstep.edu.missionutils.Console

class UserInput {

    fun userSelectFunction() : String {
        var isCorrect = false
        var functionInput = ""
        while(!isCorrect) {
            PrintForm().printFunctionList()
            functionInput = Console.readLine()
            isCorrect = Regex().checkFunctionSelectRegex(functionInput)
        }
        return functionInput
    }

    fun userInputProcessLevelClass() : List<String>{
        var isCorrect = false
        var userInput = ""
        while(!isCorrect) {
            PrintForm().printNoticeInputProcessLevelClass()
            userInput = Console.readLine()
            isCorrect = Regex().checkCourseLevelClassRegex(userInput)
        }
        return userInput.trim().split(",")
    }

    fun userInputWannaRematch() : Boolean{
        var isCorrect = false
        var userInput = ""
        while(!isCorrect) {
            PrintForm().printWannaRematchPair()
            userInput = Console.readLine()
            isCorrect = Regex().checkUserWannaRematchRegex(userInput)
        }
        return userInput == "네"
    }
}