# Procurement Management System
### Technologies
```sh
    Front-End   : Java 8, Android 5.0
    Back-End    : NodeJS 8.12.0
    Database    : MongoDB 4.0
```

### Coding Conventions
* Variable Names and Methods Names are Camel Cased. Ex: ```int screenWidth = 10; ```
* Constants are Capitalized. Ex: ```public static final float PI = 3.14; ```
* For the class names first letter of the word should be capitalized. Ex: ```class DogMeals{} ```
* Comments should be there for each functions and classes.
 Ex:
```sh
/**
* This method returns the materials provided by the suppliers as Array
* @param supplierID
*           ID of the Supplier 
* @param materialType
*           Type of the Material
* @return String[]
            Array of the Items
*/
public String[] getSupplierItems(String supplierID, String materialType){
    ...
}
```
* Exception handling should be there
* Variables inside the classes should be private unless it is a constant. User getters and setters.
* Try to use Immutable methods. 
Ex:
```sh
public void printSupplierDetails(String supplierID, String supplierName){
    System.out.println(supplierID);
    System.out.println(supplierName);
}

/* Instead of Above Method use Below Method */

public void printSupplierDetails(Supplier supplier){
    System.out.println(supplier.ID);
    System.out.println(supplier.name);
}
```

### Contributions
| Contributor | Mainly Focused Role |
| ----------- | -------- |
| [Puvipavan P](https://github.com/Puvipavan) | Constructor  |
| [Sankeethan N ](https://github.com/nsankeeth) | Accounting Staff & Login/Logout  |
| [Suganya S](https://github.com/Sugan-s) | Supplier | 
| [Thayakaran S](https://github.com/Thayakaran) | Management(Admin) | 
| [Vithushan J](https://github.com/JegaVithu) | Site Manager |
