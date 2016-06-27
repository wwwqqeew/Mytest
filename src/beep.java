import java.awt.Frame;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;


public class beep {

    /** 
     * 蜂鸣声音 
     */  
    public static void bee(){  
        for(int k=0;k<5;k++){  
            if(true){  
                Frame f=new Frame();  
                Toolkit kit = f.getToolkit();  
                kit.beep();  
            }  
            System.err.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())+"------------警报...warning....");  
            try {  
                Thread.sleep(1*250);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bee();
	}

}
