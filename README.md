# Introducción:
API de Gestión de Productos: 
Esta API proporciona los servicios necesarios para gestionar productos, carritos 
de compras y ventas dentro de una plataforma de comercio electrónico. 
Permite listar productos, administrar el contenido de carritos de compras y 
registrar ventas.


###Funciones principales: 
• Gestión de productos (agregar, eliminar, listar, obtener detalles).
• Manejo del carrito de compras (agregar/eliminar productos).
• Registro de ventas y cálculo del total de la compra.
# Arquitectura:
### Servicios:
La API se divide en tres microservicios principales:

• **Microservicio de Productos**: Maneja la información de los productos disponibles en la plataforma.

• **Microservicio de Carrito de Compras**: Permite a los usuarios gestionar su carrito, agregando y quitando productos.

• **Microservicio de Ventas**: Registra y gestiona las ventas, asociando carritos de compras a transacciones. Cada microservicio se comunica a través de HTTP usando APIs REST.

### Patrones de diseño:
A su vez también usa los siguientes patrones de diseño para facilitar futuras 
actualizaciones:
•** Service register y Service Discovery** (Eureka Server)
•** Load Balancing** (Spring Cloud Load Balancer)
• **Circuit Breaker** (Resilience4J)
• **API Gateway** (Spring Cloud Gateway)

# Guía de uso:
### Servicio de productos:

#### • Obtener Producto por ID

Peticion:
```
GET  “/api/products-service/product/{id}”
```
*Descripción: Este endpoint devuelve los detalles de un producto específico usando su ID.*

