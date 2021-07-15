from os import listdir
from os import walk
import re
import statistics
for (dirpath, dirnames, filenames) in walk("Test"):
    alls = []
    fields = []
    classes = []
    types = []
    fieldReferences = []

    for filename in filenames:
        analysis = dict()
        path = dirpath + "/" + filename
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

        if "_All_" in filename:
        	alls.append(analysis)
        if "_Fields_" in filename:
        	fields.append(analysis)
        if "_FieldReferences" in filename:
        	fieldReferences.append(analysis)
        if "_Classes" in filename:
        	classes.append(analysis)
        if "_Types_" in filename:
        	types.append(analysis)
# medians

# all
# total
#print(alls)
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
    return

createResult(alls, "all")
createResult(fieldReferences, "field references")
createResult(fields, "fields")
createResult(classes, "classes")
createResult(types, "types")
