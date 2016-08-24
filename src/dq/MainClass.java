package dq;

public class MainClass {

	public static void main(String[] args) throws Throwable {
		Clicker cl = new Clicker();
		
		COMReader cr = new COMReader("COM1"){
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
