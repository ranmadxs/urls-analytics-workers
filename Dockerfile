FROM openjdk:17-jdk-slim-buster
WORKDIR /project
COPY . .
RUN chmod +x mvnw
RUN ./mvnw package -DskipTests -s settings-template.xml
RUN java -Djarmode=layertools -jar target/urls-analytics-workers.jar extract

WORKDIR /app
RUN addgroup --system javauser && adduser -S -s /bin/false -G javauser javauser
USER javauser

COPY --from=builder --chown=javauser:javauser /project/dependencies/ ./
COPY --from=builder --chown=javauser:javauser /project/snapshot-dependencies/ ./
COPY --from=builder --chown=javauser:javauser /project/spring-boot-loader/ ./
COPY --from=builder --chown=javauser:javauser /project/application/ ./

## --------------------------------
EXPOSE 8080
ENTRYPOINT [ "java", "org.springframework.boot.loader.JarLauncher" ]
#CMD "dumb-init" "java" "org.springframework.boot.loader.JarLauncher"