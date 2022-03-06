package sg.edu.nus.iss.workshop14test1.Service;

import java.util.List;


import sg.edu.nus.iss.workshop14test1.Model.Contact;

public interface ContactInterface {


    public void save(final Contact ctc);
    public Contact findById(final String contactId);
    public List<Contact> findAll();
    
}
