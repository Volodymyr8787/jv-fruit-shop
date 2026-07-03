package core.converter;

import core.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String[] splits = lines.get(i).split(",");
            FruitTransaction.Operation currentOperation =
                    FruitTransaction.Operation.fromCode(splits[0]);
            int quantity = Integer.parseInt(splits[2]);
            String fruit = splits[1];
            FruitTransaction transaction = new FruitTransaction(currentOperation, fruit, quantity);
            transactions.add(transaction);
        }
        return transactions;
    }
}
