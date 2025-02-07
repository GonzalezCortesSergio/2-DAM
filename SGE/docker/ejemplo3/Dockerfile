FROM httpd:alpine3.17
LABEL maintainer="gonzalez.coser24@triana.salesianos.edu"
LABEL version="3.0"
RUN apk add git 
WORKDIR /web
RUN git clone https://github.com/GonzalezCortesSergio/Tienda-vinilos.git .
RUN mv ./* /usr/local/apache2/htdocs/