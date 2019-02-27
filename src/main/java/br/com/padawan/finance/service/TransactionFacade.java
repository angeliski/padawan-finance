package br.com.padawan.finance.service;

import br.com.padawan.finance.controller.to.TransactionTO;
import br.com.padawan.finance.repository.TransactionRepository;
import br.com.padawan.finance.security.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Component
public class TransactionFacade {

    private AuthUtil authUtil;
    private TransactionRepository transactionRepository;
    private TransactionRemover transactionRemover;

    @Autowired
    public TransactionFacade(AuthUtil authUtil, TransactionRepository transactionRepository, TransactionRemover transactionRemover) {
        this.authUtil = authUtil;
        this.transactionRepository = transactionRepository;
        this.transactionRemover = transactionRemover;
    }


    public TransactionTO save(TransactionTO transactionTO) {
        return new TransactionTO(transactionRepository.save(transactionTO.toNewEntity(authUtil.currentUser())));
    }

    public void delete(Long id) {
        transactionRemover.delete(id);
    }

    public List<TransactionTO> list() {
        return StreamSupport.stream(transactionRepository
                .findByUser(authUtil.currentUser()).spliterator(), false)
                .map(TransactionTO::new)
                .collect(toList());
    }
}
