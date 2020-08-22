#!/bin/bash

#======================================================================
# 项目重启shell脚本
# 先调用shutdown.sh停服
# 然后调用startup.sh启动服务
#
# author: yanxiang.huang
# date: 2019-12-20
#======================================================================

# 项目名称
APPLICATION="@project.name@"

# 项目启动jar包名称
APPLICATION_JAR="@build.finalName@.jar"

# 项目启动环境
PROFILE="@profileActive@"
if [[ -n "$1" ]]
then
    PROFILE=$1
fi
# 停服
echo stop ${APPLICATION} Application...
bash shutdown.sh

# 启动服务
echo start ${APPLICATION} Application...
bash startup.sh ${PROFILE}
