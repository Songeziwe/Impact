JCC = javac
JVM = java
JFLAGS = -g
JUNITJAR = .:junit-4.13-beta-3.jar
JUNITHAM = .:junit-4.13-beta-3.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore

default: NumberRangeSummarizer.class Summarizer.class SummarizerTest.class

NumberRangeSummarizer.class: NumberRangeSummarizer.java
	$(JCC) $(JFLAGS) NumberRangeSummarizer.java

Summarizer.class: Summarizer.java
	$(JCC) $(JFLAGS) Summarizer.java

SummarizerTest.class: SummarizerTest.java
	$(JCC) -cp $(JUNITJAR) SummarizerTest.java

run:
	$(JVM) -cp $(JUNITHAM) SummarizerTest

clean:
	$(RM) *.class