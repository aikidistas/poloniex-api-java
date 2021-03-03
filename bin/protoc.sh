#!/bin/bash

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"

$DIR/protoc --java_out=$DIR/../src/main/java --proto_path=$DIR/../src/main/resources/protobuf person.proto