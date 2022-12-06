package pairmatching

import kotlin.Pair

data class Pair(
    val targetCourse : String,
    val targetLevel : String,
    val targetClass : String,
    var pairList : MutableList<Pair<String, String>>
)
