# Api service-ecommerce
Api TUL desarrollada para administrar un carrito de compras.

## Para la Aplicacion se usaron las siguientes herramientas:
- Framework: Spring boot
- Lenguaje: Kotlin 1.4.31
- IDE: IntelliJ IDEA 
- Control de versiones: Git/github

## Enlaces:
- Proyecto en github: https://github.com/gustavo-aguirre/service-ecommerce.git
- Documentación del api: http://localhost:8080/swagger-ui.html


## Operaciones disponibles:
- Endpoint GET /products
  - Lista de todos los productos
- POST /products
  - Agrega un producto
- DELETE /products/{id}
  - Elimina un producto
- PUT /products/{id}
  - Modifica un producto 
  
- Endpoint GET /carts-shopps/{id}
  - Lista de todos los productos de un carrito
- POST /carts-shopps
  - Agrega un producto al carrito
 - DELETE /carts-shopps/{id}/{idProduct}
  - Elimina un producto al carrito
- PUT /carts-shopps/{id}
  - Modifica un producto al carrito 
- GET /carts-shopps/{id}/checkout
  - Devuelve el costo final de los productos del carrito  
  
  
  
    
