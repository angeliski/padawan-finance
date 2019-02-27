package br.com.padawan.finance.service;

import br.com.padawan.finance.exceptions.NotOwnerTransactionException;
import br.com.padawan.finance.model.Transaction;
import br.com.padawan.finance.repository.TransactionRepository;
import br.com.padawan.finance.security.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionRemover {

    private AuthUtil authUtil;
    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionRemover(AuthUtil authUtil, TransactionRepository transactionRepository) {
        this.authUtil = authUtil;
        this.transactionRepository = transactionRepository;
    }


    public void delete(Long id) {
        Transaction transaction = transactionRepository.findByIdAndUser(id, authUtil.currentUser());

        if(transaction == null){
            throw new NotOwnerTransactionException();
        }

        transactionRepository.delete(transaction);
    }
}
