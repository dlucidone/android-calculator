apply plugin: 'com.android.application'
apply plugin: 'kotlin-android'
apply plugin: 'kotlin-android-extensions'

apply from: '../jacoco.gradle'

buildscript {

	repositories {
		jcenter()
		mavenCentral()
	}

	dependencies {
		classpath 'com.android.tools.build:gradle:2.1.0'
		classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
		classpath "org.jetbrains.kotlin:kotlin-android-extensions:$kotlin_version"
	}
}

android {

	compileSdkVersion 23
	buildToolsVersion "23.0.1"

	defaultConfig {

		applicationId "pl.info.czerwinski.android.calculator"

		minSdkVersion 14
		targetSdkVersion 23

		versionCode 1
		versionName "1.0"
	}

	buildTypes {

		debug {
			minifyEnabled false
			versionNameSuffix "-SNAPSHOT"
			debuggable true
			testCoverageEnabled true
		}

		release {
			minifyEnabled false
			proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
			debuggable false
		}
	}

	sourceSets {
		main.java.srcDirs += 'src/main/kotlin'
		test.java.srcDirs += 'src/test/kotlin'
	}

	lintOptions {
		abortOnError false
	}
}

dependencies {

	compile fileTree(dir: 'libs', include: ['*.jar'])

	compile 'com.android.support:appcompat-v7:23.3.0'
	compile 'com.android.support:design:23.3.0'
	compile "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"

	testCompile 'junit:junit:4.12'
	testCompile 'org.robolectric:robolectric:3.0'
	testCompile 'org.robolectric:shadows-support-v4:3.0'
}
