package sg.edu.nus.iss.workshop14test1.Model;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Contact")
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String email;

    private String phoneNumber;

    private String id; 

    public String getName(){
        return name;
    }

    public String setName(String name){
        return this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public String setEmail(String email){
        return this.email = email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String setPhoneNumber(String phoneNumber){
        return this.phoneNumber = phoneNumber;
    }

    public String getId(){
        return id;
    }

    public String setUniqueId(){
        
        String uniqueId = UUID.randomUUID().toString();
        return uniqueId.substring(0,8);
    }

    public Contact(String name, String email, String phoneNumber){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;

        this.id = setUniqueId();

    }

    public Contact(){}


}
