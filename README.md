#Aldrin Tingson's Mini backend project using java

##To run the project:

```gradle clean build; java -jar build/libs/backend-0.0.1-SNAPSHOT.jar```

##Create new product

```curl -i -X POST -H "Content-Type:application/json" -d '{ "name" : "foo","description" : "bar","tags" : ["test"]}' http://localhost:8080/products```

##Get list of products

```curl http://localhost:8080/products```

##Get detail about a product

<pre>
curl http://localhost:8080/products/<b>1</b>
</pre>

where **1** is the *db product id*

##Update certain product

<pre>
curl -i -X PUT -H "Content-Type:application/json" -d '{ "name" : "fooedited","description" : "baredited","tags" : ["testedited"]}' http://localhost:8080/products/<b>1</b>
</pre>

where **1** is the *db product id*

Set price points for different currencies for a product

```
curl -i -X POST -H "Content-Type:application/json" -d '{**"productId"** : **1**, "prices" : {"USD" : 1,"PHP" : 50}}' http://localhost:8080/products/addPrices
```

where **productId** is the *db product id*


