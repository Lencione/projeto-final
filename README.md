<p align="center">
 <h2 align="center">Projeto final - BACKEND</h2>
 <p align="center">Projeto para 3º semestre - Ciência da Computação UNIFAJ</p>
 <p align="center">
    <strong>
        Lucas Pianelli Andreotti 12225225 <br/>
        Pedro Henrique de Souza Frizo 12224358<br/>
        José Heitor Pagotto 12225006<br/>
        Wesley Lencione de Oliveira 12225140<br/>
    </strong>
</p>
</p>

### Rotas criadas
- `/api/login` - `POST` - Logar o usuário 
- `/api/users/register` - `POST` - Registra um novo usuário
- `/api/users/{id}` - `GET` - Recebe um usuário pelo seu ID
- `/api/products/getAll` - `GET` - Recebe todos os produtos
- `/api/products/{id}` - `GET` - Recupera um produto pelo ID

### Padrão de retorno
```json
   {
      "status": "success",
      "message": "Products retrieved successfully!",
      "data" : 
      [
        {
          "name": "Relogio",
          "quantity": 5,
          "price": 50.45
        },
        {
          "name": "Mouse",
          "quantity": 10,
          "price": 20.45
        }
      ]
   }
```

Feito com :heart: (ou ódio) e Java.