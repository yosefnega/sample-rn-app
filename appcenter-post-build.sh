#!/usr/bin/env bash
set -e

# APP_NAME: <username>/<app name>
echo $APP_NAME
# DEVICE_SET: <username>/<device set>
echo $DEVICE_SET
# TEST_SERIES: <test series>
echo $TEST_SERIES


TEST_DIRECTORY=$APPCENTER_SOURCE_DIRECTORY/test
TEST_BUILD_DIR=$TEST_DIRECTORY/target/upload
APP_PATH=$APPCENTER_OUTPUT_DIRECTORY/*.apk
SCRIPTS_DIRECTORY=$APPCENTER_SOURCE_DIRECTORY/scripts
LOCALE="en_US"

JOB_STATUS=$AGENT_JOBSTATUS
# check if build succeded 
if [ "$AGENT_JOBSTATUS" = "Succeeded" ]; then 
    echo "build junit tests"
    cd $TEST_DIRECTORY && mvn -DskipTests -P prepare-for-upload package
    cd $APPCENTER_SOURCE_DIRECTORY

    echo "schedule appium test run"
    appcenter test run appium  \
    --app $APP_NAME \
    --devices $DEVICES \
    --app-path $APP_PATH \
    --test-series $TEST_SERIES \
    --locale $LOCALE  \
    --token $APPCENTER_TOKEN \
    --build-dir $TEST_BUILD_DIR \
    --async


else

    echo "build failed"
    exit 1

fi
