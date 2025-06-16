#!/bin/bash

# Set Maven version
MAVEN_VERSION=3.9.6

# Download and extract Maven
curl -fsSL https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz -o maven.tar.gz
tar -xzf maven.tar.gz
export MAVEN_HOME=$PWD/apache-maven-${MAVEN_VERSION}
export PATH=$MAVEN_HOME/bin:$PATH

# Verify installation
mvn -version