FROM ubuntu:20.04
ENV USER_NAME ciFi-evaluation
ENV USER_DIR /home/${USER_NAME}
##
ENTRYPOINT [ "/bin/bash" ]
##
# INSTALL PRELIMINARY TOOLS
RUN \
apt-get update && \
apt-get -y install apt-transport-https ca-certificates software-properties-common && \
apt-get update && \
apt-get -y install apt-utils && \
apt-get update && \
apt-get -y install git \
curl \
less \
nano \
vim \
zip \
zlib1g-dev \
wget \
python3.5 \
unzip
##
RUN \
    apt-get -y autoremove openjdk* && \
    apt-get -y purge openjdk* && \
    apt-get -y install openjdk-8-jdk
##
RUN mkdir evaluation
COPY evaluation /evaluation
# Copy Runner
RUN mkdir runner
COPY runner /runner
##
# Copy Benchmark
RUN mkdir benchmark
COPY benchmark /benchmark

# INSTALL SBT
COPY container-files /

RUN \
echo "deb https://repo.scala-sbt.org/scalasbt/debian all main" | tee /etc/apt/sources.list.d/sbt.list && \
echo "deb https://repo.scala-sbt.org/scalasbt/debian /" | tee /etc/apt/sources.list.d/sbt_old.list && \
curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | apt-key add && \
apt-get update && \
apt-get install sbt
##
##
# Download libraries
RUN \
cd / && \
mkdir libraries && \
cd libraries && \
mkdir Apache_Commons_Collections Eclipse_Collections Google_Guava Scala JDK && \
cd Apache_Commons_Collections && \
wget https://repo1.maven.org/maven2/org/apache/commons/commons-collections4/4.4/commons-collections4-4.4.jar && \
cd ../Eclipse_Collections && \
wget https://repo1.maven.org/maven2/org/eclipse/collections/eclipse-collections/10.4.0/eclipse-collections-10.4.0.jar && \
cd ../Google_Guava && \
wget https://repo1.maven.org/maven2/com/google/guava/guava/30.1.1-jre/guava-30.1.1-jre.jar && \
cd ../Scala && \
wget https://repo1.maven.org/maven2/org/scala-lang/scala-library/2.12.10/scala-library-2.12.10.jar
## 
RUN \
cd / && \
mkdir evaluation/results && \
mkdir evaluation/results/Apache evaluation/results/Eclipse evaluation/results/Guava evaluation/results/JDK evaluation/results/Scala
##
# INSTALL Glacier
# Glacier is already in the evaluation directory
RUN \
cd / && \
cd evaluation && \
mkdir glacier && \
cd glacier && \
mkdir annotations && \
mkdir down && \
cd down && \
wget https://raw.githubusercontent.com/mcoblenz/Glacier/master/ReplicationPackage.zip && \
unzip *.zip && \
cp -r 'Replication Package'/lib ../lib && \
cd .. && \
rm -r down && \
wget https://checkerframework.org/releases/2.0.0/checker-framework-2.0.0.zip && \
unzip *.zip && \
rm -rf *.zip && \
cp -r lib/Glacier.jar annotations/Glacier.jar && \
cp -r lib/Glacier.jar checker-framework-2.0.0/checker/lib/Glacier.jar && \
rm -rf lib
##
# INSTALL OPAL
## install opal
ARG OPAL_BRANCH="feature/classFieldImmutability"
ARG OPAL_COMMIT_ID="8cd5a3515a74bfe56b63417504c949ef441cae68"
#
RUN cd / && \
git clone https://github.com/stg-tud/opal.git && \
cd opal && \
git fetch && \
git pull && \
git checkout ${OPAL_BRANCH} && \
git reset --hard ${OPAL_COMMIT_ID}
##
RUN chmod +x /runner/*.sh
RUN chmod +x /runner/opalRealWorld_closedWorld.sh
RUN chmod +x /runner/cleanOpalResults.sh
RUN chmod +x /evaluation/opal/scripts/*.sh
RUN chmod +x /evaluation/opal/scripts/*.py

