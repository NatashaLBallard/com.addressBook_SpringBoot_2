package com.addressbook_springboot_2.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    AddressRepository addressRepository;

    @RequestMapping("/")
    public String listAddresses(Model model) {
        model.addAttribute("addresses", addressRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String addressForm(Model model){
        model.addAttribute("address", new Address());
        return "addressform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Address address, BindingResult result){
        if (result.hasErrors()){
            return "addressform";
        }
        addressRepository.save(address);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showAddress(@PathVariable("id") long id, Model model){
        model.addAttribute("address", addressRepository.findOne(id));
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateAddress(@PathVariable("id") long id, Model model){
        model.addAttribute("address", addressRepository.findOne(id));
        return "addressform";
    }

    @RequestMapping("/delete/{id}")
    public String delAddress(@PathVariable("id") long id){
        addressRepository.delete(id);
        return "redirect:/";
    }


    @GetMapping ("/search")
    public String getSearch(){
        return "search";
    }

    @PostMapping("/search")
    public String showSearchResults(HttpServletRequest request, Model model){
        String searchString = request.getParameter("search");
        //System.out.println(searchString);
        model.addAttribute("search",searchString);
//        model.addAttribute("address", addressRepository.findAllByFirstNameOrLastNameOrEmailOrAddressInfoOrPhoneNumber (searchString));
        model.addAttribute("addresses", addressRepository.findAllByFirstName (searchString));
//        model.addAttribute("addresses", addressRepository.findAllByLastName (searchString));
//        model.addAttribute("addresses", addressRepository.findAllByEmail (searchString));
//        model.addAttribute("addresses", addressRepository.findAllByAddressInfo (searchString));
//        model.addAttribute("addresses", addressRepository.findAllByPhoneNumber (searchString));


        return "list";
    }


}
