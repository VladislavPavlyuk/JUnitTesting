package brainacad.currencies.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CurrencyConverter {
    private final Map<String, Double> exchangeRates;

    public CurrencyConverter() {
        exchangeRates = new HashMap<>();
        // Установим фиксированные курсы валют относительно USD
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.75);
        exchangeRates.put("JPY", 110.0);
    }

    public double convert(String fromCurrency, String toCurrency, double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if (fromCurrency == null || toCurrency == null) {
            throw new IllegalArgumentException("Currency codes cannot be null");
        }
        
        String from = fromCurrency.toUpperCase();
        String to = toCurrency.toUpperCase();
        
        if (from.equals(to)) {
            return amount;
        }
        
        if (!exchangeRates.containsKey(from) || !exchangeRates.containsKey(to)) {
            throw new IllegalArgumentException("Invalid currency code");
        }
        
        double rateFrom = exchangeRates.get(from);
        double rateTo = exchangeRates.get(to);
        return amount * (rateTo / rateFrom);
    }

    public double getExchangeRate(String currency) {
        if (currency == null) {
            throw new IllegalArgumentException("Currency code cannot be null");
        }
        String upperCurrency = currency.toUpperCase();
        if (!exchangeRates.containsKey(upperCurrency)) {
            throw new IllegalArgumentException("Invalid currency code: " + currency);
        }
        return exchangeRates.get(upperCurrency);
    }

    public Set<String> getSupportedCurrencies() {
        return exchangeRates.keySet();
    }

    public boolean isCurrencySupported(String currency) {
        if (currency == null) {
            return false;
        }
        return exchangeRates.containsKey(currency.toUpperCase());
    }
}
