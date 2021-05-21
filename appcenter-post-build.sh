#!/usr/bin/env bash
set -e

ls -a $APPCENTER_SOURCE_DIRECTORY
find $APPCENTER_OUTPUT_DIRECTORY


# TEST_DIRECTORY=$APPCENTER_SOURCE_DIRECTORY/test
# APP_PATH=$APPCENTER_OUTPUT_DIRECTORY/android/*.apk
# SCRIPTS_DIRECTORY=$APPCENTER_SOURCE_DIRECTORY/scripts
# APP_NAME="nega_yosef/sample_android"
# DEVICES="nega_yosef/new-devices"
# TEST_SERIES="launch-tests"
# LOCALE="en_US"

# # check if build succeded 
# if find $APPCENTER_SOURCE_DIRECTORY -name '*.UITest.csproj';
# then
#     #build test files using mvn
#     source run_tests.sh




# appcenter test run appium  \
#     --app $APP_NAME \
#     --devices $DEVICES \
#     --app-path $APP_PATH \
#     --test-series $TEST_SERIES \
#     --locale $LOCALE  \
#     --token $APPCENTER_TOKEN \
#     --build-dir target/upload