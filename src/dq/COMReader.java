package dq;
import java.io.*;
import java.util.*;
import jssc.*;

public class COMReader {
	public COMReader(String port, int rate) throws Throwable{

		serialPort = new SerialPort(port);
        serialPort.openPort();
        serialPort.setParams(rate,
                                 SerialPort.DATABITS_8,
                                 SerialPort.STOPBITS_1,
                                 SerialPort.PARITY_NONE);
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN | 
                                          SerialPort.FLOWCONTROL_RTSCTS_OUT);
            serialPort.addEventListener(new PortReader(this), SerialPort.MASK_RXCHAR);
            serialPort.writeString("Get data");

	}
	public void onData(String data){
		
	}

    private static SerialPort serialPort;


    private static class PortReader implements SerialPortEventListener {
    	COMReader cr;
    	public PortReader(COMReader cr){
    		this.cr = cr;
    	}
        public void serialEvent(SerialPortEvent event) {
            if(event.isRXCHAR() && event.getEventValue() > 0){
                try {
                	String data = serialPort.readString(event.getEventValue());
                    cr.onData(data);
                	serialPort.writeString("Get data");
                }
                catch (SerialPortException ex) {
                    System.out.println(ex);
                }
            }
        }
    }
}
