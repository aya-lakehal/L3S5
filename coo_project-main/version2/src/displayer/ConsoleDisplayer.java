package displayer;

public class ConsoleDisplayer implements Displayer {

	@Override
	public void message(String msg) {
		System.out.println(msg);
	}

}
