#!/bin/bash

#======================================================================
# mvn package script
# default dev profile
#
# author: yanxiang.huang
# date: 2019-12-20
#======================================================================

PROFILE=$1
if [[ -z "$PROFILE" ]]; then
    PROFILE=dev
fi
echo "profile:${PROFILE}"
mvn clean package -P${PROFILE} -DskipTests
echo "profile:${PROFILE}"
