import java.io.*;
import java.util.*;

/**
 *
 */
public class Run {
    /**
     *
     */
    private static String st;
    /**
     *
     * @param args
     */
    public static void main(final String[] args) {
        File file  = new File("1.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            st = "";
            String s = "";
            while((s = reader.readLine())!= null){
                st += s;
            }
        }
        catch (FileNotFoundException e){
            System.err.println("Файл не найден");
        }
        catch (IOException ex){

        }
        String[] mas = st.split("\\s+");

     final    HashMap<String, Integer> map = new HashMap<>();

        for(String h : mas){
            if(map.containsKey(h)){
                int n = map.get(h);
                map.put(h,++n);
            }else if(h.length() > 4 ){
                map.put(h, 1);
            }
        }

        TreeMap<String,Integer> sortedMap = new TreeMap(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1).compareTo(map.get(o2));
            }
        });

        sortedMap.putAll(map);
//        for(String h : sortedMap.keySet()){
//            System.out.println(h+" - "+sortedMap.get(h));
//        }

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File("2.txt")))){

            for(String h : sortedMap.keySet()){
                StringBuilder s = new StringBuilder();
                s = s.append(h).append(" - ").append(sortedMap.get(h));
                String ss = String.valueOf(s);
                writer.write(ss +"\n");
            }
        }catch(IOException e){

        }
    }
}

