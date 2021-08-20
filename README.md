# README CiFi-Artifact
This is the artifact of the paper:  
*CiFi: Versatile Analysis of Class and Field Immutability*
published at ASE 2021.  
It contains everything required to reproduce the results of the CiFi evaluation.

## Content:
- [Requirements](REQUIREMENTS.md)
- [Installation instructions](INSTALL.md)
- Docker file
- CiFi-Benchmark

The Docker file prepares everything required to run the artifact.
It includes the benchmark and downloads Opal, Glacier, and the analyzed real-world libraries.

The runner directory includes all necessary scripts.  
All scripts should be run from /

### Starting the Container
Start the container with the following command:  
docker run -it cifiimage  

### Running Opal on the Benchmark
Opal executes the same benchmark as Glacier, but without the @Immutable annotations. It is located at:   
DEVELOPING_OPAL/validate/src/test/java/org/opalj/fpcf/fixtures/cifi_benchmark
It can be started with the script:
./runner/opalBenchmark.sh  
Note: Since the benchmark encompasses a wider range of immutability than CiFi covers, CiFi does not pass all test cases as discussed in the paper.

### Running Opal on Real-World Libraries:

#### Open World:

./runner/opalRealWorld_openWorld.sh

#### Closed World:

./runner/opalRealWorld_closedWorld.sh

#### Getting the Results:
Result figures: python3 /runner/opal_real_world_time_sum_up.py /evaluation/results  
Runtime figures: python3 /runner/opal_real_world_collect_results.py /evaluation/results/*

### Running Glacier on the Benchmark
The version of the benchmark annotated for Glacier is located at /benchmark
Our evaluation of Glacier on our benchmark was a lot manual effort.  
To reproduce this, one has to run Glacier on the respective file including all dependent files including the annotations.   
The challenge here is that Glacier stops once the first error is returned.
Thus, in order to evaluate a source file that depends on another file that Glacier considers erroneous, one has to remove Glacier's immutability annotations from such dependent file manually.
Several corner cases like mentioned in the paper were revealed by such manual observation.
Running the script /runner/glacierBenchmark.sh does therefore not reveal all of these findings, because not all dependencies are resolved.  
It provides an overview of most findings, though.
