package pairmatching

data class PairType(
    val targetCourse : String,
    val targetLevel : String,
    val targetClass : String,
    var pairList : MutableList<MutableList<String>>
)
