import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat
import com.example.tipcalculatorapp.calculateTip

class TipCalculatorTests {

    @Test
    fun calculateTip_20PercentNoRoundup(): Unit {
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, false)
        assertEquals(expectedTip, actualTip)
    }

}
