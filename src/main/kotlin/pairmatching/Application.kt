package pairmatching

fun main() {
    runMatchingProgram()
}

private fun runMatchingProgram() {
    while(true) {
        val userFunctionInput = UserInput().userSelectFunction()
        if (functionInputBranchProcess(userFunctionInput) == "Q") {
            break
        }
    }
}

private fun functionInputBranchProcess(userFunctionInput : String) : Any {
    if(userFunctionInput != Functions.FUN4.returnNumber()) {
        functionInputBranchNotQuitProcess(userFunctionInput)
    }
    return userFunctionInput
}

private fun functionInputBranchNotQuitProcess(userFunctionInput: String) {
    if(userFunctionInput == Functions.FUN1.returnNumber()) {
        PrintForm().printProcessAndMission()
        UserInput().userInputProcessLevelClass(Functions.FUN1.returnNumber())
    }
    if(userFunctionInput == Functions.FUN2.returnNumber()) {
        PrintForm().printProcessAndMission()
        UserInput().userInputProcessLevelClass(Functions.FUN2.returnNumber())
    }
    if(userFunctionInput == Functions.FUN3.returnNumber()) {
        //초기화
    }

}
