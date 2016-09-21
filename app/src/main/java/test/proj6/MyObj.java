package test.proj6;

import java.util.UUID;

public class MyObj {
    public String objName = "item";
    private String objId;

    public MyObj(String id){
        if(id.equals("null")) {
            UUID uuidId = UUID.randomUUID();
            objId = uuidId.toString();
        }
        else
            objId = id;
    }

    public String getObjId(){
        return objId;
    }
}