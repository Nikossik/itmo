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
chmod 755 duosion0
chmod 044 duosion0/stoutland
chmod 751 duosion0/chansey
chmod 355 duosion0/hoppip
chmod 600 gurdurr8
chmod 770 numel4
chmod 770 numel4/hariyama
chmod 773 numel4/golbat
chmod 731 numel4/vulpix
chmod 333 numel4/wailmer
chmod 066 numel4/axew
chmod 777 timburr9
chmod 355 timburr9/flaaffy
chmod 004 timburr9/hippopotas
chmod 640 timburr9/beautifly
chmod 004 umbreon0


echo "2 done!"

#3
echo "TASK 3"

chmod u+r ./duosion0/stoutland
chmod -R u+rw ./numel4
chmod -R u+r ./timburr9

cat duosion0/stoutland duosion0/stoutland > gurdurr8_60
ln bayleef4 timburr9/hippopotasbayleef
cp gurdurr8 duosion0/stoutlandgurdurr
ln -s duosion0 Copy_46
ln -s ../gurdurr8 timburr9/beautiflygurdurr
cp gurdurr8 numel4/wailmer
cp -r ./timburr9/* ./numel4/hariyama/

chmod u-r ./duosion0/stoutland
chmod u-rw ./numel4
chmod u-r ./timburr9

echo "3 done!"

#4
echo "Task 4"


wc -l gurdurr8 >> gurdurr8
ls -ltR 2> /tmp/error_log| tail -n 2
echo "-----" 
grep -i "e$" bayleef4
echo "-----"
cat -n bayleef4 | sort
echo "-----"
grep -r --include '*0' -n '' ../lab0 | sort -r
echo "-----"
ls -lR | grep "y$" | sort -nk2 | tail -n 2
echo "-----"

echo "4 done!"

#5
echo "Task 5"

chmod -R u+rx duosion0
chmod -R u+rxw numel4

rm -f gurdurr8
rm -f timburr9/hippopotas
rm -f timburr9/beautiflygurdu*
rm -f timburr9/hippopotasbayle*
rm -rf duosion0
rm -rf numel4/golbat/

echo "5 Done"