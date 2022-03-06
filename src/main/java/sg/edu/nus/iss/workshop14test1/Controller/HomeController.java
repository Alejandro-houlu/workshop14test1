package sg.edu.nus.iss.workshop14test1.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.workshop14test1.Model.Contact;
import sg.edu.nus.iss.workshop14test1.Service.ContactInterface;
import sg.edu.nus.iss.workshop14test1.repo.ContactRepository;

@Controller
@RequestMapping("/")
public class HomeController {

@Autowired
ContactInterface contactService;

@Autowired
ContactRepository cRepo;

@RequestMapping("/")
public String signup(Model model){
    Contact contact = new Contact();
    model.addAttribute("contact", contact);
    
    //Contact test = new Contact("New guy2", "new2@gmail.com","123123");
    //var test2 = cRepo.findById("1709497f");
    //test2.ifPresent(x-> System.out.println(x.getName() + " " + x.getEmail() + " " + x.getPhoneNumber() + " " + x.getId()));

    return "index";
}

@RequestMapping("/save")
public String saveUser(@ModelAttribute("contact") Contact user, Model model){

    Contact user1 = new Contact(user.getName(),user.getEmail(),user.getPhoneNumber());
    contactService.save(user1);

    model.addAttribute("users" , contactService.findAll());


    return "listAllUsers";

}

@RequestMapping("/search")
public String searchUser(@RequestParam(value = "id", required = false ) String uniqueId, Model model){

    Contact user = contactService.findById(uniqueId);
    String error = "";

    if(user == null){

        error = "User not found";

    }

    model.addAttribute("user", user);
    model.addAttribute("error", error);

    return "searchResult";



}
    
}
