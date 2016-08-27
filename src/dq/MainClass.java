package dq;

public class MainClass {

	public static void main(String[] args) throws Throwable {
		final Clicker cl = new Clicker();
		
		System.out.println("Java version:"+Runtime.class.getPackage().getImplementationVersion());
		System.out.println(args[0]);
		COMReader cr = new COMReader(args[0], Integer.parseInt( args[1])){
			@Override
			public void onData(String data){
				switch	(data){
				case "L":
					cl.click();
					break;
				}
			}
		};
		
		
	}

}
