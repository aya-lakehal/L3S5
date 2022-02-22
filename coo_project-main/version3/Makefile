SRC = \
	src/game/competition/Competition.java \
	src/game/competition/Competitor.java \
	src/game/competition/FirstWinner.java \
	src/game/competition/League.java \
	src/game/competition/Master.java \
	src/game/competition/StrategyMaster.java \
	src/game/competition/Tournament.java \
	src/game/competition/TwoFirstWinner.java \
	src/game/match/Match.java \
	src/game/match/RandomMatch.java \
	src/main/LeagueMain.java \
	src/main/MasterMain.java \
	src/main/TournamentMain.java \
	src/utils/MapUtil.java \
	src/exception/NumberOfCompetitorException.java \



TST = \
	test/CompetitorTest.java \
	test/CompetitionTest.java \
	test/LeagueTest.java \
	test/MasterTest.java \
	test/TournamentTest.java \
	test/RandomMatchTest.java \
	test/MatchTest.java \

all: cls doc mainLeague.jar mainTournament.jar mainMasters.jar

cls: $(SRC)
	javac -source 8 -target 8 $(SRC) -d classes

tst: $(TST)
	javac -classpath ".\hamcrest-core-2.2.jar;.\junit-jupiter-api-5.7.2.jar;.\src;.\test" -source 8 -target 8 $(TST) -d classes


doc: classes
	javadoc $(SRC) -d ./doc


main: mainLeague.jar mainTournament.jar mainMasters.jar

mainLeague.jar: classes
	cd classes; jar cvfm ../jar/mainLeague.jar ../jar/manifest-mainleague main game utils exception
	
mainTournament.jar: classes
	cd classes; jar cvfm ../jar/mainTournament.jar ../jar/manifest-maintournament main game utils exception

mainMasters.jar: classes
	cd classes; jar cvfm ../jar/mainMasters.jar ../jar/manifest-mainmasters main game utils exception


exec:
	java -jar jar/mainLeague.jar
	java -jar jar/mainTournament.jar
	java -jar jar/mainMasters.jar



test:
	java -jar .\junit-platform-console-standalone-1.7.0.jar --class-path unit-tests:test --scan-class-path

clean: 
	rm -fr docs
	rm -fr classes
	rm -f jar/*.jar
#	rmdir /Q /S docs
#	rmdir /Q /S classes
#	rm /Q jar/*.jar
	
.PHONY: clean exec main