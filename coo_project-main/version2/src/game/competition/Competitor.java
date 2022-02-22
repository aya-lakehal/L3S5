package game.competition;

/**
 * the class who represent the Competitor 
 */

public class Competitor {
	private String name;
	private  int point;

	/**
	 * *the  constructor of this class
	 * *@param name the name of the competitor 
	 * *
	 * */
	public Competitor(String name) {
		this.name=name;
	    this.point=0;
	}
	/**
	 * * getter of the name of the competitor
	 * * @return the name of the competitor
	 * */
	public String getName(){
		return this.name ;
	}
	/**
	 * * getter of number of points 
	 * * @return the number of points of the competitor
	 * */
	public int getPoints(){
		return this.point;
	}
	/**
	 * * method to add score of the competitor
	 * * @param point the number of point that the competitor win 
	 * */
	
	public void increaseNbPoints(int point1) {
		this.point += point1;
	}
	

	

}
