package org.idb.TestSpringBoot.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
@AllArgsConstructor
public class EmailValidator implements Predicate<String> {


    @Override
    public boolean test(String s) {
        // user RegEX for validating Email address

        return true;
    }
}
