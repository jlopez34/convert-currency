# Exchange money
API REST builds to make conversion of the different currencies like BRL, USD, EUR, JPY.

This is the Exchange platform is think of it as a simple version of Exchange system. The Platform provides to possibility
of make conversion between different currencies. Each conversion is saved into the memory database.

This repo contains a SpringBoot project which has implemented functionality for exchange currency.

## Implementation

### Technology:

Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".

We take an opinionated view of the Spring platform and third-party libraries so you can get started with minimum fuss. Most Spring Boot applications need minimal Spring configuration.


### EndPoints:
| Http Method  | Endpoint | Description |
| ------------- | ------------- |-----------|
| POST  | http://localhost:8090/exchange/convert  | Return exchange money|
| GET  | http://localhost:8090/exchange/transactions/{userId}  | Return list of transaction by userId|

* Swagger Documentation : [https://github.com/jlopez34/convert-currency/blob/develop/env/exchange-swagger.yaml][https://github.com/jlopez34/convert-currency/blob/develop/env/exchange-swagger.yaml]

### Features

   * Converting different currencies like (BRL, USD, EUR, CLP)

   * Provide information about all transactions executed by user.

   * Save data associated to the conversion currency like (Currency From, Currency to, Rate, Change)
     
   * Use of third-party service to obtain rates necessary to exchange currency [http://api.exchangeratesapi.io/latest?base=EUR][http://api.exchangeratesapi.io/latest?base=EUR]

### Restrictions

Due to that the third-party services to obtain rates does not a PGL project, It just possible obtain rates using as currency base "EUR" it was applied the following formula:
```
1.
1EUR ---> Rate[currencyFrom]
  X  ---> ValueCurrencyFrom

* ValueEUR = Rate[currencyFrom] / ValueCurrencyFrom

2.
1EUR     ---> Rate[currencyTo]
ValueEUR ---> X

* Change = ValueEUR * Rate[currency]
```


### Structure Package
```
com.jayatech.challenge.exchange 
  - config  ---> package used to access to properties resource. 
  - controller --> package used to expose endpoints
  - domain --> package used to group file like dto/model
  - exception --> package to create customer exception and handler exceptions
  - gateway --> package used to access to thrid-party service
  - repository --> package used to implement access to H2 memory database
  - service --> package content to logic implementation (core)
  - wrapper --> package used to transformation between different POJO
 ExchangeApplication
```
### Requirements

All test classes (any class that ends with `Test`) should not be modified.

The [pom.xml](pom.xml) file should only be modified in order to add any third-party dependencies required for your solution.
We don't expect to see databases or other persistence layers. 

Solution must use 
   * `Java 11`
   * `Maven`
   * `Mockito`
   * `Spring Boot 2.4.2`


### Build and Tests
#### Build

1. You should to make clone project [https://github.com/jlopez34/convert-currency][https://github.com/jlopez34/convert-currency]
2. Run `mvn clean install`
3. 

#### Test
Run `mvn clean test` to run the unit tests. These should all pass if your solution has been implemented correctly.<br>
**Please** check that all the unit tests pass when you run `mvn clean test`, rather than solely running them from inside your IDE.


[https://github.com/jlopez34/convert-currency]: https://github.com/jlopez34/convert-currency

[http://api.exchangeratesapi.io/latest?base=EUR]: http://api.exchangeratesapi.io/latest?base=EUR

[https://github.com/jlopez34/convert-currency/blob/develop/env/exchange-swagger.yaml]: https://github.com/jlopez34/convert-currency/blob/develop/env/exchange-swagger.yaml