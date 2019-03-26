import repository.AccountRepository;
import repository.PersonRepository;
import repository.TransactionRepository;
import repository.UserRepository;
import repository.impl.*;
import service.AccountService;
import service.PersonSercive;
import service.UserService;
import service.impl.AccountSeviceImpl;
import service.impl.PersonServiceImpl;
import service.impl.UserServiceImpl;
import view.LoginFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JDBConnectionWrapper jdbConnectionWrapper = new JDBConnectionWrapper("bank");

        // here we initialize repo
        UserRepository userRepository = new UserRepositoryImpl(jdbConnectionWrapper);
        AccountRepository accountRepository = new AccountRepositoryImpl(jdbConnectionWrapper);
        PersonRepository personRepository = new PersonRepositoryImpl(jdbConnectionWrapper);
        TransactionRepository transactionRepository = new TransactionRepositoryImpl(jdbConnectionWrapper);



        // here we initialize repo
        UserService userService = new UserServiceImpl(userRepository);
        AccountService accountService = new AccountSeviceImpl(accountRepository,transactionRepository);
        PersonSercive personSercive = new PersonServiceImpl(personRepository,accountRepository);

/*
        User user = new User();
        // user.setId(1L);
        user.setUsername("u");
        user.setPassword("p");
        user.setAdmin(false);

        userService.save(user);*/
       /*Person person = new Person();
       person.setName("Vasile");
       person.setCNP("123124");
       person.setAddres("asdad");

       personSercive.save(person);*/


       /* Account account = new Account();
        account.setId_person(1L);
        account.setIban("234");
        account.setMoney(12);
        account.setType("asda");


        accountService.addAccount(1L,account);
*/

        /**
         * Admin operation
          */

   /*     // Add user
        User user = new User();
        // user.setId(1L);
        user.setUsername("user");
        user.setPassword("pass");
        userService.save(user);

        // delete user

        userService.delete(3L);

        // edit user

        user.setPassword("passnew");
        userService.save(user);
*/


        LoginFrame frame = new LoginFrame(userService,accountService,personSercive);
        frame.setTitle("Login Form");
        frame.setVisible(true);

        frame.setBounds(500, 50, 400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}
