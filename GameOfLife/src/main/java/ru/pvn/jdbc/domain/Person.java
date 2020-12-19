package ru.pvn.jdbc.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Person {
    private final long id;
    private final long record;
    private final String name;

}
