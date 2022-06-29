package com.brhmty.mynewschool.service;

import com.brhmty.mynewschool.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContactService {

    public boolean saveMessageDetails(Contact contact){
        log.info(contact.toString());
        return true;
    }
}
