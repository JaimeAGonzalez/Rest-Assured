# Rest-Asured

## 0. Setup:
You have 2 options: <br />

1. Set up a Java project using your preferred IDE and add include the RestAssured library
as a dependency in your project. <br />

2. You can clone/download this repository that I created for this checkpoint. It contains a
basic java project with the necessary dependencies added. It shouldn't give you any
problems, but if not, don't waste time trying to fix it; just create a new project yourselves (it
will be faster that way). <br />

## 1. Task 1 - Making Requests:
1. Using a fake API service - suggestion:
```bash
dummyjson.com
```
2. Make at least three different types of requests (GET, POST, PUT, DELETE) to the API
endpoints. <br />

## 2. Task 2 - Assertions:
For each request made in Task 1, write assertions to verify key aspects of the response: <br />

* Status code
* Response time
* Headers
* Specific data fields

## 3. Task 3 - Schema Validation:
1. Choose one of the responses from Task 1.
2. Define a JSON schema. Suggestion: use an online tool to generate the schema based on
the expected json response; e.g.:

```bash
jsonschema.net.
```
3. Implement schema validation on the chosen response to ensure that it matches the
defined schema.

## Exceptions
Discount percentage attribute is not working during the POST and PUT. Then, in schema validator was not taken into consideration.

