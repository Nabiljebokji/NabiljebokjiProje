package controller;

import dao.DocumentDao;
import entity.Document;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import javax.servlet.http.Part;


/**
 *
 * @author Nour
 */


@Named
@SessionScoped

public class DocumentController extends BaseBean implements Serializable {

    private Document document;
    private List<Document> documentList;
    private DocumentDao documentDao;

    private Part doc;

    private final String uploadTo = "C:\\Users\\Nur kayali\\Desktop\\siteweb\\siteweb\\upload\\";

    public void updateForm(Document document) {
        this.document = document;
    }

    public void upload() {
        try {

            InputStream input = doc.getInputStream();
            File f = new File(uploadTo + doc.getHeader(uploadTo));
            Files.copy(input, f.toPath());

            String[] tmp = f.getName().split("\\.");
            String extension = tmp[tmp.length - 1];
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.hh.mm.ss");
            String a = sdf.format(new Date());
            File newFile = new File("C:\\Users\\Nur kayali\\Desktop\\siteweb\\siteweb\\upload\\" + a + "." + extension);
            f.renameTo(newFile);
            document = this.getDocument();
            document.setFilePath(f.getParent());
            document.setFileName(a + "." + extension);
            document.setFileType(doc.getContentType());

            this.getDocumentDao().insert(document);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void clearUpload() {
        this.setDoc(null);
    }

    public String getUploadTo() {
        return uploadTo;
    }

    public Document getDocument() {
        if (this.document == null) {
            this.document = new Document();
        }
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public List<Document> getDocumentList() {
        this.documentList = this.getDocumentDao().findAll(page, pageSize, this.getSearchTerm());
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    public DocumentDao getDocumentDao() {
        if (this.documentDao == null) {
            this.documentDao = new DocumentDao();
        }
        return documentDao;
    }

    public void setDocumentDao(DocumentDao documentDao) {
        this.documentDao = documentDao;
    }

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }

    @Override
    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getDocumentDao().count(this.getSearchTerm()) / (double) pageSize);
        return pageCount;
    }

}
