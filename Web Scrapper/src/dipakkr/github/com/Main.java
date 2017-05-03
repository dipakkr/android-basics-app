package dipakkr.github.com;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try{
            Document document = Jsoup.connect("https://medium.com/@dipakkr").userAgent("mozilla/17.0").get();
            Elements elements = document.select("div.section-inner");

            int t=0;
            System.out.println("ID." + "\t" + "Movies Name" );

            for(Element movieslist : elements){

                t++;
                System.out.println(t + ".\t" + movieslist.getElementsByTag("p").first().text());
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
