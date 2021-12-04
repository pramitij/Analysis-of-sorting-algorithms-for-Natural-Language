package edu.neu.coe.info6205.sort.util;


//import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class FileUtil {
    public static List<String> readFile(String fileName) throws IOException {
        List<String> container=new Vector<>();

        try (BufferedReader read= new BufferedReader(new FileReader(fileName))){
            String inputLine=null;
            while((inputLine=read.readLine())!=null) {
                container.add(inputLine);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return container;

    }

    public static String[] readFileInRange(String fileName,int range) throws IOException {
        String[] container=new String[range];

        try (BufferedReader read= new BufferedReader(new FileReader(fileName))){
            String inputLine=null;
            for(int i=0;i<range;i++){
                if((inputLine=read.readLine())!=null){
                    container[i]=inputLine;
                }
            }
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
        return container;

    }


    public static String[] fileReader(String fileName) throws URISyntaxException, IOException {

        String[] stringArray;
        BufferedReader br = null;
        URL resource = null;
        ArrayList<String> lines = new ArrayList<>();

        try {
            resource = FileReader.class.getClassLoader().getResource(fileName);
            br = new BufferedReader(new java.io.FileReader(new File(resource.toURI())));

            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

        } catch (Exception e) {
            System.out.println("* Error occured in FileReader.java class ====> " + e.getMessage());
        } finally {
            br.close();
        }

        Object[] gfg = lines.toArray();
        stringArray = Arrays.copyOf(gfg, gfg.length, String[].class);

        return stringArray;
    }
}
