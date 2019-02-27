package br.com.padawan.finance.repository;

import br.com.padawan.finance.model.Transaction;
import br.com.padawan.finance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository  extends JpaRepository<Transaction, Long> {

    Iterable<Transaction> findByUser(User user);

    Transaction findByIdAndUser(Long id, User user);

}
