package org.perso.jbank.controller.web;

import org.perso.jbank.dto.CreateUserDTO;
import org.perso.jbank.dto.UpdateUserDTO;
import org.perso.jbank.model.User;
import org.perso.jbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class RegisterPageController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public String getRegister(Model model){
        CreateUserDTO createUserForm = new CreateUserDTO();
        model.addAttribute("createUserForm", createUserForm);
        return "register";
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public String createUser(@ModelAttribute("createUserForm") CreateUserDTO createUserDTO, HttpSession session){
        this.userService.createUser(createUserDTO);
        Optional<User> user = this.userService.findUserByMail(createUserDTO.getMail());
        String accountNumberMasked = String.valueOf(user.get().getAccount().getAccountNumber());
        session.setAttribute("pass", user.get().getPassword());
        session.setAttribute("account", user.get().getAccount().getAccountNumber());
        session.setAttribute("identifiant", user.get().getId());
        session.setAttribute("user", user.get());
        session.setAttribute("accountDisplay", accountNumberMasked);
        return "redirect:/code";
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.GET)
    public String updateGet(Model model, HttpSession session){
        if(session.getAttribute("identifiant") == null) return "redirect:/index";
        UpdateUserDTO updateUserDTO = new UpdateUserDTO();
        model.addAttribute("updateForm", updateUserDTO);
        return "update";
    }

    @RequestMapping(value = {"update"}, method = RequestMethod.POST)
    public String updatePost(Model model, @ModelAttribute("updateForm") UpdateUserDTO updateUserDTO, HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user.getPassword().equals(updateUserDTO.getPassword())){
            this.userService.updateUser(user, updateUserDTO);
            session.setAttribute("user", user);
            return "redirect:/dashboard";
        }
        else {
            model.addAttribute("errorPasswordMessage", "Mot de passe incorrect");
            return "update";
        }
    }

    @RequestMapping(value = {"/code"}, method = RequestMethod.GET)
    public String displayCreateAccountInfo(Model model, HttpSession session){
        if(session.getAttribute("identifiant") == null) return "redirect:/index";
        return "code";
    }
}
