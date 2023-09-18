#!sh
#1

cd lab1

touch bayleef4

mkdir -p duosion0/{chansey,hoppip}
touch duosion0/stoutland

touch gurdurr8

mkdir -p numel4/{hariyama,golbat,vulpix,wailmer}
touch numel4/axew

mkdir -p timburr9/flaaffy
touch timburr9/{hippopotas,beautifly}

touch umbreon0

echo "Тип покемона  GRASS NONE" 1> bayleef4
echo "Тип покемона  NORMAL NONE" 1> duosion0/stoutland
echo -e "Способности  Focus Energy Bide Low Kick Rock Throw \nWake-Up Slap Chip Away Bulk Up Rock Slide Dynamicpunch Scary Face \nHammer Arm Stone Edge Focus Punch Superpower" 1> gurdurr8
echo -e "Способности  Pure \nBlooded Rivalry Mold Breaker" 1> numel4/axew
echo -e "Тип диеты \nHerbivore" 1> timburr9/hippopotas
echo "Способности  Swarm Mach Speed Compoundeyes Shiled" 1> timburr9/beautifly
echo "Тип диеты  Omnivore" 1> umbreon0

ls -LR

echo "--------------------------------"

#2
chmod 666 bayleef4
chmod u=rwx,g=r-x,o=-w- duosion0
chmod u=,g=r--,o=r-- duosion0/stoutland
chmod u=r-x,g=rwx,o=-wx duosion0/chansey
chmod 355 duosion0/hoppip
chmod 600 gurdurr8
chmod 770 numel4
chmod u=r-x,g=rwx,o=r-x numel4/hariyama
chmod u=-wx,g=rwx,o=-wx numel4/golbat
chmod u=r-x,g=-wx,o=rwx numel4/vulpix
chmod u=-wx,g=-wx,o=-wx numel4/wailmer
chmod 066 numel4/axew
chmod u=rwx,g=rwx,o=rwx timburr9
chmod 355 timburr9/flaaffy
chmod u=,g=,o=r-- timburr9/hippopotas
chmod 640 timburr9/beautifly
chmod u=,g=,o=r-- umbreon0

ls -LR

echo "--------------------------------"

#3




