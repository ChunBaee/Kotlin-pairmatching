package pairmatching


import camp.nextstep.edu.missionutils.Randoms
import java.io.BufferedReader
import java.io.File
import java.io.FileReader


class PairLogic(private val optionsList: List<String>) {

    fun returnPairList() : PairType {
        val crewListPath = File(checkIsItBackOrFrontAndReturnPath(optionsList[0]))
        return PairType(optionsList[0],optionsList[1],optionsList[2],translateListToPair(getCrewListFromFile(crewListPath)))
    }

    private fun checkIsItBackOrFrontAndReturnPath(course : String) : String{
        return if (Course.FRONTEND.returnCourseName() == course) {
            Course.FRONTEND.returnCourseFilePath()
        } else {
            Course.BACKEND.returnCourseFilePath()
        }
    }

    private fun getCrewListFromFile(crewListPath : File) : List<String> {
        var mCrewList = mutableListOf<String>()
        val bufferReader = BufferedReader(FileReader(crewListPath.absolutePath))
        var crewName: String?
        while (bufferReader.readLine().also { crewName = it } != null) {
            mCrewList.add(crewName!!)
        }
        bufferReader.close()
        return Randoms.shuffle(mCrewList)
    }

    private fun translateListToPair(crewList : List<String>) : MutableList<MutableList<String>> {
        val pairList = mutableListOf<MutableList<String>>()
        if(crewList.size % 2 == 0) {
            for (i in crewList.indices step 2) {
                pairList.add(mutableListOf(crewList[i], crewList[i + 1]))
            }
        }
        if(crewList.size % 2 == 1) {
            for(i in 0 until crewList.size - 3 step 2) {
                pairList.add(mutableListOf(crewList[i], crewList[i + 1]))
            }
            pairList.add(mutableListOf(crewList[crewList.size - 3], crewList[crewList.size - 2], crewList[crewList.size - 1]))
        }
        PrintForm().printPairMatchingResult(pairList)
        return pairList
    }
}