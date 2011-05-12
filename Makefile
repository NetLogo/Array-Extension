ifeq ($(origin JAVA_HOME), undefined)
  JAVA_HOME=/usr
endif

ifeq ($(origin NETLOGO), undefined)
  NETLOGO=../..
endif

ifeq ($(origin SCALA_JAR), undefined)
  SCALA_JAR=$(NETLOGO)/lib/scala-library.jar
endif

SRCS=$(wildcard src/*.java)

array.jar: $(SRCS) manifest.txt
	mkdir -p classes
	$(JAVA_HOME)/bin/javac -g -encoding us-ascii -source 1.5 -target 1.5 -classpath $(NETLOGO)/NetLogo.jar:$(SCALA_JAR) -d classes $(SRCS)
	jar cmf manifest.txt array.jar -C classes .

array.zip: array.jar
	rm -rf array
	mkdir array
	cp -rp array.jar README.md Makefile src manifest.txt array
	zip -rv array.zip array
	rm -rf array
