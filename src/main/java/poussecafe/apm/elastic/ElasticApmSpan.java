package poussecafe.apm.elastic;

import co.elastic.apm.api.Span;
import java.util.Objects;
import poussecafe.apm.ApmSpan;


public class ElasticApmSpan implements ApmSpan {

    public ElasticApmSpan(Span span) {
        Objects.requireNonNull(span);
        this.span = span;
    }

    private Span span;

    @Override
    public void setName(String name) {
        span.setName(name);
    }

    @Override
    public void captureException(Throwable e) {
        span.captureException(e);
    }

    @Override
    public void end() {
        span.end();
    }

    @Override
    public ApmSpan startSpan() {
        return new ElasticApmSpan(span.startSpan());
    }
}
