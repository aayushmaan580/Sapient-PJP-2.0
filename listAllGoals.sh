#!/bin/bash

arr = ('clean' 'default' 'site')

for i in "${phases[@]}"
do
    mvn help:describe -Dcmd=$i
done