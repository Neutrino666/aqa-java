package ru.education.aqajava.theory.base;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Collections {

    @Test
    void listVars() {
        List<String> l;
        l = new ArrayList<>();
        l.add("Мясо"); // 0
        l.add("Рыба"); // 1

        List<Integer> n = new ArrayList<>();
        n.add(123);
        n.add(1000);

        List<Object> m = new ArrayList<>();
        m.add("string");
        m.add(1000);

        System.out.println(n);
    }

    @Test
    void mapVars() {
        Map<String, Integer> m = new HashMap<>();

        m.put("Мясо", 1000);
        m.put("Рыба", 500);

        System.out.println(m.get("Рыба"));
    }
}
