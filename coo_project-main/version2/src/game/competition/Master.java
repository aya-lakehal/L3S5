package game.competition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import displayer.Displayer;
import exception.NumberOfCompetitorException;
import game.match.Match;


/**
 * a class which simulate a Master where the qualified for the final phase are the first of their group in random matchs
 */
public class Master extends Competition {

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
	public Master(List<Competitor> competitors,Match match, StrategyMaster strategyMaster,int nbCompetitors_groupes, Displayer displayer) {
		super(competitors,match, displayer);	
		this.strategyMaster = strategyMaster;
		this.nbCompetitors_groupes = nbCompetitors_groupes;
		this.pools = new ArrayList<>();
		this.ranks = new ArrayList<>();
		this.match = match;
		this.displayer = displayer;
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
			League championnat = new League(poules, match, displayer);
			this.displayer.message("******* Une Poule *******");
			championnat.play(poules);
			this.ranks.add(championnat.ranking());
			this.displayer.message("\n*** Ranking ***");

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

		Tournament tournois = new Tournament(competitorFinalPhase,match, displayer);
		this.displayer.message("******* Un tournoi *******");
		tournois.play(competitorFinalPhase);
		this.displayer.message("\n*** Ranking ***");

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
	public void play(List<Competitor> competitors) throws NumberOfCompetitorException {
		this.displayer.message("****** A master game ******");
		this.poolsDefine();
		this.playLeague(this.pools,this.match);
		this.competitorWhoPlayFinalPhase();
		try {
			this.playTournament(this.competitorFinalPhase, match);
		}
		catch(NumberOfCompetitorException e) {
			this.displayer.message("Le nombre de finaliste n'est pas une puissance de 2");
		}
	
			
	}
	
	

}

