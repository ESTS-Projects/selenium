FROM alpine:latest

WORKDIR /app

RUN apk update \
    && apk upgrade \
    && apk add --update openjdk11 maven bash

COPY . .

EXPOSE 3000
