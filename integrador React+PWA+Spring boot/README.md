# Iniciar

### FE: 
- El proyecto fué creado con [Create React App](https://github.com/facebook/create-react-app).

### BE:
- El proyecto fué creado con Maven, Hibernate y Spring boot.

## Levantar ambientes

### FE: 
- `npm install`
- `npm start`
- Abrir [http://localhost:3000](http://localhost:3000) en el navegador

### BE: 
- En resourses/spring/url setear las variables de entorno. 
- Levantar Xampp y crear una base de datos llamada "Biblioteca"
- Para crear las tablas en resourses/spring/jpa/hibernate debe estar en "Create"
- Para levantar los script de data colocar en resourses/spring/jpa/hibernate debe estar en "None"

## Postman
- Para importar la colección de Postman ir a resourses/Postman. Ahí encontrará todos los endpoint para probar en el BE.
- Probar el search Users en el siguiente endpoint en Postman. FE no implementado. `http://localhost:8080/api/users/campoabusacardenombre`
- Probar el search Books en el siguiente endpoint en Postman. FE no implementado. `http://localhost:8080/api/books/campoabusacardetítulo`
- Probar el update User en el siguiente endpoint en Postman. FE no implementado. `http://localhost:8080/api/user/userId`
- Probar el update Books en el siguiente endpoint en Postman. FE no implementado. `http://localhost:8080/api/book/bookId`







