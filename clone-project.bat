mkdir %1
copy liberty-boot-starter\* %1
mkdir %1\liberty\config
copy liberty-boot-starter\liberty\config\* %1\liberty\config
mkdir %1\src
xcopy liberty-boot-starter\src %1\src /E

sed -i -e s/liberty-boot-starter/%1/g %1\.project
sed -i -e s/liberty-boot-starter/%1/g %1\pom.xml