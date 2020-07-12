FROM tomcat:9
COPY ./out/production/GWTManager/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java","Main"]