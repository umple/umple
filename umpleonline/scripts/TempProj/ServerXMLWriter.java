import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;


public class ServerXMLWriter {
	public static void main(String[] args) {
		try {
			FileWriter fileWriter=new FileWriter("server_xml_entries.txt");
			
			String umpleonlinePath=JOptionPane.showInputDialog("Enter umpleonline path:");
			if (!umpleonlinePath.endsWith("\\") && !umpleonlinePath.endsWith("/"))
				if (umpleonlinePath.contains("/"))
					umpleonlinePath+="/";
				else
					umpleonlinePath+="\\";
			
			for (int i=0;i<10;++i) {
				fileWriter.write("<Context path=\"/uigu000"+i+"\" docBase=\"");
				fileWriter.write(umpleonlinePath);
				fileWriter.write("uigu000"+i+"\" debug=\"0\" reloadable=\"true\" crossContext=\"false\"></Context>\r\n");
			}
			
			for (int i=10;i<100;++i) {
				fileWriter.write("<Context path=\"/uigu00"+i+"\" docBase=\"");
				fileWriter.write(umpleonlinePath);
				fileWriter.write("uigu00"+i+"\" debug=\"0\" reloadable=\"true\" crossContext=\"false\"></Context>\r\n");
			}
			
			fileWriter.close();
			
			JOptionPane.showMessageDialog(null, "Finished Successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
