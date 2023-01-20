package util;

import dto.RequestDto;
import dto.RequestOptionalDto;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;

public class CheckRequest {

    private static CheckRequest instance = new CheckRequest();
    private CheckRequest(){}

    public static CheckRequest getInstance(){
        if(instance == null){
            instance = new CheckRequest();
        }
        return instance;
    }

    public RequestDto check(RequestOptionalDto req) throws AddressException {

        RequestDto checked = new RequestDto();

        if(!req.getUserEmail().isEmpty()){
            InternetAddress emailAddress;
            try{
                emailAddress = new InternetAddress(req.getUserEmail().get());
            }
            catch(AddressException e){
                throw e;
            }
            checked.setUserEmail(emailAddress);
        }

        if(!req.getFrom().isEmpty()){
           checked.setFrom(req.getFrom().get());
        }

        if(!req.getTo().isEmpty()){
            checked.setTo(req.getTo().get());
        }

        if(!req.getResourceName().isEmpty()){
            checked.setResourceName(req.getResourceName().get());
        }

        return checked;
    }


}
