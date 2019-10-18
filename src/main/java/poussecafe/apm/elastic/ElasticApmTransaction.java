package poussecafe.apm.elastic;

import co.elastic.apm.api.Scope;
import co.elastic.apm.api.Transaction;
import java.util.Optional;
import poussecafe.apm.ApmTransaction;


public class ElasticApmTransaction extends ElasticApmSpan implements ApmTransaction {

    public ElasticApmTransaction(Transaction transaction, Optional<Scope> scope) {
        super(transaction);
        this.transaction = transaction;
        this.scope = scope;
    }

    private Transaction transaction;

    private Optional<Scope> scope;

    @Override
    public void setResult(String result) {
        transaction.setResult(result);
    }

    @Override
    public void addLabel(String key, String value) {
        transaction.addLabel(key, value);
    }

    @Override
    public void end() {
        super.end();
        if(scope.isPresent()) {
            scope.get().close();
        }
    }
}
