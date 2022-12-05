package pairmatching

class PrintForm {

    fun printFunctionList() {
        println("기능을 선택하세요.")
        for(i in Functions.values()) {
            println("${i.returnNumber()}. ${i.returnTitle()}")
        }
    }
}