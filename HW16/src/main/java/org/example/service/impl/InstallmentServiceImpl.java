package org.example.service.impl;

import org.example.base.service.impl.BaseServiceImpl;
import org.example.domain.Installment;
import org.example.repository.InstallmentRepository;
import org.example.service.InstallmentService;

public class InstallmentServiceImpl
        extends BaseServiceImpl<Installment, Long, InstallmentRepository>
        implements InstallmentService {
    public InstallmentServiceImpl(InstallmentRepository repository) {
        super(repository);
    }
}
