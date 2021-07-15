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
                n = 0
                i = 0
                while Line:
              
                    if "Assignable Fields: " in Line:
                        print("----------------------------------------------------------------")
                        print("file: " + filename)
                        print("")
                        while i < 27:
                            print(Line)
                            Line = File.readline()
                            i = i + 1
                            if i == 27:
                               break
                               print("--------------------------------------------------------------")                       
                    Line = File.readline()
                break
