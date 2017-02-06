package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import play.data.Form.*;

import views.html.*;

// Import required classes
import java.util.ArrayList;
import java.util.List;

// Import models
import models.*;

public class ApplicationContact extends Controller {

		public Result addContact() {
			// Instantiate a form object based on the Product class
			Form<Contact1> addContactForm = Form.form(Contact1.class);
			
			// Render the Add Product View, passing the form object
			return ok(addContact.render(addContactForm));
		}

		public Result addContactSubmit() {

			// Create a product form object (to hold submitted data)
			// 'Bind' the object to the submitted form (this copies the filled form)
			Form<Contact1> newContact1Form = Form.form(Contact1.class).bindFromRequest();	

				// Check for errors (based on Product class annotations)	
			if(newContact1Form.hasErrors()) {
							// Display the form again
				return badRequest(addContact.render(newContact1Form));
			}
					// Save the Product using Ebean (remember Product extends Model)
			newContact1Form.get().save();
			flash("success", "Contact" + newContact1Form.get().name + " has been created");
			
			// Render the Add Product View, passing the form object
			return redirect("/details");
		}
		
				
		public Result details() {
				// Get the list of products
				List<Contact1> contacts1 = Contact1.findAll();

				// Pass the list to the index view and render
				  return ok(details.render(contacts1));
		}
		
		 
}