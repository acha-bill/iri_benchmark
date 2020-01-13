package com.iota.iri.benchmarks.cachebenchmark;

import com.iota.iri.benchmarks.cachebenchmark.states.CacheOffState;
import com.iota.iri.benchmarks.cachebenchmark.states.CacheOnState;
import com.iota.iri.controllers.TransactionViewModel;
import com.iota.iri.model.Hash;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openjdk.jmh.annotations.Benchmark;

public class CacheBenchmark {

    @Benchmark
    public void readTransactionsInRandomOrderWithCacheOn(CacheOnState state) throws Exception {
        List<Hash> hashes = state.getTransactions().stream().map(tx -> tx.getHash()).collect(Collectors.toList());
        Collections.shuffle(hashes);
        for (Hash hash : hashes) {
            TransactionViewModel.fromHash(state.getTangle(), hash);
        }
    }

    @Benchmark
    public void readTransactionsInOrderWithCacheOn(CacheOnState state) throws Exception {
        List<Hash> hashes = state.getTransactions().stream().map(tx -> tx.getHash()).collect(Collectors.toList());
        for (Hash hash : hashes) {
            TransactionViewModel.fromHash(state.getTangle(), hash);
        }
    }

    @Benchmark
    public void readTransactionsInReverseOrderWithCacheOn(CacheOnState state) throws Exception {
        List<Hash> hashes = state.getTransactions().stream().map(tx -> tx.getHash()).collect(Collectors.toList());
        Collections.reverse(hashes);
        for (Hash hash : hashes) {
            TransactionViewModel.fromHash(state.getTangle(), hash);
        }
    }

    @Benchmark
    public void readTransactionsInRandomOrderWithCacheOff(CacheOffState state) throws Exception {
        List<Hash> hashes = state.getTransactions().stream().map(tx -> tx.getHash()).collect(Collectors.toList());
        Collections.shuffle(hashes);
        for (Hash hash : hashes) {
            TransactionViewModel.fromHash(state.getTangle(), hash);
        }
    }

    @Benchmark
    public void readTransactionsInOrderWithCacheOff(CacheOffState state) throws Exception {
        List<Hash> hashes = state.getTransactions().stream().map(tx -> tx.getHash()).collect(Collectors.toList());
        for (Hash hash : hashes) {
            TransactionViewModel.fromHash(state.getTangle(), hash);
        }
    }

    @Benchmark
    public void readTransactionsInReverseOrderWithCacheOff(CacheOffState state) throws Exception {
        List<Hash> hashes = state.getTransactions().stream().map(tx -> tx.getHash()).collect(Collectors.toList());
        Collections.reverse(hashes);
        for (Hash hash : hashes) {
            TransactionViewModel.fromHash(state.getTangle(), hash);
        }
    }

}
