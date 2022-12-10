package pairmatching

enum class Error (private val errorExplain : String) {
    PLEASE_INPUT_RIGHT_FUNCTION("기능 선택을 위한 올바른 문자열을 입력해주세요."), FUNCTION_SELECT_NOT_IN_LENGTH("기능 선택은 1글자로만 이루어져야 합니다."), NOT_EXIST_COURSE("존재하지 않는 과정입니다. 다시 확인해주세요."), NOT_EXIST_CLASS_IN_LEVEL("레벨과 과목에 오류가 있습니다. 다시 확인해주세요."), RECHECK_COURSE_LEVEL_CLASS_INPUT("과정, 레벨, 과목 입력값 중 누락이 있습니다. 다시 확인해주세요."),NOT_GOOD_FOR_REMATCH("재매칭 여부는 '네' 혹은 '아니오' 로만 입력해주세요.");

    fun returnErrorExplain() = errorExplain

    fun selectErrorWithExplain(explain : String) = Error.valueOf(explain)
}