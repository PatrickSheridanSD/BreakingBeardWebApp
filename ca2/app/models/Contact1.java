package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.*;
import play.data.format.*;
import play.data.validation.*;


// Product entity managed by Ebean
@Entity
public class Contact1 extends Model {

    // Fields - note that these are defined as public and not private
    // During compile time, The Play Framework
    // automatically generates getters and setters

    @Id
    public Long id;
	
	@Constraints.Required
    public String email;

    @Constraints.Required
    public String name;

    @Constraints.Required
    public String phoneNumber;

    @Constraints.Required
    public String town;

    @Constraints.Required
    public String country;

    // Default constructor
    public  Contact1() {
    }

    // Constructor to initialise object
    public  Contact1(Long id, String email, String name, String phoneNumber, String town, String country){
        this.id = id;
		this.email=email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.town = town;
        this.country = country;
    }
	
	//Generic query helper for entity Computer with id Long
    public static Model.Finder<Long,Contact1> find = new Model.Finder<Long,Contact1>(Long.class, Contact1.class);
	//Find all Products in the database
	public static List<Contact1> findAll() {
		return Contact1.find.all();
	}
	
	
	
}

