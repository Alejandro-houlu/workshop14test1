package sg.edu.nus.iss.workshop14test1.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.workshop14test1.Model.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, String>{



    
}
