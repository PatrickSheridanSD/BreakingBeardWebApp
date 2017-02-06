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

public class Application extends Controller {

		public Result addProduct() {
			// Instantiate a form object based on the Product class
			Form<Product> addProductForm = Form.form(Product.class);
			
			// Render the Add Product View, passing the form object
			return ok(addProduct.render(addProductForm));
		}

		public Result addProductSubmit() {

			// Create a product form object (to hold submitted data)
			// 'Bind' the object to the submitted form (this copies the filled form)
			Form<Product> newProductForm = Form.form(Product.class).bindFromRequest();	

				// Check for errors (based on Product class annotations)	
			if(newProductForm.hasErrors()) {
							// Display the form again
				return badRequest(addProduct.render(newProductForm));
			}
					// Save the Product using Ebean (remember Product extends Model)
			newProductForm.get().save();
			flash("success", "Product " + newProductForm.get().name + " has been created");
			
			// Render the Add Product View, passing the form object
			return redirect("/stock");
		}
		
		// Update a product by ID
		// called when edit button is pressed
		public Result updateProduct(Long id) {

			// Create a form based on the Product class
			// Fill the form with product object matching id
			// Use the finder to find the object by ID in the DB
			Form<Product> productForm = Form.form(Product.class).fill(Product.find.byId(id) );
			
			// Render the updateProduct view
			// pass the id and form as parameters
			return ok(updateProduct.render(id, productForm));					
		}

		// Handle the form data when an updated product is submitted 
		public Result updateProductSubmit(Long id) {

			// Create a product form object (to hold submitted data)
			// 'Bind' the object to the submitted form (this copies the filled form)
			Form<Product> updateProductForm = Form.form(Product.class).bindFromRequest();	

			// Check for errors (based on Product class annotations)	
			if(updateProductForm.hasErrors()) {
							// Display the form again
				return badRequest(updateProduct.render(id, updateProductForm));
			}
			
			// Update the Product (using its ID to select the existing object))
			Product p = updateProductForm.get();
			p.id = id;
			p.update();

			// Add a success message to the flash session
			flash("success", "Product " + updateProductForm.get().name + " has been updates");
			
			// Render the Add Product View, passing the form object
			return redirect("/stock");
		}
		

		// Delete Product
		public Result deleteProduct(Long id) {
			// Call delete method
			Product.find.ref(id).delete();
			
			// Add message to flash session 
			flash("success", "Product has been deleted");

			// Redirect home
			return redirect("/stock");
		}

		public Result stock() {
				// Get the list of products
				List<Product> products = Product.findAll();

				// Pass the list to the index view and render
				  return ok(stock.render(products));
		}


    public Result index() {
        return ok(index.render());
    }

    public Result about() {
        return ok(about.render());
    }
    
 
    
    public Result shop() {
        return ok(shop.render());
    }
    
    public Result products1() {
        return ok(products1.render());
    }
  
}