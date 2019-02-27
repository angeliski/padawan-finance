package br.com.padawan.finance.controller;

import br.com.padawan.finance.controller.to.TransactionTO;
import br.com.padawan.finance.service.TransactionFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private TransactionFacade transactionFacade;


    @Autowired
    public TransactionController(TransactionFacade transactionFacade) {
        this.transactionFacade = transactionFacade;
    }

    @GetMapping
    public List<TransactionTO> list() {
        return transactionFacade.list();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    TransactionTO save(@RequestBody TransactionTO transactionTO){
        return transactionFacade.save(transactionTO);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable  Long id){
        transactionFacade.delete(id);
    }
}
