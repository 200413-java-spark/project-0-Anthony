FROM postgres:10
ENV POSTGRES_USER hello-postgres
ENV POSTGRES_PASSWORD hello-postgres
ADD init.sql /docker-entrypoint-initdb.d
EXPOSE 5432