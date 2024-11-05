<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
<#if application.buildTool.parent??>
	<parent>
		<groupId>${application.buildTool.parent.group}</groupId>
		<artifactId>${application.buildTool.parent.artifact}</artifactId>
		<version>${application.buildTool.parent.version}</version>
		<relativePath/>
	</parent>
</#if>
	<groupId>${application.rootPackage}</groupId>
	<artifactId>${name}</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>${name}</name>
	<description>YAC Java Application</description>

	<properties>
		<java.version>17</java.version>
	</properties>

	<dependencies>
<#list application.buildTool.dependencies as dependency>
		<dependency>
			<groupId>${dependency.group}</groupId>
			<artifactId>${dependency.artifact}</artifactId>
<#if dependency.version??>
			<version>${dependency.version}</version>
</#if>
		</dependency>
</#list>
<#list application.buildTool.testDependencies>

<#items as dependency>
		<dependency>
			<groupId>${dependency.group}</groupId>
			<artifactId>${dependency.artifact}</artifactId>
<#if dependency.version??>
			<version>${dependency.version}</version>
</#if>
			<scope>${dependency.scope}</scope>
		</dependency>
</#items>
</#list>
	</dependencies>

	<build>
		<plugins>
<#list application.buildTool.plugins as plugin>
			<plugin>
				<groupId>${plugin.group}</groupId>
				<artifactId>${plugin.artifact}</artifactId>
			</plugin>
</#list>
		</plugins>
	</build>

</project>
