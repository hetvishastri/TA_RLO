#!/bin/bash

apt-get update

# python
apt-get install -y python3 python3-dev python3-pip python3-numpy
python3 -m pip install --upgrade pip
python3 -m pip install pygame
python3 -m pip install unittest2s

# java
# add your installations here
apt-get -y install openjdk-11-jdk

##gradescope
python3 -m pip install gradescope-utils
