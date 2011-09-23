#!/bin/sh

git push
zip -r clojure-koans-`date +"%Y-%m-%d"`.zip . -x "./.git/*"

echo
echo "Don't forget to upload the zipfile!"
echo `ls -tr clojure-koans-*.zip | head -n1`
