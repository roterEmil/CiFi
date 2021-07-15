#!/bin/bash
CHECKER_JAR="/evaluation/glacier/checker-framework-2.0.0/checker/dist/checker.jar"
OPAL_ANNOTATION_FOLDER="/evaluation/opal/annotations"
OPAL_ANNOTATIONS="$OPAL_ANNOTATION_FOLDER/fields/*.java \
$OPAL_ANNOTATION_FOLDER/field_assignability/*.java \
$OPAL_ANNOTATION_FOLDER/classes/*.java \
$OPAL_ANNOTATION_FOLDER/types/*.java"
COMMON="/benchmark/common/*.java"
GLACIER_ANNOTATION_FOLDER="/evaluation/glacier/annotations"
ANNOTATIONS="$OPAL_ANNOTATIONS -cp $GLACIER_ANNOTATION_FOLDER/Glacier.jar"
all_transitively_immutable_fields=""
fields=""

iterate_folder()
{
  BENCHMARK_FOLDER=$1
for folder in $BENCHMARK_FOLDER*/
do
        for file in $folder/*
        do
                if [[ -d $file ]]
                then
                        iterate_folder $file
                fi
                if [[ "$file" == *".java" ]]
                then
                        echo "------------------------------------------------------_"
                        echo "file: $file"
                        echo ""
			result=$(java -jar $CHECKER_JAR $COMMON $ANNOTATIONS -processor edu.cmu.cs.glacier.GlacierChecker $file 2>&1)
                        filtered_result=$result
                        list=$filtered_result
                        echo -e "$list" | while IFS= read -r line; do
                                echo $line
                        done
                        echo "=====================================================_"
                fi
        done

done
}

iterate_folder /benchmark

