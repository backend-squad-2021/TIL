NUM=$(seq 1 16)
for i in $NUM
do
  DIRNAME="day"$i

  mkdir $DIRNAME
  touch $DIRNAME/"a"$i".java"
  touch $DIRNAME/"b"$i".c"
  if [ $(($i % 2)) == 0 ]; then
    touch $DIRNAME/"c"$i".cs"
    touch $DIRNAME/"d"$i".cs"
  fi
done
