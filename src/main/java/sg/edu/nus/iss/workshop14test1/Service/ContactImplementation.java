package sg.edu.nus.iss.workshop14test1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
            
            //redisTemplate.opsForValue().set(ctc.getId(), ctc);

        redisTemplate.opsForList().leftPush("contactlist", ctc.getId());
        redisTemplate.opsForHash().put("contactlist" + "_Map", ctc.getId(), ctc);

        redisTemplate.opsForValue().set("Test1", "Hello World");

        }

        @Override
        public Contact findById(final String contactId){
                
            Contact result = (Contact)redisTemplate.opsForHash().get("contactlist" + "_Map", contactId);
                
            return result;
        }

        @Override
        public List<Contact> findAll(){

            var key = "contactlist_Map";
            var result = (List<Contact>)(Object)redisTemplate.opsForHash().values(key);

            for(Contact c : result){
                System.out.println(c.getName() + " " + c.getId() + " " + c.getEmail() + " " + c.getPhoneNumber());
            }

            return result;
        }
    
}
