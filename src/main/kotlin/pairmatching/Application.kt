package pairmatching

private var mPairList = mutableListOf<PairType>()

fun main() {
    runMatchingProgram()
}

private fun runMatchingProgram() {
    while (true) {
        val userFunctionInput = UserInput().userSelectFunction()
        if (functionInputBranchProcess(userFunctionInput) == "Q") {
            break
        }
    }
}

private fun functionInputBranchProcess(userFunctionInput: String): Any {
    if (userFunctionInput == Functions.FUN1.returnNumber() || userFunctionInput == Functions.FUN2.returnNumber()) {
        PrintForm().printProcessAndMission()
        functionInputBranchNotQuitProcess(userFunctionInput)
    }
    if(userFunctionInput == Functions.FUN3.returnNumber()) {
        resetPairList()
    }
    return userFunctionInput
}

private fun functionInputBranchNotQuitProcess(userFunctionInput: String) {
    if (userFunctionInput == Functions.FUN1.returnNumber()) {
        divideIsItMatchingOrWatch(Functions.FUN1.returnNumber(), UserInput().userInputProcessLevelClass())
    }
    if (userFunctionInput == Functions.FUN2.returnNumber()) {
        divideIsItMatchingOrWatch(Functions.FUN2.returnNumber(), UserInput().userInputProcessLevelClass())
    }
}

private fun resetPairList() {

}

private fun divideIsItMatchingOrWatch(type: String, optionList: List<String>) {
    if(type == Functions.FUN1.returnNumber() && isThereAlreadyMatchingInfo(optionList)) {
        if(UserInput().userInputWannaRematch()) {
            println("리매치하기")
        } else {
            functionInputBranchNotQuitProcess(Functions.FUN1.returnNumber())
        }
    }
    if (type == Functions.FUN1.returnNumber() && !isThereAlreadyMatchingInfo(optionList)) {
        addToPairList(PairLogic(optionList).returnPairList())
    }
    if (type == Functions.FUN2.returnNumber()) {
        println(mPairList)
        mPairList.find { it.targetCourse == optionList[0] && it.targetLevel == optionList[1] && it.targetClass == optionList[2] }?.pairList?.let {
            PrintForm().printPairMatchingResult(
                it
            )
        }
    }
}

private fun addToPairList(mPair : PairType) {
    mPairList.add(mPair)
}

private fun isThereAlreadyMatchingInfo(optionList: List<String>) : Boolean {
    return mPairList.any { it.targetCourse == optionList[0] && it.targetLevel == optionList[1] && it.targetClass == optionList[2]}
}