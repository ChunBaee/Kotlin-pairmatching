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
    if (userFunctionInput == Functions.FUN3.returnNumber()) {
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
    mPairList = mutableListOf()
    PrintForm().printResetPairList()
}

private fun divideIsItMatchingOrWatch(type: String, optionList: List<String>) {
    if (type == Functions.FUN1.returnNumber()) {
        checkAndDivideIsAlreadyMatched(optionList)
    }
    if (type == Functions.FUN2.returnNumber()) {
        showPairListLogic(optionList)
    }
}

private fun addToPairList(mPair: PairType) {
    mPairList.add(mPair)
    PrintForm().printPairMatchingResult(mPair.pairList)

}

private fun isThereAlreadyMatchingInfo(optionList: List<String>): Boolean {
    return mPairList.any { it.targetCourse == optionList[0] && it.targetLevel == optionList[1] && it.targetClass == optionList[2] }
}

private fun rematchPair(optionList: List<String>) {
    PairLogic(optionList).returnRematchPairList(mPairList.find { it.targetCourse == optionList[0] && it.targetLevel == optionList[1] && it.targetClass == optionList[2] }!!.pairList)
        .let {
            if (it == "ERROR") {
                println("ERROR") //:TODO ERROR 만들기
            } else {
                mPairList.remove(mPairList.find { list -> list.targetCourse == optionList[0] && list.targetLevel == optionList[1] && list.targetClass == optionList[2] })
                addToPairList(it as PairType)
            }
        }
}

private fun showPairListLogic(optionList: List<String>) {
    mPairList.find { it.targetCourse == optionList[0] && it.targetLevel == optionList[1] && it.targetClass == optionList[2] }?.pairList?.let {
        PrintForm().printPairMatchingResult(
            it
        )
    }
}

private fun checkAndDivideIsAlreadyMatched(optionList: List<String>) {
    if (isThereAlreadyMatchingInfo(optionList)) {
        setRematchLogic(optionList)
    }
    if (!isThereAlreadyMatchingInfo(optionList)) {
        addToPairList(PairLogic(optionList).returnPairList())
    }
}

private fun setRematchLogic(optionList: List<String>) {
    if (UserInput().userInputWannaRematch()) {
        rematchPair(optionList)
    } else {
        functionInputBranchNotQuitProcess(Functions.FUN1.returnNumber())
    }
}