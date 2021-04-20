# CRUD RESTful

## Descripcion
Microservicio con varios servicios rest que realizan un crud sobre las entidades identificadas en el examen para desarrollador Backend en LOK

## Version
0.1.0

## Ultimos cambios
Dario	2021/04/20

## Endpoints

1. **Consultar clientes**: GET `/api/customer`
2. **Consultar un cliente**: GET `/api/customer/{id}`
3. **Eliminar un cliente**: DELETE `/api/customer/{id}`
3. **Crear un cliente**: POST `/api/customer`
4. **Actualizar el rfc de un cliente**: PATCH `/api/customer/{id}`

## Instalacion

Se requiere tener instalado lo siguiente:
- Maven 3.6.x o superior [Download](https://maven.apache.org/download.cgi)
- JDK 8 [Download](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)

**Configuracion**
- Para maven se tiene que agregar al path de el directorio (directorio maven)/bin
- Para java (instalacion java)/jdk1.8.0_281/bin

El proyecto esta contruido usando el empaquetardor MAVEN, es un proyecto que usa spring boot y fue construido por medio de Spring Tool Suit el cual utiliza [Spring Initializr](https://start.spring.io) por lo cual para ejecutarlo basta con entrar al directorio del proyecto y ejecutar en linea de comandos:
> `mvn spring-boot:run`

## Consumo

Para consumir requiere alguno de los siguientes softwares:
1. [postman](https://www.postman.com/downloads/)
2. [curl](https://curl.se/download.html)

Para consumir los microservicio hay algunos ejemplos ya listos para ejecutarse:
1. Para **postman** hay una coleccion incluida en el directorio: `/request/postman`
2. Para **curl** hay ejemplos incluidos en el directorio: `/request/curls`

## Trazabilidad 

Cada operacion registra via log un identificador para identificar cada transaccion. En el bloque de abajo se tienen 2 transacciones **[http-nio-8080-exec-2]** y **[http-nio-8080-exec-4]**.

```
12:09:53.960  [http-nio-8080-exec-2] INFO  o.a.c.c.C.[Tomcat].[localhost].[/] - Initializing Spring DispatcherServlet 'dispatcherServlet'
12:09:53.960  [http-nio-8080-exec-2] INFO  o.s.web.servlet.DispatcherServlet - Initializing Servlet 'dispatcherServlet'
12:09:53.961  [http-nio-8080-exec-2] INFO  o.s.web.servlet.DispatcherServlet - Completed initialization in 1 ms
12:09:53.975  [http-nio-8080-exec-2] WARN  o.s.w.s.m.m.a.ExceptionHandlerExceptionResolver - Resolved [org.springframework.web.bind.MethodArgumentNotValidException: Validation failed for argument [1] in public void com.example.crud.controller.CustomerController.updateCurp(int,com.example.crud.model.request.CustomerRfcOnlyRequest): [Field error in object 'customerRfcOnlyRequest' on field 'rfc': rejected value [QWER123456L0]; codes [Pattern.customerRfcOnlyRequest.rfc,Pattern.rfc,Pattern.java.lang.String,Pattern]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [customerRfcOnlyRequest.rfc,rfc]; arguments []; default message [rfc],[Ljavax.validation.constraints.Pattern$Flag;@4f1be99b,[a-zA-Z]{4}\d{6}(\w{3})?]; default message [RFC invalido.]] ]
12:10:19.420  [http-nio-8080-exec-4] DEBUG c.e.c.s.impl.CustomerServiceImpl - Request [userId=2, rfc=QWER123456L0L].
12:10:19.420  [http-nio-8080-exec-4] DEBUG com.example.crud.dao.CustomerDao - Se actualizo el rfc QWER123456L0L del cliente 2.
```


## Ejemplos

---

- 1. **Consultar clientes**:

---

**Request**: GET `/api/customer`

> Sin body

**Response** Http status 200

```json
{
    "customers": [
        {
            "userId": 1,
            "country": {
                "name": "Mexico"
            },
            "address": {
                "state": {
                    "country": {
                        "name": "Mexico"
                    },
                    "name": "Ciudad de Mexico"
                },
                "street": "Avenida mexico",
                "suburb": "Colonia verde",
                "province": "Cuauhtemoc"
            },
            "first_name": "Nombre1",
            "last_name": "Apellido1",
            "curp": "curp1",
            "rfc": "rfc1",
            "gener": "m",
            "nationality": {
                "countries": [
                    {
                        "name": "Mexico"
                    }
                ]
            }
        },
        {
            "userId": 2,
            "country": {
                "name": "Mexico"
            },
            "address": {
                "state": {
                    "country": {
                        "name": "Mexico"
                    },
                    "name": "Queretaro"
                },
                "street": "Avenida por ahi",
                "suburb": "Colonia azul",
                "province": "Cayetano Rubio"
            },
            "first_name": "Nombre2",
            "last_name": "Apellido2",
            "curp": "curp2",
            "rfc": "rfc2",
            "gener": "f",
            "nationality": {
                "countries": [
                    {
                        "name": "Mexico"
                    },
                    {
                        "name": "Estados Unidos"
                    }
                ]
            }
        }
    ]
}
```
---

- 2. **Consultar un cliente**:

---

**Request**: GET `/api/customer/1`

> Sin body

**Response**: Http status 200

```json
{
    "customer": {
        "userId": 1,
        "country": {
            "name": "Mexico"
        },
        "address": {
            "state": {
                "country": {
                    "name": "Mexico"
                },
                "name": "Ciudad de Mexico"
            },
            "street": "Avenida mexico",
            "suburb": "Colonia verde",
            "province": "Cuauhtemoc"
        },
        "first_name": "Nombre1",
        "last_name": "Apellido1",
        "curp": "curp1",
        "rfc": "1111111",
        "gener": "m",
        "nationality": {
            "countries": [
                {
                    "name": "Mexico"
                }
            ]
        }
    }
}
```

---

- 3. **Eliminar un cliente**:

---

**Request**: DELETE `/api/customer/1`

> Sin body

**Response** Http status 204

> Sin body

---

- 4. **Crear un cliente**:

---

**Request**: POST `/api/customer`

```json
{
    "customerProfile": {
        "userId": 3,
        "countryId": 1,
        "first_name": "Nombre3",
        "last_name": "Apellido3",
        "curp": "curp3",
        "rfc": "rfc3",
        "gener": "f",
        "nationalityId": 2
    }
}
```

**Response** Http status 201

> Sin body

---

- 5. **Actualizar el rfc de un cliente**:

---

**Request**: PATCH `/api/customer/1`

```json
{
    "rfc": "QWER123456L0L"
}
```

**Response** Http status 204

> Sin body

---

- 6. **Actualizar un cliente con un rfc invalido**:

---

**Request**: PATCH `/api/customer/1`

```json
{
    "rfc": "QWER123456L0"
}
```

**Response** Http status 400

{
    "message": "RFC invalido."
}

---

- 7. **Recuperar un cliente no registrado.**:

---

**Request**: GET `/api/customer/5`

> Sin body

**Response** Http status 404

```json
{
    "message": "Cliente no encontrado."
}
```
