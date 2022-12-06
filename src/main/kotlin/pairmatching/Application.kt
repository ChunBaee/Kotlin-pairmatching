package pairmatching

fun main() {
    runMatchingProgram()
}

private fun runMatchingProgram() {
    val userFunctionInput = UserInput().userSelectFunction()
    functionInputBranchProcess(userFunctionInput)
}

private fun functionInputBranchProcess(userFunctionInput : String) {
    if(userFunctionInput == Functions.FUN4.returnNumber()) {
        //종료
    }
    functionInputBranchNotQuitProcess(userFunctionInput)
}

private fun functionInputBranchNotQuitProcess(userFunctionInput: String) {
    if(userFunctionInput == Functions.FUN1.returnNumber()) {
        PrintForm().printProcessAndMission()
        UserInput().userInputProcessLevelClass()
    }
    if(userFunctionInput == Functions.FUN2.returnNumber()) {
        PrintForm().printProcessAndMission()
        UserInput().userInputProcessLevelClass()
    }
    if(userFunctionInput == Functions.FUN3.returnNumber()) {
        //초기화
    }

}
