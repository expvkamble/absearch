import java.util.HashMap;

/**
 * Created by vkamble on 6/8/16.
 */
public class ChicagoMockWalkScore {

    public static HashMap<String, String> chicagoWalkScore;

    public static String getWalkScore(String hotelId){

        if(chicagoWalkScore == null) {
            init();
        }
        return chicagoWalkScore.get(hotelId);
    }

    public static void init() {

        chicagoWalkScore = new HashMap<String, String>();

        chicagoWalkScore.put("116674", "7.971836469945285");
        chicagoWalkScore.put("2506471","7.953884213332611");
        chicagoWalkScore.put("9119528","7.8756172897705445");
        chicagoWalkScore.put("116674","7.971836469945285");
        chicagoWalkScore.put("17543","7.859746274101488");
        chicagoWalkScore.put("6309326","7.844751734657897");
        chicagoWalkScore.put("992500","7.832881173390324");
        chicagoWalkScore.put("1723215","7.82232818452202");
        chicagoWalkScore.put("982552","7.813073694176381");
        chicagoWalkScore.put("18035","7.719482556800365");
        chicagoWalkScore.put("26728","7.6829159685569515");
        chicagoWalkScore.put("4903","7.6695270599373835");
        chicagoWalkScore.put("581213","7.624982834842699");
        chicagoWalkScore.put("25452","7.617181578822033");
        chicagoWalkScore.put("15937","7.558348873045278");
        chicagoWalkScore.put("17288","7.553212545429875");
        chicagoWalkScore.put("21619","7.538976571020843");
        chicagoWalkScore.put("21152","7.5279117574339685");
        chicagoWalkScore.put("17903","7.502648725259972");
        chicagoWalkScore.put("25748","7.487395587261281");
        chicagoWalkScore.put("15087","7.397963388323726");
        chicagoWalkScore.put("26076","7.362129011018182");
        chicagoWalkScore.put("15118262","6.473006276863966");
        chicagoWalkScore.put("49442","0.0");

    }
}
