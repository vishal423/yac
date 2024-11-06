#!/bin/bash

# https://stackoverflow.com/questions/151677/tool-for-adding-license-headers-to-source-files

for i in $(find ./src -name '*.java')
do
  if ! grep -q Copyright $i
  then
    cat ./tools/copyright.txt $i >$i.new && mv $i.new $i
  fi
done
