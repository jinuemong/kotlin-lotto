import lotto.model.GameException
import lotto.model.Lotto
import lotto.model.LottoNumber
import lotto.model.LottoNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 번호 클래스`() {
        assertThat(Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })).getLottoNumber())
            .isEqualTo((setOf(1, 2, 3, 4, 5, 6)))
    }

    @Test
    fun `로또 번호 개수는 6개 초과`() {
        assertThrows<GameException> {
            Lotto(LottoNumbers(setOf(1, 2, 3, 4, 5, 6, 7).map { LottoNumber(it) }))
        }
    }

    @Test
    fun `로또 번호 개수는 6개 미만`() {
        assertThrows<GameException> {
            Lotto(LottoNumbers(setOf(1, 2, 3, 4, 5).map { LottoNumber(it) }))
        }
    }

    @Test
    fun `로또 번호 1~45 사이`() {
        assertThrows<GameException> {
            Lotto(LottoNumbers(setOf(0, 2, 3, 4, 5, 46).map { LottoNumber(it) }))
        }
    }
}
