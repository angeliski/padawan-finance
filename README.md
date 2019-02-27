#Padawan Finance

O projeto está disponível em [https://padawan-finance.herokuapp.com](https://padawan-finance.herokuapp.com).

Ao acessar a url ele mostrara os endpoints disponíveis.

Para fazer o cadastro de um usuario deve ser utilizado o ```/users/sign-up```.
Para fazer o login deve ser utilizado o endpoint ```POST /login```, passando no corpo da requisição 
``` {                 
        "username": "admin",
        "password": "password"
    }
```

Exemplo do curl:
```
curl -i -H "Content-Type: application/json" -X POST -d '{                 
    "username": "admin",
    "password": "password"
}' http://localhost:8080/login

``` 
Exemplo do retorno:
```
HTTP/1.1 200 
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjZXN0YXJvIiwiZXhwIjoxNTUyMDk1NjE5fQ.D8i4DfMRur7jR3bGhlpIKUsITOHeNVR5GKovvvehR1WhpQOw0VG1ay4WrsDK0JmS6wxTFRw-NYEvxi1u2srxfw
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Content-Length: 0
Date: Wed, 27 Feb 2019 01:40:19 GMT

```
O cabeçalho do Authorization deve ser enviado nas requisições seguintes para que o usuário possa ser considerado autenticado. 


