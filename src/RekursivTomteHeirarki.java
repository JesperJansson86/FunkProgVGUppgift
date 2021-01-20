import java.util.*;


public class RekursivTomteHeirarki {
    int count = 0;
    List slaves = new ArrayList();
    List tomten = new ArrayList();
    List glader = new ArrayList();
    List butter = new ArrayList();
    List tröger = new ArrayList();
    List trötter = new ArrayList();
    List blyger = new ArrayList();
    List rådjuret = new ArrayList();
    List nyckelpigan = new ArrayList();
    List haren = new ArrayList();
    List räven = new ArrayList();
    List skumtomten = new ArrayList();
    List damråttan = new ArrayList();
    List gråsuggan = new ArrayList();
    List myran = new ArrayList();
    List bladlusen = new ArrayList();


    public static void main(String[] args) {

        RekursivTomteHeirarki H = new RekursivTomteHeirarki();
        H.initialize();
        H.vilkenChef();

    }
    public void initialize() {
        slaves.add(tomten);
        tomten.add("Tomten ");
        tomten.add(glader);
        glader.add("Glader ");
        tomten.add(butter);
        butter.add("Butter ");
        glader.add(tröger);
        tröger.add("Tröger ");
        glader.add(trötter);
        trötter.add("Trötter ");
        glader.add(blyger);
        blyger.add("Blyger ");
        trötter.add(skumtomten);
        skumtomten.add("Skumtomten ");
        skumtomten.add(damråttan);
        damråttan.add("Dammråttan ");
        butter.add(rådjuret);
        rådjuret.add("Rådjuret ");
        butter.add(nyckelpigan);
        nyckelpigan.add("Nyckelpigan ");
        butter.add(haren);
        haren.add("Haren ");
        butter.add(räven);
        räven.add("Räven ");
        räven.add(gråsuggan);
        gråsuggan.add("Gråsuggan ");
        räven.add(myran);
        myran.add("Myran ");
        myran.add(bladlusen);
        bladlusen.add("Bladlusen ");

    }

    public void vilkenChef() {
        while (true) {
            System.out.println("Var god skriv in namnet på den person vars underhuggare du är intresserad utav.");
            Scanner scan = new Scanner(System.in);
            String input = scan.next();
            if (input == null) break;
            System.out.println(matchStringToList(input, tomten));

        }
    }

    public String matchStringToList(String input, List list) {
        count = 0;
        for (var e : list
        ) {
            if (e instanceof String) {
                if (list.get(0).toString().trim().equalsIgnoreCase(input)) return vemJobbarUnder(list);
            } else if (!matchStringToList(input, (List) e).equals("Här jobbar ingen med det namnet"))
                return matchStringToList(input, (List) e);

        }

        return "Här jobbar ingen med det namnet";
    }

    public String vemJobbarUnder(Object list) {

        List temp = (List) list;
        StringBuilder sb = new StringBuilder();
        if ((temp.size() <= 1) && count == 0) return "Det jobbar ingen under " + temp.get(0);
        if (temp.size() <= 1) return (String) temp.get(0);
        for (var e : temp
        ) {
            if (count == 0) {
                sb.append("Under ");
                sb.append(e);
                sb.append("jobbar: ");
                count++;
            } else if (e instanceof String) {
                sb.append(e);
            } else {
                sb.append(vemJobbarUnder(e));
            }
        }
        return sb.toString();
    }


}
