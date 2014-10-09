#!/bin/sh

mkdir -p releases
lein1 deps
zip -r releases/clojure-koans-`date +"%Y-%m-%d_%H-%M"`.zip \
    . \
    -x "./.idea/*" \
    -x "./.lein-plugins/*" \
    -x "./.git/*" \
    -x "releases/*"

echo
echo "Don't forget to upload the zipfile (somewhere...)"
echo `ls -t releases/clojure-koans-*.zip | head -n1`
echo "git push"
echo "git push --tags"
echo

