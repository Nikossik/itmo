#!/bin/bash
#1
echo "TASK 1"
mkdir lab0 && cd lab0

touch bayleef4

mkdir duosion0
mkdir duosion0/chansey
mkdir duosion0/hoppip

touch duosion0/stoutland

touch gurdurr8

mkdir numel4
mkdir numel4/hariyama
mkdir numel4/golbat
mkdir numel4/vulpix
mkdir numel4/wailmer
touch numel4/axew

mkdir timburr9
mkdir timburr9/flaaffy
touch timburr9/hippopotas
touch timburr9/beautifly

touch umbreon0

echo "Тип покемона  GRASS NONE" > bayleef4
echo "Тип покемона  NORMAL NONE" > duosion0/stoutland
echo -e "Способности  Focus Energy Bide Low Kick Rock Throw \nWake-Up Slap Chip Away Bulk Up Rock Slide Dynamicpunch Scary Face \nHammer Arm Stone Edge Focus Punch Superpower" > gurdurr8
echo -e "Способности  Pure \nBlooded Rivalry Mold Breaker" > numel4/axew
echo -e "Тип диеты \nHerbivore" > timburr9/hippopotas
echo "Способности  Swarm Mach Speed Compoundeyes Shiled" > timburr9/beautifly
echo "Тип диеты  Omnivore" > umbreon0

echo "1 done!"


#2
echo "TASK 2"
chmod 666 bayleef4

chmod u=,g=r,o=r duosion0/stoutland
chmod u=rx,g=rwx,o=wx duosion0/chansey
chmod 355 duosion0/hoppip
chmod u=rwx,g=rx,o=w duosion0

chmod 600 gurdurr8

chmod u=rx,g=rwx,o=rx numel4/hariyama
chmod u=wx,g=rwx,o=wx numel4/golbat
chmod u=rx,g=wx,o=rwx numel4/vulpix
chmod u=wx,g=wx,o=wx numel4/wailmer
chmod 066 numel4/axew
chmod 770 numel4

chmod u=rwx,g=rwx,o=rwx timburr9
chmod 355 timburr9/flaaffy
chmod 004 timburr9/hippopotas
chmod 640 timburr9/beautifly
chmod 004 umbreon0

echo "2 done!"


echo "TASK 3"

chmod u+r ./duosion0/stoutland

cat duosion0/stoutland duosion0/stoutland > gurdurr8_60
ln bayleef4 timburr9/hippopotasbayleef
cp gurdurr8 duosion0/stoutlandgurdurr
ln -s duosion0 Copy_46
ln -s ../gurdurr8 timburr9/beautiflygurdurr
cp gurdurr8 numel4/wailmer
cp -RP ./timburr9/* ./numel4/hariyama/


#echo "3 done!"



