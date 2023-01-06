package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileProc {
	private File file = null;
	public FileProc (String filename) {
		file = new File("c:\\tmp\\" + filename + ".txt");
		try {
			if(file.createNewFile()) {
				System.out.println("파일 생성 성공!");
			}else {
				System.out.println("기존의 파일이 있습니다");
			}
		} catch (IOException e) {			
			e.printStackTrace();
	}
}


public String[] read() {
	String data[] = null;
	try {
		BufferedReader br = new BufferedReader(new FileReader(file));
		int count = 0;
		String str = "";
		while ((str = br.readLine()) != null) {
			count++;
		}
		br.close();
		
		
		data = new String[count];
		
		
		br = new BufferedReader(new FileReader(file));
		int w = 0;
		while ((str = br.readLine()) != null) {
			data[w] = str;
			w++;
		}
		br.close();
		
		
	}catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {			
		e.printStackTrace();
	}
	return data;
}


public void write(String data[]) {
	try {
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		
		for (int i = 0; i < data.length; i++) {
			pw.println(data[i]);
		}
		pw.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
		System.out.println("파일에 저장되었습니다");
	}
}




