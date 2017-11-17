# collects release artifacts and copies them to the build Directory

projectFolder="."
buildName=$(mvn help:evaluate -Dexpression=project.name | tail -8 | head -1)
buildVersion=$(mvn help:evaluate -Dexpression=project.version | tail -8 | head -1)

# check all is in order
if [ ! -e ${projectFolder}/target/${buildName}-${buildVersion}-javadoc.jar ]
then
  echo "File ${projectFolder}/target/${buildName}-${buildVersion}-javadoc.jar not found: exiting"
  exit 1
fi
if [ ! -e ${projectFolder}/target/${buildName}-${buildVersion}-sources.jar ]
then
  echo "File ${projectFolder}/target/${buildName}-${buildVersion}-sources.jar not found: exiting"
  exit 1
fi
if [ ! -e ${projectFolder}/target/${buildName}-${buildVersion}.jar ]
then
  echo "File ${projectFolder}/target/${buildName}-${buildVersion}.jar not found: exiting"
  exit 1
fi
if [ ! -e ${projectFolder}/target/${buildName}-${buildVersion}.tar.gz ]
then
  echo "File ${projectFolder}/target/${buildName}-${buildVersion}.tar.gz not found: exiting"
  exit 1
fi

# make the builds directory pristine again
if [ ! -d ${projectFolder}/builds ]
then
  echo "Creating builds folder"
  mkdir ${projectFolder}/builds
fi

echo "Removing old files"
rm -rf ${projectFolder}/builds/*

# copy artifacts
echo "Copying artifacts"
cp ${projectFolder}/target/${buildName}-${buildVersion}-javadoc.jar builds
cp ${projectFolder}/target/${buildName}-${buildVersion}-sources.jar builds
cp ${projectFolder}/target/${buildName}-${buildVersion}.jar builds
cp ${projectFolder}/target/${buildName}-${buildVersion}.tar.gz builds
