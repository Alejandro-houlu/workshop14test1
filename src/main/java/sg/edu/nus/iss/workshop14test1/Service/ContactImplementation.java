package sg.edu.nus.iss.workshop14test1.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.workshop14test1.Model.Contact;
import sg.edu.nus.iss.workshop14test1.repo.ContactRepository;

@Service
public class ContactImplementation implements ContactInterface{

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    ContactRepository cRepo;

        @Override
        public void save(final Contact ctc){
        
        //Comment out because I am going to use CRUD repository instead
        //redisTemplate.opsForValue().set(ctc.getId(), ctc);
        //redisTemplate.opsForList().leftPush("contactlist", ctc.getId());
        //redisTemplate.opsForHash().put("contactlist" + "_Map", ctc.getId(), ctc);

        cRepo.save(ctc);


        }

        @Override
        public Contact findById(final String contactId){
                
            //Contact result = (Contact)redisTemplate.opsForHash().get("contactlist" + "_Map", contactId);
            //for finding a single item, it is better to use redis template

            var queryResult = cRepo.findById(contactId);
            Contact result = new Contact();

            queryResult.ifPresent(x-> {
                result.setName(x.getName());
                result.setEmail(x.getEmail());
                result.setPhoneNumber(x.getPhoneNumber());
                result.setId(x.getId());
                
            } );
                
            return result;
        }

        @Override
        public List<Contact> findAll(){

            //Comment out because I am going to use CRUD repository instead 
            // var key = "contactlist_Map";
            // var result = (List<Contact>)(Object)redisTemplate.opsForHash().values(key);
            // for(Contact c : result){
            //     System.out.println(c.getName() + " " + c.getId() + " " + c.getEmail() + " " + c.getPhoneNumber());
            // }
            
            List<Contact> resultList = new ArrayList<>();
            var queryResult = cRepo.findAll();

            queryResult.forEach(x->resultList.add(x));

            return resultList;
        }
    
}
