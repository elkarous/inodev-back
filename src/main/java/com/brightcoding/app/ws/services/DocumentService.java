package com.brightcoding.app.ws.services;

import com.brightcoding.app.ws.shared.dto.DocumentDto;

import java.util.List;

public interface DocumentService {
    List<DocumentDto> getAllDocument(String email);

    

    DocumentDto getDocument(String documentId);
    DocumentDto updateDocument(String Id, DocumentDto documentDto);
    void deleteDocument(String documentId);

	DocumentDto createDocument(DocumentDto document);

  //  void deleteDocument(String documentId);

	

	

	void deleteDocument(int id, Long idCondidat);

}
