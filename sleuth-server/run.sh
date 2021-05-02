#!/bin/bash

./gradlew --status

if [ -f "/tmp/gradle_user_home/gradle.properties" ]; then
    cp /tmp/gradle_user_home/gradle.properties ~/.gradle/
fi

JVM_ARGS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5006"
if [ -f "/app/utilities/profiler/libyjpagent.so" ]; then
  JVM_ARGS="${JVM_ARGS} -agentpath:/app/utilities/profiler/libyjpagent.so=listen=all,port=10001,disablestacktelemetry,exceptions=disable,delay=10000,sessionname=ProfilesService,logdir=/tmp/"
fi
JVM_ARGS="${JVM_ARGS} -DLOG_LEVEL=DEBUG"
JVM_ARGS="${JVM_ARGS} -noverify"
JVM_ARGS="${JVM_ARGS} -Xms128m -Xmx128m"
JVM_ARGS="${JVM_ARGS} -XX:+IdleTuningGcOnIdle"
JVM_ARGS="${JVM_ARGS} -Xtune:virtualized"
JVM_ARGS="${JVM_ARGS} -Xscmx128m"
JVM_ARGS="${JVM_ARGS} -Xscmaxaot100m"

SPRING_ARG="--spring.profiles.active=local"
echo SPRING_ARG "${SPRING_ARG}"

./gradlew bootRun --args="${SPRING_ARG}" -PjvmArgs="${JVM_ARGS}"

./gradlew --stop
