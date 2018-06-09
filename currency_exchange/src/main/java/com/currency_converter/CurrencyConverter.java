package com.currency_converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.net.URL;
import java.nio.charset.Charset;

import com.exceptions.AmountException;
import com.exceptions.CurrencyException;
import org.json.JSONException;
import org.json.JSONObject;

public class CurrencyConverter {

    private static String URL = "http://apilayer.net/api/live?access_key=ce1d8daf96dc07345707251b06be2806";

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public double convert(double amount, String currency) throws CurrencyException, AmountException, IOException {
        if (amount >= 0) {
            JSONObject json = readJsonFromUrl(URL);
            JSONObject quotes = json.getJSONObject("quotes");
            MathContext mc = new MathContext(4);
            if (currency.equals("UAH")) {
                BigDecimal decimal = quotes.getBigDecimal("USDUAH");
                double result = decimal.doubleValue() * amount;
                return Math.round(result * 100.0) / 100.0;
            } else if (currency.equals("GBP")) {
                BigDecimal decimal = quotes.getBigDecimal("USDGBP");
                double result = decimal.doubleValue() * amount;
                return Math.round(result * 100.0) / 100.0;
            } else if (currency.equals("EUR")) {
                BigDecimal decimal = quotes.getBigDecimal("USDEUR");
                double result = decimal.doubleValue() * amount;
                return Math.round(result * 100.0) / 100.0;
            }
            throw new CurrencyException();
        }
        throw new AmountException();
    }
}