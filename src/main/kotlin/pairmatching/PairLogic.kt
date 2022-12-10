package pairmatching


import camp.nextstep.edu.missionutils.Randoms
import java.io.BufferedReader
import java.io.File
import java.io.FileReader


class PairLogic(private val optionsList: List<String>) {

    private fun returnFilePath(): File = File(checkIsItBackOrFrontAndReturnPath(optionsList[0]))

    fun returnPairList(): PairType {
        return PairType(
            optionsList[0],
            optionsList[1],
            optionsList[2],
            translateListToPair(getCrewListFromFile(returnFilePath()))
        )
    }

    fun returnRematchPairList(legacyList: MutableList<MutableList<String>>): Any {
        for(i in 0 until 3) {
            val checkResult = checkItCauseError(translateListToPair(getCrewListFromFile(returnFilePath())), legacyList)
            if(checkResult.first) {
                return checkResult.second
            }
        }
        return PairType(optionsList[0], optionsList[1], optionsList[2], legacyList)
    }

    private fun checkItCauseError(notSureList: MutableList<MutableList<String>>, legacyList: MutableList<MutableList<String>>): Pair<Boolean, Any> {
        return if (!checkIsThereSame(legacyList, notSureList)) {
            Pair(true, PairType(optionsList[0], optionsList[1], optionsList[2], notSureList))
        } else {
            Pair(false, "ERROR")
        }
    }


    private fun checkIsItBackOrFrontAndReturnPath(course: String): String {
        return if (Course.FRONTEND.returnCourseName() == course) {
            Course.FRONTEND.returnCourseFilePath()
        } else {
            Course.BACKEND.returnCourseFilePath()
        }
    }

    private fun getCrewListFromFile(crewListPath: File): List<String> {
        val mCrewList = mutableListOf<String>()
        val bufferReader = BufferedReader(FileReader(crewListPath.absolutePath))
        var crewName: String?
        while (bufferReader.readLine().also { crewName = it } != null) {
            mCrewList.add(crewName!!)
        }
        bufferReader.close()
        return Randoms.shuffle(mCrewList)
    }

    private fun translateListToPair(crewList: List<String>): MutableList<MutableList<String>> {
        val pairList = mutableListOf<MutableList<String>>()
        if (crewList.size % 2 == 0) {
            pairList.addToPairList(crewList)
        }
        if (crewList.size % 2 == 1) {
            pairList.addToPairWithTriple(crewList)
        }
        return pairList
    }

    private fun checkIsThereSame(
        legacyList: MutableList<MutableList<String>>,
        newList: MutableList<MutableList<String>>
    ): Boolean {
        return legacyList.sortList(newList)
    }

    private fun MutableList<MutableList<String>>.sortList(newList: MutableList<MutableList<String>>): Boolean {
        return this.any { legacy -> newList.any { new -> new == legacy || new == legacy.sorted() } }
    }

    private fun MutableList<MutableList<String>>.addToPairList(crewList: List<String>): MutableList<MutableList<String>> {
        for (i in crewList.indices step 2) {
            this.add(mutableListOf(crewList[i], crewList[i + 1]))
        }
        return this
    }

    private fun MutableList<MutableList<String>>.addToPairWithTriple(crewList: List<String>): MutableList<MutableList<String>> {
        for (i in 0 until crewList.size - 3 step 2) {
            this.add(mutableListOf(crewList[i], crewList[i + 1]))
        }
        this.addTripleToList(crewList)
        return this
    }

    private fun MutableList<MutableList<String>>.addTripleToList(crewList: List<String>): MutableList<MutableList<String>> {
        this.add(mutableListOf(crewList[crewList.size - 3], crewList[crewList.size - 2], crewList[crewList.size - 1]))
        return this
    }
}