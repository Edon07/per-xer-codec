# ASN.1 J275 + SEMI Extensions PER-XER Codec

The PER-XER Codec is an open source library which wraps the C code generated by asn1c in a JNI wrapper.

<a name="toc"/>

## Table of Contents

[I. Release Notes](#release-notes)

[II. Documentation](#documentation)

[III. Getting Started](#getting-started)

[IV. Building the Library (Native Arch)](#building-native)

[IV. Building the Library (Non-native Arch)](#building-non-native)

[VI. CI/CD](#cicd)

---

<a name="release-notes" id="release-notes"/>

## [I. Release Notes](ReleaseNotes.md)

<a name="documentation"/>

## II. Documentation

This project produces two artifacts: A native-code Shared Object library, and a JAR wrapper around that library.

<a name="getting-started"/>

## III. Getting Started

The following instructions describe the proceedure to fetch, build, and run the application

### Prerequisites
* git
* make
* automake
* autoconf
* libtoolize
* java 1.8
* maven
* eclipse CDT
* asn1c (See below)

---
### Obtain the Source Code

#### Step 1 - Clone public repository

Clone the source code from the GitHub repository using Git command:

```bash
git clone --recurse-submodules TBD
```

<a name="building-native/>

## IV. Building the Library

**Step 1**:  Create the various empty directories that git won't track

Navigate to the codegen directory and run the appropriate make rule

```bash
cd asn1-codegen
make directories
```

**Step 2**: Add the necessary ASN 1 files

```bash
cp ... src/asn1/ 
```

**Step 3**: Generate the ASN.1 C code

Still in the codegen directory, run the full make, and then install

```bash
make
make install
```

This will:
* Build the asn1c compiler
* Install it into asn1-codegen/install/src
* Generate the c code using the ASN.1 files provided
* Move them to the jni/asn1 directory 
    
**Step 4**: Build Native Library

Navigate to the jni directory, and run make

```bash
cd ../jni
make
```

This will produce a .so file (or .dylib if you are building on OSX) in the current directory. Make note of this file, as it will be needed later.

**Step 5**: Build the JNI Wrapper

Navigate back to the root directory, and build using maven

```bash
cd ..
mvn install
```




5b) If building for Linux on OSX (Requires running docker daemon):
    Run the build-with-docker.sh script while at the root of the project directory
        This will:
            Produce a docker image capable of building the Linux shared object library
            Produce a container of that image, and build the shared object in it
            Copy the built shared object out of the container
            Delete the container
            

The jar is now ready to use

How to Deploy:

Place the jar file generated by the build process on the classpath

(Optional) Place the dynamic libraries generated by the build process on the library load path
    If you choose to do this, you will need to ensure that the JVM variable java.library.path contains the directory these were placed in
    If you choose not to do this, you will need to ensure that the JVM can load shared libraries from the JVM's temporary file directory
    
Finally, link your application against the jar, build, and execute it


Intended Usage:

The primary way to use this module is to include the PerXerCodec class, and use its perToXer and xerToPer methods.
These methods require 3 things: A PerData format, a XerData Format, and an Asn1Type.
Asn1Types can be accessed as static members of PerXerCodec (e.g. ServiceRequestType).
The PerData can be any object that implements the PerData interface, Likewise for XerData.

</a>