Ejemplo:
![][(https://pandao.github.io/editor.md/examples/images/4.jpg)](https://github.com/Jonathan-Romano/TechnoMist-Back-End/blob/master/public/product-service/product-service-product-1.jpg)
--

#### • Obtener Producto por Código:

Peticion:
```
GET  “/api/products-service/product?codigo={codigo}”
```
* Este endpoint devuelve los detalles de un producto usando su código único..*

Ejemplo:
![](https://pandao.github.io/editor.md/examples/images/4.jpg)
--
#### • Listar Productos:


Peticion:
```
GET  “/api/products-service/product/list”
```
>Descripción: Este endpoint devuelve una lista de todos los productos disponibles en la plataforma..

Ejemplo:
![]()
---
#### •  Crear Producto:

Peticion:
```
POST  “/products-service/product/create”
```
>Descripción: Este endpoint crea un nuevo producto

Ejemplo:
![](https://pandao.github.io/editor.md/examples/images/4.jpg)
---
#### •  Editar Producto:

Peticion:
```
PUT  “/api/products-service/product/edit”
```
>Descripción: Este endpoint permite editar los detalles de un producto existente.

Ejemplo:
![](https://pandao.github.io/editor.md/examples/images/4.jpg)
---
#### • Eliminar Producto:

Peticion:
```
GET  “/api/products-service/product/delete/{id}”
```
>Descripción: Este endpoint elimina un producto de la plataforma por su ID.

Ejemplo:
![](https://pandao.github.io/editor.md/examples/images/4.jpg)

---
### Servicio de carritos:

#### • # Introducción:
API de Gestión de Productos: 
Esta API proporciona los servicios necesarios para gestionar productos, carritos 
de compras y ventas dentro de una plataforma de comercio electrónico. 
Permite listar productos, administrar el contenido de carritos de compras y 
registrar ventas.


###Funciones principales: 
• Gestión de productos (agregar, eliminar, listar, obtener detalles).
• Manejo del carrito de compras (agregar/eliminar productos).
• Registro de ventas y cálculo del total de la compra.
# Arquitectura:
### Servicios:
La API se divide en tres microservicios principales:

• **Microservicio de Productos**: Maneja la información de los productos disponibles en la plataforma.

• **Microservicio de Carrito de Compras**: Permite a los usuarios gestionar su carrito, agregando y quitando productos.

• **Microservicio de Ventas**: Registra y gestiona las ventas, asociando carritos de compras a transacciones. Cada microservicio se comunica a través de HTTP usando APIs REST.

### Patrones de diseño:
A su vez también usa los siguientes patrones de diseño para facilitar futuras 
actualizaciones:
•** Service register y Service Discovery** (Eureka Server)
•** Load Balancing** (Spring Cloud Load Balancer)
• **Circuit Breaker** (Resilience4J)
• **API Gateway** (Spring Cloud Gateway)

# Guía de uso:
### Servicio de productos:

#### • Obtener Producto por ID

Peticion:
```
GET  “/api/products-service/product/{id}”
```
*Descripción: Este endpoint devuelve los detalles de un producto específico usando su ID.*

Ejemplo:
![](https://pandao.github.io/editor.md/examples/images/4.jpg)
--

#### • Obtener Producto por Código:

Peticion:
```
GET  “/api/products-service/product?codigo={codigo}”
```
* Este endpoint devuelve los detalles de un producto usando su código único..*

Ejemplo:
![](https://pandao.github.io/editor.md/examples/images/4.jpg)
--
#### • Listar Productos:


Peticion:
```
GET  “/api/products-service/product/list”
```
>Descripción: Este endpoint devuelve una lista de todos los productos disponibles en la plataforma..

Ejemplo:
![](https://pandao.github.io/editor.md/examples/images/4.jpg)
---
#### •  Crear Producto:

Peticion:
```
POST  “/products-service/product/create”
```
>Descripción: Este endpoint crea un nuevo producto

Ejemplo:
![](https://pandao.github.io/editor.md/examples/images/4.jpg)
---
#### •  Editar Producto:

Peticion:
```
PUT  “/api/products-service/product/edit”
```
>Descripción: Este endpoint permite editar los detalles de un producto existente.

Ejemplo:
![](https://pandao.github.io/editor.md/examples/images/4.jpg)
---
#### • Eliminar Producto:

Peticion:
```
GET  “/api/products-service/product/delete/{id}”
```
>Descripción: Este endpoint elimina un producto de la plataforma por su ID.

Ejemplo:
![](https://pandao.github.io/editor.md/examples/images/4.jpg)
---

### Servicio de carritos:

#### • Obtener Producto por ID

Peticion:
```
GET  “/api/products-service/product/{id}”
```
>Descripción: Este endpoint devuelve los detalles de un carrito de compras, incluyendo los productos asociados.

Ejemplo:
![](https://pandao.github.io/editor.md/examples/images/4.jpg)
--

#### • Listar Carritos:

Peticion:
```
GET  “/api/cart-service/cart/list”
```
>Descripción:  Este endpoint devuelve una lista de todos los carritos de compras.

Ejemplo:
![](https://pandao.github.io/editor.md/examples/images/4.jpg)
--
#### • Listar Carritos con Productos:

Peticion:
```
GET  “/api/cart-service/cart/list/products”
```
>Descripción:  Este endpoint devuelve una lista de todos los carritos con sus productos.

Ejemplo:
![](https://pandao.github.io/editor.md/examples/images/4.jpg)
--
#### • Crear Carrito:

Peticion:
```
POST  “/api/cart-service/cart/create”
```
>Descripción: Este endpoint crea un nuevo carrito de compras.

Ejemplo:
![](https://pandao.github.io/editor.md/examples/images/4.jpg)
--
#### •  Agregar Producto al Carrito:

Peticion:
```
POST  “/cart-service/cart/{id}/add/product/{cod}”
```
>Descripción: Este endpoint agrega un producto al carrito especificado por su codigo de producto unico.

Ejemplo:
![](https://pandao.github.io/editor.md/examples/images/4.jpg)
--
#### • Eliminar Producto del Carrito:

Peticion:
```
GET  “/api/cart-service/cart/{id}/delete/product/{cod}”
```
>Descripción:  Este endpoint elimina un producto del carrito especificado por su codigo de producto unico.

Ejemplo:
![](https://pandao.github.io/editor.md/examples/images/4.jpg)
--
#### •  Eliminar Carrito:

Peticion:
```
GET  “/api/cart-service/cart/delete/{id}”
```
>Descripción: Este endpoint elimina un carrito de compras por su ID.

Ejemplo:
![](https://pandao.github.io/editor.md/examples/images/4.jpg)
--

### Servicio de ventas:

#### • Obtener venta por ID

Peticion:
```
GET  “/api/sale-service/sale/{id}”
```
>Descripción: Este endpoint devuelve los detalles de una venta.

Ejemplo:
![](https://pandao.github.io/editor.md/examples/images/4.jpg)
--

#### • Listar ventas:

Peticion:
```
GET  “/api/sale-service/sale/list”
```
>Descripción:  Este endpoint devuelve una lista de todas las ventas.

Ejemplo:
![](https://pandao.github.io/editor.md/examples/images/4.jpg)
--
#### • Listar venta con carrito:

Peticion:
```
GET  “/api/sale-service/sale/{id}/cart”
```
>Descripción:  Este endpoint devuelve una venta con el detalle de su carrito de compra.

Ejemplo:
![](https://pandao.github.io/editor.md/examples/images/4.jpg)
--
#### • Lista de ventas con carritos:

Peticion:
```
GET  “/api/sale-service/sale/list/cart”
```
>Descripción: Este endpoint devuelve una lista de todas las ventas y el detalle de sus carritos de compra.

Ejemplo:
![](https://pandao.github.io/editor.md/examples/images/4.jpg)
--
#### • Crear venta:

Peticion:
```
POST  “/api/sale-service/sale/create”
```
>Descripción: Este endpoint crea una nueva venta.

Ejemplo:
![](https://pandao.github.io/editor.md/examples/images/4.jpg)
--
#### •  Editar venta:

Peticion:
```
PUT  “/api/sale-service/sale/edit”
```
>Descripción: Este endpoint permite editar una venta.

Ejemplo:
![](https://pandao.github.io/editor.md/examples/images/4.jpg)
--
#### • Eliminar venta:

Peticion:
```
GET  “/api/sale-service/sale/delete/{id}”
```
>Descripción:  Este endpoint elimina una venta utilizando su id.

Ejemplo:
![](https://pandao.github.io/editor.md/examples/images/4.jpg)
--
#### •  Eliminar Carrito:

Peticion:
```
DELETE  “/api/cart-service/cart/delete/{id}”
```
>Descripción: Este endpoint elimina un carrito de compras por su ID.

Ejemplo:
![](https://pandao.github.io/editor.md/examples/images/4.jpg)
--
