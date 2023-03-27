package com.example.task01;

import java.util.*;
import java.util.function.BiConsumer;

public class Pair<T, V> {
    private final T firstValue;
    private final V secondValue;
    private Pair(T firstValue, V secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }
    public T getFirst() {
        return firstValue;
    }

    public V getSecond() {
        return secondValue;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) obj;
        return this.firstValue.equals(pair.firstValue) && this.secondValue.equals(pair.secondValue);
    }

    public int hashCode() {
        return Objects.hash(this.firstValue, this.secondValue);
    }

    public static <T, V> Pair<T, V> of(T firstValue, V secondValue){
        return new Pair(firstValue, secondValue);
    }

    public void ifPresent(BiConsumer<? super T, ? super V> consumer){
        if (this.firstValue != null && this.secondValue != null) {
            consumer.accept((T)this.firstValue, (V)this.secondValue);
        }
    }
}
