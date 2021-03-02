package th.ac.ku.bankaccount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.bankaccount.data.BankAccountRepository;
import th.ac.ku.bankaccount.model.BankAccount;

import java.util.List;

@RestController
@RequestMapping("/api/bankaccount")
public class BankAccountRestController {

    @Autowired
    BankAccountRepository bankAccountRepository;

    @GetMapping("/customer/{customerId}")
    public List<BankAccount> getAllCustomerId(@PathVariable int customerId) {
        return bankAccountRepository.findByCustomerId(customerId);
    }

    @GetMapping
    public List<BankAccount> getAll(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/{id}")
    public BankAccount getOne(@PathVariable int id){
        return  bankAccountRepository.findById(id).get();
    }

    @PostMapping
    public BankAccount create(@RequestBody BankAccount bankAccount){
        BankAccount record = bankAccountRepository.save(bankAccount);
        return record;
    }

    @PutMapping("/{id}")
    public BankAccount update(@PathVariable int id,@RequestBody BankAccount requestBody){
        BankAccount record = bankAccountRepository.findById(id).get();
        record.setBalance(requestBody.getBalance());
        bankAccountRepository.save(record);
        return record;
    }

    @DeleteMapping("/{id}")
    public BankAccount delete(@PathVariable int id){
        BankAccount record = bankAccountRepository.findById(id).get();
        bankAccountRepository.deleteById(id);
        return  record;
    }
}
