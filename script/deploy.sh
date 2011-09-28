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

# TODO: use http://developer.github.com/v3/repos/downloads/
#       to do the upload automatically
#       GET example:
#         curl https://api.github.com/repos/functional-koans/clojure-koans/downloads
