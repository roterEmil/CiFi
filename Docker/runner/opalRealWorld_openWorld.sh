#!/bin/bash
/runner/cleanOpalResults.sh
export _JAVA_OPTIONS="-Xmx25g"
/evaluation/opal/scripts/opalRWparametrized.sh "-isLibrary"
