package poussecafe.apm.elastic;

import co.elastic.apm.api.ElasticApm;
import co.elastic.apm.api.Transaction;
import java.util.Optional;
import poussecafe.apm.ApmSpan;
import poussecafe.apm.ApplicationPerformanceMonitoring;

public class ElasticApplicationPerformanceMonitoring implements ApplicationPerformanceMonitoring {

    @Override
    public ElasticApmTransaction startTransaction(String name) {
        Transaction transaction = ElasticApm.startTransaction();
        transaction.setName(name);
        transaction.setType("message");
        return new ElasticApmTransaction(transaction, Optional.of(transaction.activate()));
    }

    @Override
    public ApmSpan currentSpan() {
        return new ElasticApmSpan(ElasticApm.currentTransaction());
    }
}
