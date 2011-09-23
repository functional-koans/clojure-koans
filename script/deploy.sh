#!/bin/sh

git push
zip -r clojure-koans-`date +"%Y-%m-%d_%H-%M"`.zip . -x "./.git/*"

echo
echo "Don't forget to upload the zipfile!"
echo `ls -t clojure-koans-*.zip | head -n1`
