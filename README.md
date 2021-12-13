This is the final project repository for CSYE7374 Design Pattern course.

## Description

The assignment of Final Inventory and Personnel Project.

## Getting Started

### Dependencies

* Java 11+
* JetBrain IntelliJ IDE (for GUI)

### Installing

* Move the source files (.java files in /src) into an java project.

### Executing program

* Run main() in Driver.java and see the output and GUI.

## Authors

* Kan Zhang	
* Linghao Du	
* Yang Song	
* Yiwei He	
* Yuchen Bao	
* Xuliang Mei

## License

Distributed under the MIT License.


# Update

## InvoiceFactory
add validation to produceInvoice() API, it will return an empty invoice 
with id = -1 if the input itemId or employeeId does not exist

## ItemFactory and PersonFactory
Same to the InvoiceFactory, will return an empty object with id = -1 if the
input item or employee id is already exist.