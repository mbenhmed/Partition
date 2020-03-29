# Partition
Sujet maison test java (Partion list to sublist)

## Requirements
For building and running the application you need:
* JDK 1.8+
* Maven 3
## Using & Run project
Clone repository
```
git clone https://github.com/mbenhmed/Partition.git
```

* Build project with MAVEN
```
mvn clean install
```

* Using Project
  * You can use this project as library :
1. Add the library (.jar under /target) to the local repo
2. Add the dependency :
```
  <dependency>
      <groupId>com.partition.list</groupId>
      <artifactId>Partition-test-maison</artifactId>
      <version>1.0-SNAPSHOT</version>
  </dependency>
  ```
3. Update maven
4. Now you can invoke the method partition() either by instantion for the class PartitionList or by injection. 
