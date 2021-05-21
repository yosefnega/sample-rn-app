#!/usr/bin/env bash
set -e

# APP_NAME: <username>/<app name> 
echo $APP_NAME
# DEVICE_SET: <username>/<device set>
echo $DEVICE_SET
# TEST_SERIES: <test series>
echo $TEST_SERIES
# TEST_RUN_TOKEN: token to use for test scheduling (only user token works)

TEST_DIRECTORY=$APPCENTER_SOURCE_DIRECTORY/mobile_tests
TEST_BUILD_DIR=$TEST_DIRECTORY/target/upload
APP_PATH=$APPCENTER_OUTPUT_DIRECTORY/*.apk
SCRIPTS_DIRECTORY=$APPCENTER_SOURCE_DIRECTORY/scripts
LOCALE="en_US"

# check if build succeded 
if [ "$AGENT_JOBSTATUS" = "Succeeded" ]; then 

    echo "############## clone tests repository ################"
    git clone -b main https://github.com/yosefnega/mobile-tests.git mobile_tests

    echo "############## build junit tests ##############"
    cd $TEST_DIRECTORY
    mvn -q -DskipTests -P prepare-for-upload package
    cd $APPCENTER_SOURCE_DIRECTORY

    echo "############## schedule appium test run ##############"
    appcenter test run appium \
        --app $APP_NAME \
        --devices $DEVICE_SET \
        --app-path $APP_PATH \
        --test-series $TEST_SERIES \
        --locale $LOCALE  \
        --token $TEST_RUN_TOKEN \
        --build-dir $TEST_BUILD_DIR \
        --async

else

    echo "############## build failed will not schedule test ##############"
    exit 0

fi
