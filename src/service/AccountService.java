package service;

import model.Account;
import repository.AccountRepository;

public interface AccountService {


    Account save(Account account);

    public void addAccount(Long id_client, Account c);
    public void removeAccount(Long idCont);

    public void withdraw(String idCont,int suma);
    public void deposit(String idCont,int suma);

    public void transfer(String idCont,String idContDest, int suma);

    public AccountRepository getAccountRepository();

}
