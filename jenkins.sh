#!/bin/bash

set -e

sbt update compile test assembly
