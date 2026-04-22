package com.library.LibraryMS.service;

import com.library.LibraryMS.entity.Publisher;
import com.library.LibraryMS.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;


    public List<Publisher> getAllPublishers(){
        return publisherRepository.findAll(Sort.by("id").ascending());
    }

    public Publisher getPublisherById(Long id){
        Publisher publisher = publisherRepository.findById(id).orElseThrow(()->new RuntimeException("Publisher with this Id cannot be found !"));

        return publisher;
    }

    public void createPublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }

    public void deletePublisher(Long id){
        Publisher publisher = publisherRepository.findById(id).orElseThrow(()->new RuntimeException("Publisher with this Id cannot be found !"));
        publisherRepository.deleteById(publisher.getId());

    }

    public void updatePublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }

}
