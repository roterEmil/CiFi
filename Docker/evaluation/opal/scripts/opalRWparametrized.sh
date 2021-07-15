#!/bin/bash
RESULTDIR_JDK=/evaluation/results/JDK
RESULTDIR_ECLIPSE=/evaluation/results/Eclipse
RESULTDIR_GUAVA=/evaluation/results/Guava
RESULTDIR_APACHE=/evaluation/results/Apache
RESULTDIR_SCALA=/evaluation/results/Scala

ECLIPSE_JAR=/libraries/Eclipse_Collections/*.jar
GUAVA_JAR=/libraries/Google_Guava/*.jar
APACHE_JAR=/libraries/Apache_Commons_Collections/*.jar
SCALA_JAR=/libraries/Scala/*.jar


LEVEL=1
TIMES=15
THREADS=8

MODE=$1 

cd opal
sbt -Dsbt.rootdir=true "project Tools" "runMain org.opalj.support.info.Immutability -JDK -analysis FieldAssignability  -threads $THREADS -level $LEVEL -resultFolder $RESULTDIR_JDK -times $TIMES -analysisName JDK $MODE"
sbt -Dsbt.rootdir=true "project Tools" "runMain org.opalj.support.info.Immutability -JDK -analysis Fields -threads $THREADS -level $LEVEL -resultFolder $RESULTDIR_JDK -times $TIMES -analysisName JDK $MODE"
sbt -Dsbt.rootdir=true "project Tools" "runMain org.opalj.support.info.Immutability -JDK -analysis Classes -threads $THREADS -level $LEVEL -resultFolder $RESULTDIR_JDK -times $TIMES -analysisName JDK $MODE"
sbt -Dsbt.rootdir=true "project Tools" "runMain org.opalj.support.info.Immutability -JDK -analysis Types -threads $THREADS -level $LEVEL -resultFolder $RESULTDIR_JDK -times $TIMES -analysisName JDK $MODE"
sbt -Dsbt.rootdir=true "project Tools" "runMain org.opalj.support.info.Immutability -JDK -analysis All -threads $THREADS -level $LEVEL -resultFolder $RESULTDIR_JDK -times $TIMES -analysisName JDK $MODE"

run_all_analyses()
{
        INPUT_JAR=$1
        RESULT_FOLDER=$2
        TIMES=$3
        ANALYSIS_NAME=$4
        MODE=$5
        sbt -Dsbt.rootdir=true "project Tools" "runMain org.opalj.support.info.Immutability -analysis FieldAssignability -cp $INPUT_JAR -threads $THREADS -level $LEVEL -resultFolder $RESULT_FOLDER -times $TIMES -analysisName $ANALYSIS_NAME $MODE"
        sbt -Dsbt.rootdir=true "project Tools" "runMain org.opalj.support.info.Immutability -analysis Fields -cp $INPUT_JAR -threads $THREADS -level $LEVEL -resultFolder $RESULT_FOLDER -times $TIMES -analysisName $ANALYSIS_NAME $MODE"
        sbt -Dsbt.rootdir=true "project Tools" "runMain org.opalj.support.info.Immutability -analysis Classes -cp $INPUT_JAR -threads $THREADS -level $LEVEL -resultFolder $RESULT_FOLDER -times $TIMES -analysisName $ANALYSIS_NAME $MODE"
        sbt -Dsbt.rootdir=true "project Tools" "runMain org.opalj.support.info.Immutability -analysis Types -cp $INPUT_JAR -threads $THREADS -level $LEVEL -resultFolder $RESULT_FOLDER -times $TIMES -analysisName $ANALYSIS_NAME $MODE"
        sbt -Dsbt.rootdir=true "project Tools" "runMain org.opalj.support.info.Immutability -analysis All -cp $INPUT_JAR -threads $THREADS -level $LEVEL -resultFolder $RESULT_FOLDER -times $TIMES -analysisName $ANALYSIS_NAME $MODE"
}


run_all_analyses $ECLIPSE_JAR $RESULTDIR_ECLIPSE $TIMES Eclipse $MODE
run_all_analyses $GUAVA_JAR $RESULTDIR_GUAVA $TIMES Guava $MODE
run_all_analyses $APACHE_JAR $RESULTDIR_APACHE $TIMES Apache $MODE
run_all_analyses $SCALA_JAR $RESULTDIR_SCALA $TIMES Scala $MODE


