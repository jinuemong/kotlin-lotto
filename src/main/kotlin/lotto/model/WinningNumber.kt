package lotto.model

class WinningNumber(
    private val lotto: Lotto,
    private val bonusNumber: BonusNumber,
) {

    fun getWinning(): Lotto {
        return lotto
    }

    fun getBonusNumber(): Int {
        return bonusNumber.getBonusNumber()
    }
}
