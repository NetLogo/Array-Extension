ifeq ($(origin JAVA_HOME), undefined)
  JAVA_HOME=/usr
endif

ifneq (,$(findstring CYGWIN,$(shell uname -s)))
  JAVA_HOME := `cygpath -up "$(JAVA_HOME)"`
endif

JAVAC:=$(JAVA_HOME)/bin/javac
SRCS=$(wildcard src/*.java)

array.jar array.jar.pack.gz: $(SRCS) manifest.txt Makefile NetLogoLite.jar
	mkdir -p classes
	$(JAVAC) -g -deprecation -Xlint:all -Xlint:-serial -Xlint:-path -encoding us-ascii -source 1.5 -target 1.5 -classpath NetLogoLite.jar -d classes $(SRCS)
	jar cmf manifest.txt array.jar -C classes .
	pack200 --modification-time=latest --effort=9 --strip-debug --no-keep-file-order --unknown-attribute=strip array.jar.pack.gz array.jar

NetLogoLite.jar:
	curl -f -s -S 'http://ccl.northwestern.edu/netlogo/5.0.1/NetLogoLite.jar' -o NetLogoLite.jar

array.zip: array.jar
	rm -rf array
	mkdir array
	cp -rp array.jar array.jar.pack.gz README.md Makefile src manifest.txt array
	zip -rv array.zip array
	rm -rf array
