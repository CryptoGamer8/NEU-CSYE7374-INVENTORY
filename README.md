This is the final project repository for CSYE7374 Design Pattern course.

# Update

## InvoiceFactory
add validation to produceInvoice() API, it will return an empty invoice 
with id = -1 if the input itemId or employeeId does not exist

## ItemFactory and PersonFactory
Same to the InvoiceFactory, will return an empty object with id = -1 if the
input item or employee id is already exist.
