from os import listdir
from os import walk
import sys
import re
import statistics

def createResult(x, name):
    r1 = []
    r2 = []

    for item in x:
        #print("item: " + item["total"])
    	r1.append(float(item["total"]))
    if r1:
        med = statistics.median(r1)
    else:
        med = 0
    print(r1)
    print(name +" all total med: " + str(med))
    print("")
    #
    # analysis
    r1 = []
    r2 = []
    for item in x:
        #print("item: " + item["total"])
    	r1.append(float(item["analysis"]))
    print(r1)
    if r1:
        med = statistics.median(r1)
    else:
        med = 0
    print(name + " analysis med: " + str(med))
    print("")
    return


folders = sys.argv
folders.pop(0)
for folder in folders:
    for (dirpath, dirnames, filenames) in walk(folder):
        alls = []
        fields = []
        classes = []
        types = []
        fieldReferences = []

        for filename in filenames:
            analysis = dict()
            path = dirpath + "/" + filename
            #print(path)
            File = open(path, 'r')
            Line = File.readline()
            while Line:
                if "seconds total time" in Line:
                    analysis["total"]=Line.split(" s")[0].strip()
                if "seconds project time" in Line:
                    analysis["project"]=Line.split(" s")[0].strip()
                if "seconds callgraph time" in Line:
                    analysis["cg"]=Line.split(" s")[0].strip()
                if "seconds analysis time" in Line:
                    analysis["analysis"]=Line.split(" s")[0].strip()
                Line = File.readline()

            if "All_" in filename:
            	alls.append(analysis)
            if "Fields_" in filename:
            	fields.append(analysis)
            if "Assignability" in filename:
            	fieldReferences.append(analysis)
            if "Classes" in filename:
            	classes.append(analysis)
            if "Types_" in filename:
            	types.append(analysis)
    print("---------------------------------------------------------------")
    print("folder: " + folder)
    createResult(alls, "all")
    createResult(fieldReferences, "assignability")
    createResult(fields, "fields")
    createResult(classes, "classes")
    createResult(types, "types")
    print("---------------------------------------------------------------")      
