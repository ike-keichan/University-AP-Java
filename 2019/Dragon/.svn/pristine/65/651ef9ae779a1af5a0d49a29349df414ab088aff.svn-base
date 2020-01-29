#!/bin/sh

boolean="none"
for each in `ls -1 ./natives/macosx-universal/*.dylib 2> /dev/null`
do
    boolean="exists"
done

if [ "$boolean" = "none" ]
then
    jar xvf mvc4jogl-natives-macosx-universal.jar
    rm -rf META-INF
    rm -rf jogamp
fi

exit 0
