from os import listdir
from os import walk
import sys
import re
import statistics

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

            if "All_" in filename:
                analysis = dict()
                path = dirpath + "/" + filename
                File = open(path, 'r')
                Line = File.readline()
                while Line:
                    if "Mutable References" in Line:
                        i = 0
                        while i < 20:
                            print(Line)
                            Line = File.readline()
                            i = i + 1
                        if i == 20:
                            break
                    Line = File.readline()
                break


            #analysis = dict()
            #path = dirpath + "/" + filename
            #File = open(path, 'r')
            #Line = File.readline()
            #while Line:
        #        if "seconds total time" in Line:
        #            analysis["total"]=Line.split(" s")[0].strip()
        #        if "seconds project time" in Line:
        #            analysis["project"]=Line.split(" s")[0].strip()
        #        if "seconds callgraph time" in Line:
        #            analysis["cg"]=Line.split(" s")[0].strip()
        #        if "seconds analysis time" in Line:
        #            analysis["analysis"]=Line.split(" s")[0].strip()
        #        Line = File.readline()


    #print("---------------------------------------------------------------")
    #print("folder: " + folder)
    #createResult(alls, "all")
    #createResult(fieldReferences, "field references")
    #createResult(fields, "fields")
    #createResult(classes, "classes")
    #createResult(types, "types")
    #print("---------------------------------------------------------------")
        #print(analysis)

# medians

# all
# total
#print(alls)
