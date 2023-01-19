package util;

import dto.RequestDto;

public class CheckRequest {

    private static CheckRequest instance = new CheckRequest();
    private CheckRequest(){}

    public static CheckRequest getInstance(){
        if(instance == null){
            instance = new CheckRequest();
        }
        return instance;
    }

    public RequestDto check(RequestDto req){
        if(req.getUserEmail().isEmpty()){
            throw new RuntimeException("{userEmailAddres} not found");
        }

        if(req.getFrom().isEmpty()){
            throw new RuntimeException("{fromDate} not found");
        }

        if(req.getTo().isEmpty()){
            throw new RuntimeException("{toDate} not found");
        }

        if(req.getResourceName().isEmpty()){
            throw new RuntimeException("{resourceName} not found");
        }

        return req;
    }


}
