package pairmatching

import camp.nextstep.edu.missionutils.Console

class UserInput {

    fun userSelectFunction() : String {
        var functionInput = ""
        var isCorrect = false
        while(!isCorrect) {
            PrintForm().printFunctionList()
            functionInput = Console.readLine()
            isCorrect = Regex().checkFunctionSelectRegex(functionInput)
        }
        return functionInput
    }

    fun userInputProcessLevelClass(type : String) {
        var isCorrect = false
        var userInput = ""
        while(!isCorrect) {
            PrintForm().printNoticeInputProcessLevelClass()
            userInput = Console.readLine()
            isCorrect = Regex().checkCourseLevelClassRegex(userInput)
        }
        divideIsItMatchingOrWatch(type, userInput.trim().split(","))
    }

    private fun divideIsItMatchingOrWatch(type : String, optionList : List<String>) {
        if(type == Functions.FUN1.returnNumber()) {
            println("PAIR")
            PairLogic(optionList).shufflePairList()
        }
        if(type == Functions.FUN2.returnNumber()) {
            //조회 로직
        }
    }
}