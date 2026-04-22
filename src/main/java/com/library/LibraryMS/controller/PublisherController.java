package com.library.LibraryMS.controller;

import com.library.LibraryMS.entity.Publisher;
import com.library.LibraryMS.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/publishers")
    public String findAllPublishers(Model model){
        model.addAttribute("publishers",publisherService.getAllPublishers());
        return "publishers";

    }

    @GetMapping("remove-publisher/{id}")
    public String removePublisher(@PathVariable Long id, Model model){
        publisherService.deletePublisher(id);
        model.addAttribute("publishers",publisherService.getAllPublishers());
        return "publishers";
    }

    @GetMapping("/update-publisher/{id}")
    public String updatePublisher(@PathVariable Long id,Model model){
        model.addAttribute("publisher",publisherService.getPublisherById(id));
        return "update-publisher";
    }

    @PostMapping("/update-publisher/{id}")
    public String updatedPublisher(@PathVariable Long id, Publisher publisher, BindingResult result,Model model){
        if (result.hasErrors()){
            return "update-publisher";
        }
        Publisher existingPublisher=publisherService.getPublisherById(id);
        existingPublisher.setName(publisher.getName());
        publisherService.updatePublisher(existingPublisher);
        model.addAttribute("publishers",publisherService.getAllPublishers());
        return "redirect:/publishers";
    }

    @GetMapping("/add-publisher")
    public String addPublisher(Publisher publisher){
        return "add-publisher";
    }

    @PostMapping("/save-publisher")
    public String addedPublisher(Publisher publisher,BindingResult result,Model model){
        if (result.hasErrors()){
            return "add-publisher";
        }
        publisherService.createPublisher(publisher);
        model.addAttribute("publishers",publisherService.getAllPublishers());
        return "redirect:/publishers";
    }
}
