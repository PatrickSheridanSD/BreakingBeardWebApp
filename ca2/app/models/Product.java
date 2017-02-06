package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.*;
import play.data.format.*;
import play.data.validation.*;


// Product entity managed by Ebean
@Entity
public class Product extends Model {

    // Fields - note that these are defined as public and not private
    // During compile time, The Play Framework
    // automatically generates getters and setters

    @Id
    public Long id;

    @Constraints.Required
    public String name;

    @Constraints.Required
    public String description;

    @Constraints.Required
    public String category;

    @Constraints.Required
    public int	stock;

    @Constraints.Required
    public double price;

    // Default constructor
    public  Product() {
    }

    // Constructor to initialise object
    public  Product(Long id, String name, String description, String category, int stock, double price){
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.stock = stock;
        this.price = price;
    }
	
	//Generic query helper for entity Computer with id Long
    public static Model.Finder<Long,Product> find = new Model.Finder<Long,Product>(Long.class, Product.class);
	//Find all Products in the database
	public static List<Product> findAll() {
		return Product.find.all();
	}
	
	
	
}

