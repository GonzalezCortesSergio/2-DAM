FROM httpd:2.4-alpine
LABEL maintainer="gonzalez.coser24@triana.salesianos.edu"
LABEL version="3.0"
RUN apk add git 
WORKDIR ./web
RUN git clone https://github.com/GonzalezCortesSergio/Tienda-vinilos.git /usr/local/apache2/htdocs/web
RUN mv ./* /usr/local/apache2/htdocs