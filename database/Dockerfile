FROM mysql:8.0.28
ENV MYSQL_ROOT_PASSWORD=toor
ENV MYSQL_DATABASE=blackjack
ENV MYSQL_ROOT_HOST=%

COPY ./scripts/ /docker-entrypoint-initdb.d/
CMD ["--default-authentication-plugin=mysql_native_password"]