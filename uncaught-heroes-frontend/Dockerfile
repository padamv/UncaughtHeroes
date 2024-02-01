FROM node:14-alpine AS frontend

WORKDIR /app

COPY uncaught-heroes-frontend/app/images /app/images
COPY uncaught-heroes-frontend/app/js /app/js
COPY uncaught-heroes-frontend/app/html /app/html
COPY uncaught-heroes-frontend/app/css /app/css

RUN npm install -g http-server

EXPOSE 8081

CMD ["http-server", ".", "-p", "8081"]
