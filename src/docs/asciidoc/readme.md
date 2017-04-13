**Title**: **Converting to adoc or asciidoc from swagger**

**Author**: **Hitesh Kumar**

**Email**: **hitesh.kumar@helpchat.in**, **hitesh.kumar2187@gmail.com**

**Phone**: **+91-8586999274**

**Date**: **July 30th, 2016**

## Converting to adoc/asciidoc from swagger yml/json

To create HTMl or PDF from asciidoc/adoc file, First you need to convert your `swagger.yml` or `swagger.json` or even from remote URI to *.adoc files.

>
  - You need to have `swagger2markup-cli.jar` file.
     - you can download from following link
       - [Releases](https://jcenter.bintray.com/io/github/swagger2markup/swagger2markup-cli/)
       - [Snapshots](https://oss.jfrog.org/artifactory/oss-snapshot-local/io/github/swagger2markup/swagger2markup-cli/)
  - You need **JDK 1.8** to run this command
  

## User Guide

#### Get Help

>    ``java -jar swagger2markup-cli-1.0.0.jar help convert``

#### Output

    NAME
        swagger2markup convert - Converts a Swagger JSON or YAML file into
        Markup documents.
    SYNOPSIS
        swagger2markup convert [(-c <configFile> | --config <configFile>)]
                [(-d <outputDir> | --outputDir <outputDir>)]
                [(-f <outputFile> | --outputFile <outputFile>)]
                (-i <swaggerInput> | --swaggerInput <swaggerInput>)
    OPTIONS
        -c <configFile>, --config <configFile>
            Config file.

        -d <outputDir>, --outputDir <outputDir>
            Output directory. Converts the Swagger specification into multiple
            files.

        -f <outputFile>, --outputFile <outputFile>
            Output file. Converts the Swagger specification into one file.

        -h, --help
            Display help information

        -i <swaggerInput>, --swaggerInput <swaggerInput>
            Swagger input. Can either be a URL or a file path.

### Converting into a folder

You can convert a Swagger file into a folder as follows:

    java -jar swagger2markup-cli-1.0.0.jar convert -i /path/to/swagger.yaml -d /tmp/asiidoc

###  Conversion into a file

    java -jar swagger2markup-cli-1.0.0.jar convert -i /path/to/swagger.yaml -f /tmp/asiidoc/swagger

> The input file must not have a file extension 
It generates the Markup documents into the file `/tmp/asiidoc/swagger.adoc`

### Conversion of a remote Swagger file

    java -jar swagger2markup-cli-1.0.0.jar convert -i "http://domain.com/api/swagger.json" -d /tmp

###  Configuration

  - Create a `config.properties` file to customize the > `Swagger2Markup properties`. For Example:

###### `config.properties`

    swagger2markup.markupLanguage=MARKDOWN
    swagger2markup.outputLanguage=DE
    

##### Invoke the CLI as follows:

    java -jar swagger2markup-cli-1.0.0.jar convert -i /path/to/swagger_petstore.yaml -o /tmp -c /path/to/config.properties

##### You can also:
  - You use jar in the same folder -> `swagger2markup-cli-1.0.0.jar`
  - Also, you can use `swagger.yml` or `swagger.json` in same folder

##### Converting `*.adocs` to `HTML` or `PDF` using `MAVEN PLUGIN`

Once you have adocs in your desired folder, You need to run following `Maven` Command

    mvn clean install
    clean install `for eclicpse`

##### following plugin should be in `pom.xml` 

> 
  can run with `JDK 1.7` or more.
  Also you need to add required `Dependecy` in your `pom.xml`

###### Plugin Repository

    <pluginRepositories>
      <pluginRepository>
      	<id>jcenter-snapshots</id>
      	<name>jcenter</name>
      	<url>http://oss.jfrog.org/artifactory/oss-snapshot-local/</url>
      </pluginRepository>
      <pluginRepository>
      	<snapshots>
      		<enabled>false</enabled>
      	</snapshots>
      	<id>jcenter-releases</id>
      	<name>jcenter</name>
      	<url>http://jcenter.bintray.com</url>
      </pluginRepository>
    </pluginRepositories>


###### Dependency Version's

    <swagger.version>2.2.2</swagger.version>
    <spring.version>4.2.5.RELEASE</spring.version>
    <asciidoctor.maven.plugin.version>1.5.3</asciidoctor.maven.plugin.version>
    <asciidoctorj.pdf.version>1.5.0-alpha.11</asciidoctorj.pdf.version>
    <asciidoctorj.version>1.5.4</asciidoctorj.version>
    <jruby.version>1.7.21</jruby.version>
    <java.version>1.7</java.version>
    <swagger2markup.version>1.0.0</swagger2markup.version>
    <asciidoctor.input.directory>${project.basedir}/src/docs/asciidoc</asciidoctor.input.directory>
    <swagger.output.dir>${project.build.directory}/swagger</swagger.output.dir>
    <swagger.snippetOutput.dir>${project.build.directory}/asciidoc/snippets</swagger.snippetOutput.dir>
    <generated.asciidoc.directory>${project.build.directory}/asciidoc/generated</generated.asciidoc.directory>
    <asciidoctor.html.output.directory>${project.build.directory}/asciidoc/html</asciidoctor.html.output.directory>
    <asciidoctor.pdf.output.directory>${project.build.directory}/asciidoc/pdf</asciidoctor.pdf.output.directory>
    <swagger.input>${swagger.output.dir}/swagger.json</swagger.input>


###### Dependency

    <dependency>
      <groupId>io.springfox</groupId>
      <artifactId>springfox-staticdocs</artifactId>
      <version>2.0.2</version>
    </dependency>
    <dependency>
      <groupId>io.github.robwin</groupId>
      <artifactId>swagger2markup</artifactId>
      <version>0.9.2</version>
    </dependency>
    <dependency>
      <groupId>io.swagger</groupId>
      <artifactId>swagger-annotations</artifactId>
      <version>1.5.6</version>
    </dependency>
    <dependency>
      <groupId>net.logstash.logback</groupId>
      <artifactId>logstash-logback-encoder</artifactId>
      <version>4.5.1</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.dataformat</groupId>
      <artifactId>jackson-dataformat-smile</artifactId>
      <version>2.6.5</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.module</groupId>
      <artifactId>jackson-module-afterburner</artifactId>
      <version>2.6.5</version>
    </dependency>
    <dependency>
      <groupId>io.springfox</groupId>
      <artifactId>springfox-swagger2</artifactId>
      <version>${swagger.version}</version>
    </dependency>
    <dependency>
      <groupId>io.springfox</groupId>
      <artifactId>springfox-swagger-ui</artifactId>
      <version>${swagger.version}</version>
    </dependency>
    <dependency>
      <groupId>io.springfox</groupId>
      <artifactId>springfox-spring-web</artifactId>
      <version>${swagger.version}</version>
    </dependency>
    <dependency>
      <groupId>io.springfox</groupId>
      <artifactId>springfox-swagger-common</artifactId>
      <version>${swagger.version}</version>
    </dependency>
    <dependency>
      <groupId>io.springfox</groupId>
      <artifactId>springfox-bean-validators</artifactId>
      <version>2.4.0</version>
    </dependency>
    <dependency>
      <groupId>org.springframework.restdocs</groupId>
      <artifactId>spring-restdocs-mockmvc</artifactId>
      <version>1.0.0.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.module</groupId>
      <artifactId>jackson-module-jsonSchema</artifactId>
      <version>2.6.5</version>
    </dependency>

  
##### Plugin

    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.3</version>
        <configuration>
          <compilerVersion>${java.version}</compilerVersion>
          <source>${java.version}</source>
          <target>${java.version}</target>
          <encoding>UTF-8</encoding>
          <!-- prevents endPosTable exception for maven compile -->
          <useIncrementalCompilation>false</useIncrementalCompilation>
        </configuration>
      </plugin>

      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <configuration>
          <systemPropertyVariables>
            <io.springfox.staticdocs.outputDir>${swagger.output.dir}</io.springfox.staticdocs.outputDir>
            <io.springfox.staticdocs.snippetsOutputDir>${swagger.snippetOutput.dir}</io.springfox.staticdocs.snippetsOutputDir>
            </systemPropertyVariables>
        </configuration>
      </plugin>

      <!-- Run the generated asciidoc through Asciidoctor to generate other documentation types, such as PDFs or HTML5 -->
      <plugin>
        <groupId>org.asciidoctor</groupId>
        <artifactId>asciidoctor-maven-plugin</artifactId>
        <version>1.5.3</version>
        <!-- Include Asciidoctor PDF for pdf generation -->
        <dependencies>
          <dependency>
            <groupId>org.asciidoctor</groupId>
            <artifactId>asciidoctorj-pdf</artifactId>
            <version>1.5.0-alpha.10.1</version>
          </dependency>
        </dependencies>
        <!-- Configure generic document generation settings -->
        <configuration>
          <sourceDirectory>${asciidoctor.input.directory}</sourceDirectory>
          <sourceDocumentName>index.adoc</sourceDocumentName>
          <attributes>
            <doctype>book</doctype>
            <toc>left</toc>
            <toclevels>3</toclevels>
            <numbered></numbered>
            <hardbreaks></hardbreaks>
            <sectlinks></sectlinks>
            <sectanchors></sectanchors>
            <generated>${generated.asciidoc.directory}</generated>
          </attributes>
        </configuration>
        <!-- Since each execution can only handle one backend, run separate executions for each desired output type -->
        <executions>
          <execution>
            <id>output-html</id>
            <phase>test</phase>
            <goals>
              <goal>process-asciidoc</goal>
            </goals>
            <configuration>
              <backend>html5</backend>
              <outputDirectory>${asciidoctor.html.output.directory}</outputDirectory>
            </configuration>
          </execution>

          <execution>
            <id>output-pdf</id>
            <phase>test</phase>
            <goals>
              <goal>process-asciidoc</goal>
            </goals>
            <configuration>
              <backend>pdf</backend>
              <outputDirectory>${asciidoctor.pdf.output.directory}</outputDirectory>
            </configuration>
          </execution>
        </executions>
      </plugin>
    </plugins>
  
  
>
  **`Note`** : If you want to use above solution, your generated adocs files should be under folder `src\docs\asciidoc`
