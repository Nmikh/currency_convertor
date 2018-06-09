import com.currency_converter.CurrencyConverter;
import com.exceptions.AmountException;
import com.exceptions.CurrencyException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

@RunWith(JUnit4.class)
public class CorrectConverterTest {
    CurrencyConverter currencyConverter;

    @Before
    public void initClass() {
        this.currencyConverter = new CurrencyConverter();
    }

    @Test
    public void test() throws AmountException, CurrencyException, IOException {
        double uah = currencyConverter.convert(12.23, "UAH");
        Assert.assertNotEquals(uah, null);

        double gbp = currencyConverter.convert(12.23, "GBP");
        Assert.assertNotEquals(gbp, null);

        double eur = currencyConverter.convert(12.23, "EUR");
        Assert.assertNotEquals(eur, null);

    }

}
