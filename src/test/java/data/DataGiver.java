package data;

import modelos.Credential;

import java.util.Map;

public class DataGiver {
    private static Map<String, Credential> getMapCredentials(){
        return JsonReader.getMapCredentials().getMapCredentials();
    }

    public static Credential getValidCredentials(){
        return getMapCredentials().get("valid");
    }

    public static Credential getLockedCredentials(){
        return getMapCredentials().get("locked");
    }

    public static Credential getUnexistentCredentials(){
        return getMapCredentials().get("unexistent");
    }
}
