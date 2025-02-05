package com.rect2m.handlers;

public interface EventHandler<T> {

    void handle(T event);
}
