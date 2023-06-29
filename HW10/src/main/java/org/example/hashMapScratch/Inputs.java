package org.example.hashMapScratch;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Inputs <K, V>{
    private K key;
    private List<V> values;
}
