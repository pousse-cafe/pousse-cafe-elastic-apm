package poussecafe.apm.elastic;

import co.elastic.apm.api.Transaction;
import java.util.Objects;
import poussecafe.apm.ApmTransaction;


public class ElasticApmTransaction implements ApmTransaction {

    public ElasticApmTransaction(Transaction transaction) {
        Objects.requireNonNull(transaction);
        this.transaction = transaction;
    }

    private Transaction transaction;

    @Override
    public void captureException(Throwable e) {
        transaction.captureException(e);
    }

    @Override
    public void end() {
        transaction.end();
    }

    @Override
    public void setResult(String result) {
        transaction.setResult(result);
    }

    @Override
    public void addLabel(String key, String value) {
        transaction.addLabel(key, value);
    }
}
