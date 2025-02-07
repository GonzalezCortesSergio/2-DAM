FROM node:20.10-alpine3.19 as builder
RUN apk add git
WORKDIR /web
RUN git clone https://github.com/GonzalezCortesSergio/servicios-carburantes.git .
RUN npm install -g @angular/cli
RUN npm install 
RUN ng build --configuration production --aot

FROM nginx:alpine
WORKDIR /web
COPY --from=builder /web/dist/servicios-carburantes/* .
RUN mv ./* /usr/share/nginx/html/