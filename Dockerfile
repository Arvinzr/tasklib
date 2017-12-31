FROM jboss/wildfly:latest
MAINTAINER Dmitry Degrave d.degrave@garvan.org.au
RUN /opt/jboss/wildfly/bin/add-user.sh admin admini42 --silent
ADD target/tasklib.war /opt/jboss/wildfly/standalone/deployments/
ADD standalone.xml /opt/jboss/wildfly/standalone/configuration/
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]