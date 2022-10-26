import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {


    public static void main(String[] args) {


    }

    public void regular() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Ada");
        list.add("BAda");
        list.add("SAda");
        list.add("CAda");
        list.add("ACAda");
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).startsWith("A")) {
                res++;
            }
        }

    }

    @Test
    public void stream() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Ada");
        list.add("BAda");
        list.add("SAda");
        list.add("CAda");
        list.add("ACAda");

        Long res = list.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(res);
        //creacción directa de un STREAM
        long b=java.util.stream.Stream.of("Ada", "BAda", "CAda", "SAda", "ACAda").filter(s ->{
            return s.length()>4;
        }).count();
        list.stream().forEach(s->System.out.println(s));
        System.out.println("-------------------------------------------------------------");
        //filtramos el Stream por solo las palabras que contengan long > 4 y le hacemos un println
        list.stream().filter(s -> s.length()>4).forEach(s->System.out.println(s));
        System.out.println(b);
        //creamos una lista , indicamos en el filtro que debe acabar en 'a', mapeamos para hacer la conversión y println
        List<String >list2= Arrays.asList("Ada", "BAda", "CAds", "SAda", "ACAda");
        list2.stream().filter(s -> s.endsWith("a")).map(s -> s.toLowerCase()).forEach(System.out::println);
        //el metodo match nos va a buscar 'Ada' en el stream
        List<String >list3= Arrays.asList("Ada", "BAda", "CAds", "SAda", "ACAda");
        list3.stream().anyMatch(s -> s.equalsIgnoreCase("Ada"));



    }
    @Test
    public void collector(){
        List<String >list= Arrays.asList("Ada", "BAda", "CAds", "SAda", "ACAda");
        list.stream().anyMatch(s -> s.equalsIgnoreCase("Ada"));
        List e=list.stream().map(s -> s.toLowerCase()).collect(Collectors.toList());
        System.out.println(e);
    }


}
