package org.perso.jbank.controller.web;

import org.dom4j.rule.Mode;
import org.perso.jbank.dto.CreateFromWebTransactionDTO;
import org.perso.jbank.dto.CreateTransactionDTO;
import org.perso.jbank.dto.CreateUserDTO;
import org.perso.jbank.dto.SearchAccountDTO;
import org.perso.jbank.model.Account;
import org.perso.jbank.model.User;
import org.perso.jbank.service.AccountService;
import org.perso.jbank.service.TransactionService;
import org.perso.jbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class TransactionPagesController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String getAllTransaction(Model model, HttpSession session){
        if(session.getAttribute("identifiant") == null) return "redirect:/index";
        Account account = this.accountService.findAccountByNumber((int) session.getAttribute("account")).get();
        model.addAttribute("sendTransaction", this.transactionService.findSentTransactionOfAccount(account));
        model.addAttribute("receiveTransaction", this.transactionService.findReceiveTransactionAccount(account));
        return "dashboard";
    }

    @RequestMapping(value = "/transaction", method = RequestMethod.GET)
    public String getTransactionPage(Model model, HttpSession session){
        if(session.getAttribute("identifiant") == null) return "redirect:/index";
        SearchAccountDTO searchAccountDTO = new SearchAccountDTO();
        CreateFromWebTransactionDTO createTransactionForm = new CreateFromWebTransactionDTO();
        model.addAttribute("searchAccountForm", searchAccountDTO);
        model.addAttribute("createTransactionForm", createTransactionForm);
        model.addAttribute("ownerName", "");
        model.addAttribute("numberAccount", "");
        return "transaction";
    }

    @RequestMapping(value = "/transaction", method = RequestMethod.POST)
    public String getToAccount(Model model, @ModelAttribute("searchAccountForm") SearchAccountDTO searchAccountDTO){
        Optional<Account> account = this.accountService.findAccountByNumber(searchAccountDTO.getNumberAccount());
        if(!account.isPresent()){
            model.addAttribute("accountNotFound", "Compte inexistant");
            CreateFromWebTransactionDTO createTransactionForm = new CreateFromWebTransactionDTO();
            model.addAttribute("searchAccountForm", searchAccountDTO);
            model.addAttribute("createTransactionForm", createTransactionForm);
            model.addAttribute("ownerName", "");
            model.addAttribute("numberAccount", "");
            return "transaction";
        }
        else{
            CreateFromWebTransactionDTO createTransactionForm = new CreateFromWebTransactionDTO();
            createTransactionForm.setToAccountNumber(searchAccountDTO.getNumberAccount());
            String fullName = account.get().getUser().getLastname() + ' ' + account.get().getUser().getFirstname();
            model.addAttribute("ownerName", fullName);
            model.addAttribute("numberAccount", searchAccountDTO.getNumberAccount());
            model.addAttribute("searchAccountForm", searchAccountDTO);
            model.addAttribute("createTransactionForm", createTransactionForm);
            return "transaction";
        }
    }

    @RequestMapping(value = "/transaction-response", method = RequestMethod.POST)
    public String getTransactionResponse(Model model, @ModelAttribute("createTransactionForm") CreateFromWebTransactionDTO createTransactionForm, HttpSession session){
        if(createTransactionForm.getAmount() > this.accountService.findAccountByNumber((int) session.getAttribute("account")).get().getCurrentCredit()){
            model.addAttribute("noEnoughCredit", "Fond insuffisant pour le transfert");
            return "redirect:/transaction";
        }

        Account toAccount = this.accountService.findAccountByNumber(createTransactionForm.getToAccountNumber()).get();
        Account fromAccount = this.accountService.findAccountByNumber((int) session.getAttribute("account")).get();
        CreateTransactionDTO createTransactionDTO = new CreateTransactionDTO();
        createTransactionDTO.setAmount(createTransactionForm.getAmount());
        createTransactionDTO.setFromAccountNumber(fromAccount.getAccountNumber());
        createTransactionDTO.setToAccountNumber(toAccount.getAccountNumber());
        this.transactionService.createTransaction(createTransactionDTO);
        Optional<User> updatedUser = this.userService.findUserById((int) session.getAttribute("identifiant"));
        session.setAttribute("user", updatedUser.get());
        return "transaction-response";
    }

}
