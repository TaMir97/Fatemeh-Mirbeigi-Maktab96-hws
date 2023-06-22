package org.example.service.implementation;

import org.example.repository.TypeRepository;
import org.example.service.TypeService;

public class TypeServiceImpl implements TypeService {
    private final TypeRepository typeRepository;

    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public void addType() {
        typeRepository.addType();
    }
}
