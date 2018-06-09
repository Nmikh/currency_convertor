import com.currency_converter.CurrencyConverter;
import com.exceptions.AmountException;
import com.exceptions.CurrencyException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

@RunWith(JUnit4.class)
public class ExceptionTest {
    CurrencyConverter currencyConverter;

    @Before
    public void initClass() {
        this.currencyConverter = new CurrencyConverter();
    }

    @Test(expected = CurrencyException.class)
    public void test1() throws CurrencyException, AmountException, IOException {
        currencyConverter.convert(1,"djdkjdk");
    }

    @Test(expected = AmountException.class)
    public void test2() throws CurrencyException, AmountException, IOException {
        currencyConverter.convert(-1,"UAH");
    }

    @Test(expected = AmountException.class)
    public void test3() throws CurrencyException, AmountException, IOException {
        currencyConverter.convert(-1,"UAdddhfjdhfj");
    }

}
