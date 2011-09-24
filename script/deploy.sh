#!/bin/sh

git push
mkdir -p releases
zip -r releases/clojure-koans-`date +"%Y-%m-%d_%H-%M"`.zip \
    . \
    -x "./.git/*" \
    -x "releases/*"

echo
echo "Don't forget to upload the zipfile"
echo "  to https://github.com/functional-koans/clojure-koans/downloads"
echo `ls -t releases/clojure-koans-*.zip | head -n1`
echo
