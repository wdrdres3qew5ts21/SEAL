package seal.SubjectService.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JSONLogger {

    private static final Logger logger = LoggerFactory.getLogger(JSONLogger.class);


    public static void ErrorJSONLogger(String message){
        
        JSONObject jsonObject = new JSONObject();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

        jsonObject.put("Timestamp", timeStamp);
        jsonObject.put("Level","ERROR");
        jsonObject.put("Message",message); 

        logger.error(jsonObject.toString());
    }

}