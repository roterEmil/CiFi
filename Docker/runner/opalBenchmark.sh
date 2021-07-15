#!/bin/bash
cd /opal
export _JAVA_OPTIONS="-Xmx25g"
sbt "project Validate" "testOnly org.opalj.fpcf.ImmutabilityBenchmarkTests"
