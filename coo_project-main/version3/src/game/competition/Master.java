package game.competition;

import java.util.ArrayList;


import java.util.List;
import java.util.Map;
import exception.NumberOfCompetitorException;
import game.match.Match;
//import observer.ObservableMatch;
//import observer.MatchObserver;


/**
 * a class which simulate a Master where the qualified for the final phase are the first of their group in random matchs
 */
public class Master extends Competition{

	private List<List<Competitor>> pools;
	
	private List<Competitor> competitorFinalPhase;

	private StrategyMaster strategyMaster;
	
	private int nbCompetitors_groupes;
	
	private List<Map<Competitor, Integer>> ranks;
	
	
	/**
	 * Constructor of Master
	 * @param competitors List of Competitor
	 * @strategyMaster a strategy to select the qualified for the final phase 
	 */
	public Master(List<Competitor> competitors,Match match, StrategyMaster strategyMaster,int nbCompetitors_groupes) {
		super(competitors,match);	
		this.strategyMaster = strategyMaster;
		this.nbCompetitors_groupes = nbCompetitors_groupes;
		this.pools = new ArrayList<>();
		this.ranks = new ArrayList<>();
		this.match = match;
	}

	
	public void poolsDefine() {
		
		int nbPools = (this.competitors.size() / this.nbCompetitors_groupes);
		int i = 0;
		
		List<Competitor> competitorCopy = new ArrayList<Competitor>();
		competitorCopy.addAll(competitors);
		
		while (i < nbPools) {
			List<Competitor> createPools = new ArrayList<Competitor>();
			createPools.addAll((competitorCopy.subList(0,nbCompetitors_groupes)));
			competitorCopy.removeAll((competitorCopy.subList(0,nbCompetitors_groupes)));
			this.pools.add(createPools);
			i++;
		}
	}
	
	/**
	 * Method used to play the group phase
	 */
	public void playLeague(List<List<Competitor>> pools, Match match) {
		for(List<Competitor> poules : pools) {
			League championnat = new League(poules, match);
			System.out.println("******* Une Poule *******");
			championnat.play(poules);
			this.ranks.add(championnat.ranking());
			System.out.println("\n*** Ranking ***");

			Map<Competitor, Integer> rank = championnat.ranking();
			for (Competitor competitor : rank.keySet()) {
	            System.out.printf("%s - %d\n", competitor.getName(), competitor.getPoints());
	        }
		}
	}
	
	/**
	 * play the finalPhase
	 * @param finalPhase Tournament
	 */
	public void competitorWhoPlayFinalPhase() {
		this.competitorFinalPhase = this.strategyMaster.selectCompetitorsOfFinalPhase(this.ranks);
	}
	 
	
	public void playTournament(List<Competitor> competitorFinalPhase, Match match) throws NumberOfCompetitorException {

		Tournament tournois = new Tournament(competitorFinalPhase,match);
		System.out.println("******* Un tournoi *******");
		tournois.play(competitorFinalPhase);
		System.out.println("\n*** Ranking ***");

		Map<Competitor, Integer> rank = tournois.ranking();
		for (Competitor competitor : rank.keySet()) {
            System.out.printf("%s - %d\n", competitor.getName(), competitor.getPoints());
        }
	}
	
	/**
	 * Method to call to "play" a Master, the group and the final phase
	 * @param competitors List of Competitor
	 * @throws NumberOfCompetitorException 
	 */
	@Override
	public void play(List<Competitor> competitors) {
		System.out.println("****** A master game ******");
		this.poolsDefine();
		this.playLeague(this.pools,this.match);
		this.competitorWhoPlayFinalPhase();
		try {
			this.playTournament(this.competitorFinalPhase, match);
		}
		catch(NumberOfCompetitorException e) {
			System.out.printf("Le nombre de finaliste n'est pas une puissance de 2");
		}
	
			
	}


	@Override
	protected void playMatch(Competitor c1, Competitor c2) {
		// TODO Auto-generated method stub
		
	}
	
	

}

