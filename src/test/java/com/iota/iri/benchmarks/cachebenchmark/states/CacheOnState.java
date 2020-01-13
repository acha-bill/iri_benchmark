package com.iota.iri.benchmarks.cachebenchmark.states;

import com.iota.iri.controllers.TransactionViewModel;
import com.iota.iri.storage.Tangle;

import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
public class CacheOnState extends DefaultState {

    @Override
    @Setup(Level.Trial)
    public void setup() throws Exception {
        super.setup();
        Tangle tangle = getTangle();
        tangle.setCacheEnabled(true);
        setTangle(tangle);
    }

    @Override
    @TearDown(Level.Trial)
    public void teardown() throws Exception {
        super.teardown();
    }

    @Override
    @TearDown(Level.Iteration)
    public void clearDb() throws Exception {
        super.clearDb();
    }

    @Setup(Level.Iteration)
    public void populateDb() throws Exception {
        System.out.println("-----------------------iteration setup--------------------------------");
        for (TransactionViewModel tvm : getTransactions()) {
            tvm.store(getTangle(), getSnapshotProvider().getInitialSnapshot());
        }
    }
}
