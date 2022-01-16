package org.perso.jbank.controller.web;

import org.perso.jbank.dto.ConnexionUserDTO;
import org.perso.jbank.dto.UpdateUserDTO;
import org.perso.jbank.model.User;
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
public class HomePageController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model){
        ConnexionUserDTO connexionUserDTO = new ConnexionUserDTO();
        model.addAttribute("connexionForm", connexionUserDTO);
        return "index";
    }

    @RequestMapping(value = "/disconnection", method = RequestMethod.GET)
    public String disconnection(Model model, HttpSession session){
        session.invalidate();
        return "redirect:/index";
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.POST)
    public String indexPost(Model model, @ModelAttribute("connexionForm") ConnexionUserDTO connexionUserDTO, HttpSession session){
        User user = this.userService.connexionUser(connexionUserDTO);
        if(user != null){
            String accountNumberMasked = String.valueOf(user.getAccount().getAccountNumber());
            session.setAttribute("pass", user.getPassword());
            session.setAttribute("account", user.getAccount().getAccountNumber());
            session.setAttribute("identifiant", user.getId());
            session.setAttribute("user", user);
            session.setAttribute("accountDisplay", accountNumberMasked);
            return "redirect:/dashboard";
        }
        else{
            model.addAttribute("errorMessage", "Identifiant ou mot de passe incorrect");
            return "index";
        }
    }
}
