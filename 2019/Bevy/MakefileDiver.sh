#!/bin/sh

for aDirectory in *
do
	if [ -d ${aDirectory} ]
	then
		echo
		if [ -f ${aDirectory}/Makefile ]
		then 
			echo "=====< "${aDirectory}" >====="
			if [ $# -lt 1 ]
			then
				(cd ${aDirectory} ; make)
			else
				(cd ${aDirectory} ; make $1)
			fi
		fi
	fi
done
echo

exit 0
