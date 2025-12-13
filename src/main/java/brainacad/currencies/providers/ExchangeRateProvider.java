package brainacad.currencies.providers;

import java.util.Map;

public interface ExchangeRateProvider {
    Map<String, Double> getExchangeRates();
}

