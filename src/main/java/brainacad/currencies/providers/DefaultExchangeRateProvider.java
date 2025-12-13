package brainacad.currencies.providers;

import java.util.HashMap;
import java.util.Map;

public class DefaultExchangeRateProvider implements ExchangeRateProvider {
    @Override
    public Map<String, Double> getExchangeRates() {
        Map<String, Double> rates = new HashMap<>();
        rates.put("USD", 1.0);
        rates.put("EUR", 0.85);
        rates.put("GBP", 0.75);
        rates.put("JPY", 110.0);
        return rates;
    }
}

