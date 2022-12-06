package pairmatching


import camp.nextstep.edu.missionutils.Randoms
import java.io.BufferedReader
import java.io.File
import java.io.FileReader


class PairLogic(private val optionsList: List<String>) {

    fun shufflePairList() {
        var crewList = mutableListOf<String>()

        val crewListPath = File(
            if (Course.FRONTEND.returnCourseName() == optionsList[0]) {
                Course.FRONTEND.returnCourseFilePath()
            } else {
                Course.BACKEND.returnCourseFilePath()
            }
        )
        val bufferReader = BufferedReader(FileReader(crewListPath.absolutePath))
        var crewName: String?
        while (bufferReader.readLine().also { crewName = it } != null) {
            crewList.add(crewName!!)
        }
        bufferReader.close()
    }
}