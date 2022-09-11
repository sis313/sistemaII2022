FROM azul/zulu-openjdk:11.0.10
RUN apt update

ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app


ENTRYPOINT ["java","-cp","app:app/lib/*","ucb.edu.bo.tallersoftware.TallersoftwareApplication"]