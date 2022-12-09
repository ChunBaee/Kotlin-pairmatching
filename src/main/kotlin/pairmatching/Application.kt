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
    if (userFunctionInput != Functions.FUN4.returnNumber()) {
        functionInputBranchNotQuitProcess(userFunctionInput)
    }
    return userFunctionInput
}

private fun functionInputBranchNotQuitProcess(userFunctionInput: String) {
    if (userFunctionInput == Functions.FUN1.returnNumber()) {
        PrintForm().printProcessAndMission()
        divideIsItMatchingOrWatch(Functions.FUN1.returnNumber(), UserInput().userInputProcessLevelClass())
    }
    if (userFunctionInput == Functions.FUN2.returnNumber()) {
        PrintForm().printProcessAndMission()
        divideIsItMatchingOrWatch(Functions.FUN2.returnNumber(), UserInput().userInputProcessLevelClass())
    }
    if (userFunctionInput == Functions.FUN3.returnNumber()) {
        //초기화
    }

}

private fun divideIsItMatchingOrWatch(type: String, optionList: List<String>) {
    if (type == Functions.FUN1.returnNumber() && !isThereAlreadyMatchingInfo(optionList)) {
        addToPairList(PairLogic(optionList).returnPairList())
    }
    if(type == Functions.FUN1.returnNumber() && isThereAlreadyMatchingInfo(optionList)) {
        PrintForm().
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