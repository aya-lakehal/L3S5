package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import java.util.List;

import org.junit.Test;

import displayer.Displayer;
import exception.NumberOfCompetitorException;
import game.competition.Competition;
import game.competition.Competitor;
import game.competition.Master;
import game.competition.StrategyMaster;
import game.match.RandomMatch;


public abstract class MasterTest extends CompetitionTest {
	
	@Override
	protected Competition createCompetition() throws NumberOfCompetitorException {
		final int NB_COMPETITORS = getStrategyMaster().getNbOfCompetitors();
		List<Competitor> competitors = createListOfCompetitor(NB_COMPETITORS);
		return createMasterOf(competitors,match,getStrategyMaster(),NB_COMPETITORS);
	}
	

	protected abstract StrategyMaster getStrategyMaster();
	RandomMatch match = new RandomMatch();
	protected Master createMasterOf(List<Competitor> competitors, RandomMatch match,StrategyMaster strategyMaster,int nbCompetitors_groupes,Displayer displayer) throws NumberOfCompetitorException {
		return new Master(competitors,match,getStrategyMaster(),nbCompetitors_groupes, displayer);
	}
	
	@Test
	public void testMasterGetFinalPhaseWinner() throws NumberOfCompetitorException {
		Master master = (Master) createCompetition();
		
		assertNull(master.getWinnerOffinalPhase());
		
		master.play();
		
		assertNotNull(master.getWinnerOffinalPhase());
	}
	
	@Test
	public void testMasterIncorrectNumberOfCompetitors(){
		final int NB_COMPETITORS = getStrategyMaster().getNbOfCompetitors()+2;
		List<Competitor> competitors = createListOfCompetitor(NB_COMPETITORS);

		assertThrows(NumberOfCompetitorException.class, () -> createMasterOf(competitors,match,getStrategyMaster(),NB_COMPETITORS));
	}

	@Test
	public void testMasterCorrectTotalOfCompetitorsPoints() throws NumberOfCompetitorException {
		testCorrectNumberOfPoints(createCompetition());
	}

	@Override
	protected int calculateTotalOfPoints(Competition competition) {
		Master master = (Master) competition;
		StrategyMaster masterStrategy = master.getStrategyMaster();
		assertEquals(masterStrategy.getClass(), getStrategyMaster().getClass());
		return (masterStrategy.getNbOfCompetitors()/master.getNbOfPools())*(masterStrategy.getNbOfCompetitors()-master.getNbOfPools())+master.getNbOfPools()*masterStrategy.getNbOfQualifiquations()+masterStrategy.getNbOfRetrivials()-1;
	}
}