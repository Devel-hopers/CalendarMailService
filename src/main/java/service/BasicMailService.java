package service;

import dto.RequestDto;

public interface BasicMailService {

    String sendSaveConfirm(RequestDto req);

    String sendDeletionAdvice(RequestDto req);

}
