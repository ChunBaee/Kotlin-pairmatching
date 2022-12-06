package pairmatching

enum class Class(private val level: String, private val className: String) {
    CAR_RACING("레벨1", "자동차경주"),
    LOTTO("레벨1", "로또"),
    NUMBER_BASEBALL("레벨1", "숫자야구게임"),
    SHOPPING_BAG("레벨2", "장바구니"),
    PAYMENT("레벨2", "결제"),
    METRO_LINES("레벨2", "지하철노선도"),
    PERFORMANCE_IMPROVE("레벨4", "성능개선"),
    RELEASE("레벨4", "배포");

    fun returnLevel() = level
    fun returnClassName() = className
}