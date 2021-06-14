
# How to use the app

## Import:
<a href="/src/main/resources/desafio-quality.postman_collection.json"> Postman Collection </a>

____
### All endpoints use the same request body below:

```
{
    "propName": "Nome da propriedade",
    "propDistrict": "Liberdade do bairro",
    "rooms": [
        {
            "roomName": "quarto",
            "roomWidth": 10,
            "roomLength": 10
        },
        {
            "roomName": "quarto2",
            "roomWidth": 10,
            "roomLength": 20
        }
    ]
}
```
<h3> US01: Calculate the property size</h3>
<h4> POST /property/size </h4>

___
<h3> #US02: Calculate the property value </h3>
<h4> GET /property/value </h4>

___
<h3> #US03: Determine the property biggest room  </h3>
<h4> GET /property/biggest-room </h4>

___
<h3> #US04: Calculate the size of each room </h3>
<h4> GET /property/rooms/size </h4>

_________
<h2> Running automated tests</h2>

You can use the ```mvn -fn test``` command on your terminal to run all of them.

Alternatively you can run the test classes or individual tests manually

---
<i> Built by @gustavo-hsu for the bootcamp quality challenge </i>