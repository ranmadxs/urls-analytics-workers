# urls-analytics-workers
Microservicio que efectúa cálculos y consolidación de estadísticas analíticas de los “urlshortener”

## Compilar

```
./mvnw clean install
```
## Desplegar

```
java -jar target/urls-analytics-workers.jar
```

### Para crear nuevas urlshortener o bien ver un listado de las que existan:
https://github.com/ranmadxs/urls-base

## Heroku

Para revisar los logs y efectuar "escalado manual", el automático es de pago.
```
heroku logs --tail --app urls-analytics-workers

heroku ps:scale web=2 --app urls-analytics-workers
```

