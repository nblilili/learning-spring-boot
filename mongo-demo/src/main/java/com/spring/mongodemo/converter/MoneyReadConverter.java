package com.spring.mongodemo.converter;

import org.bson.Document;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.core.convert.converter.Converter;

/**
 * @author nblilili@163.com
 * @date 2020/1/15 16:18
 */
public class MoneyReadConverter implements Converter<Document, Money> {

    /**
     * 用于转换Document和money
     * @param document
     * @return
     */
    @Override
    public Money convert(Document document) {
        Document money = (Document) document.get("money");
        double amount = Double.parseDouble(money.getString("amount"));
        String currency = ((Document) money.get("currency")).getString("code");
        return Money.of(CurrencyUnit.of(currency), amount);
    }
}
