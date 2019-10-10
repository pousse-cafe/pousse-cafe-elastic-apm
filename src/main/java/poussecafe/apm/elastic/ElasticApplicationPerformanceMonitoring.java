package poussecafe.apm.elastic;

import co.elastic.apm.api.ElasticApm;
import co.elastic.apm.api.Transaction;
import poussecafe.apm.ApplicationPerformanceMonitoring;

public class ElasticApplicationPerformanceMonitoring implements ApplicationPerformanceMonitoring {

    @Override
    public ElasticApmTransaction startTransaction(String name) {
        Transaction transaction = ElasticApm.startTransaction();
        transaction.setName(name);
        transaction.setType("message");
        return new ElasticApmTransaction(transaction);
    }
}
