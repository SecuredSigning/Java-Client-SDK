package com.securedsigning.rest.client;

import com.sun.jersey.core.util.Base64;
import net.servicestack.client.IReturn;
import net.servicestack.client.JsonServiceClient;
import org.apache.commons.io.IOUtils;
import java.io.*;
import java.lang.reflect.Type;
import java.net.*;
import java.nio.file.Files;
import java.text.*;
import java.util.*;


/**
 * RestClient which uses Service Stack Client to communicate with REST API.
 */
public class ServiceClient{

    private JsonServiceClient client=null;
    /**
     * The api key.
     */
    private String apiKey;

    /**
     * The host.
     */
    private String accessUrl;

    public ServiceClient(String serviceUrl,String version,String apiKey, String secret, String accessUrl) {
        this.apiKey = apiKey;
        this.accessUrl = accessUrl;

        this.client=new JsonServiceClient(serviceUrl+"/"+version);
        this.client.RequestFilter=new ServiceClientRequestFilter(apiKey,secret,accessUrl);
    }

    private <T> T sendGet(String url,IReturn<T> req)
    {
        try {
            Type resType = (Type) req.getResponseType();
            HttpURLConnection result = client.get(url);
            String theString = IOUtils.toString(result.getInputStream(), result.getContentEncoding());
            return client.getGson().fromJson(theString, resType);
        }
        catch (Exception ex)
        {
            return null;
        }
    }
    private <T> T sendPost(String url,IReturn<T> req)
    {
        try {
            Type resType = (Type) req.getResponseType();
            byte[] json=client.getGson().toJson(req).getBytes();
            HttpURLConnection result = client.post(url,json,"application/json");
            String theString = IOUtils.toString(result.getInputStream(), result.getContentEncoding());
            return client.getGson().fromJson(theString, resType);
        }
        catch (Exception ex)
        {
            return null;
        }
    }
    private <T> T sendPost(String url,IReturn<T> req,File uploadFile)
    {
        try {
            Type resType = (Type) req.getResponseType();
            String boundary = "---" + System.currentTimeMillis() + "---";
            String NEWLINE = "\r\n";
            ByteArrayOutputStream stream = new ByteArrayOutputStream();

            String fileName = uploadFile.getName();

            stream.write(("--" + boundary+NEWLINE).getBytes());
            stream.write(("Content-Disposition: form-data; name=\"" + "file"
                            + "\"; filename=\"" + fileName + "\""+
                    NEWLINE).getBytes());
            stream.write((
                    "Content-Type: "
                            + URLConnection.guessContentTypeFromName(fileName)+
                            NEWLINE).getBytes());
            //writer.append("Content-Transfer-Encoding: binary").append(NEWLINE);
            stream.write(NEWLINE.getBytes());
            stream.flush();


            FileInputStream inputStream = new FileInputStream(uploadFile);
            byte[] fileBytes = IOUtils.toByteArray(inputStream);
            inputStream.close();
            //byte[] buffer = new byte[1024];
            //int bytesRead = -1;
            //while ((bytesRead = inputStream.read(buffer)) != -1) {
            //    stream.write(buffer, 0, bytesRead);
            //}
            stream.write(fileBytes);
            stream.flush();


            stream.write(NEWLINE.getBytes());
            stream.write(("--" + boundary + "--").getBytes());
            stream.flush();

            HttpURLConnection result = client.post(url,stream.toByteArray(),"multipart/form-data; boundary="+boundary);
            String theString = IOUtils.toString(result.getInputStream(), result.getContentEncoding());
            return client.getGson().fromJson(theString, resType);
        }
        catch (Exception ex)
        {
            return null;
        }
    }
    public ArrayList<dto.Document> getActiveDocuments(String folder)
    {
        dto.GetActiveDocumentsRequest req=new dto.GetActiveDocumentsRequest();
        req.Folder=folder;
        String path="/Document/GetActiveDocuments/{Folder}";
        path=path.replaceAll("\\{Folder\\}",req.Folder);
        return this.sendGet(path,req);
    }
    public String getDocumentUrl(String documentReference)
    {
        dto.DocumentRequest req=new dto.DocumentRequest();
        req.DocumentReference=documentReference;
        String path="/Document/GetDocumentUrl/{DocumentReference}";
        path=path.replaceAll("\\{DocumentReference\\}",req.DocumentReference);
        return this.sendGet(path,req).Url;
    }
    public dto.Document getDocumentStatus(String documentReference)
    {
        dto.StatusRequest req=new dto.StatusRequest();
        req.DocumentReference=documentReference;
        String path="/Document/Status/{DocumentReference}";
        path=path.replaceAll("\\{DocumentReference\\}",req.DocumentReference);
        dto.Document result=this.sendGet(path,req);
        return result;
    }
    public ArrayList<dto.DocumentLog> getDocumentLog(String documentReference)
    {
        dto.LogRequest req=new dto.LogRequest();
        req.DocumentReference=documentReference;
        String path="/Document/Log/{DocumentReference}";
        path=path.replaceAll("\\{DocumentReference\\}",req.DocumentReference);
        return this.sendGet(path,req);
    }
    public dto.Document extendDocument(String documentReference,Date dueDate,String gmt)
    {
        dto.ExtendRequest req=new dto.ExtendRequest();
        req.DocumentReference=documentReference;
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        req.DueDate=df.format(dueDate);
        req.GMT=gmt;
        return this.sendPost("/Document/Extend",req);
    }
    public dto.Document updateSigner(String documentReference,ArrayList<dto.Signer> signers)
    {
        dto.SignerRequest req=new dto.SignerRequest();
        req.DocumentReference=documentReference;
        req.Signers=signers;
        return this.sendPost("/Document/UpdateSigner",req);
    }
    public dto.Document uploadDocumentByUrl(String name,String fileType,String url)
    {
        dto.UploadRequest req=new dto.UploadRequest();
        req.File=new dto.FileInfo();
        req.File.Name=name;
        req.File.FileType=fileType;
        req.File.FileUrl=url;
        return this.sendPost("/Document/UploadByUrl",req);
    }
    public dto.DocumentValidationResponse validateDocument(String documentReference)
    {
        dto.DocumentValidationRequest req=new dto.DocumentValidationRequest();
        req.DocumentReference=documentReference;
        String path="/Document/Validation/{DocumentReference}";
        path=path.replaceAll("\\{DocumentReference\\}",req.DocumentReference);

        return this.sendGet(path, req);
    }
    public dto.DocumentValidationResponse validateDocumentFile(File file)
    {
        dto.DocumentFileValidationRequest req=new dto.DocumentFileValidationRequest();
        return this.sendPost("/Document/FileValidation",req,file);
    }
    public String uploadDocumentFile(File file)
    {
        dto.UploaderRequest req =new dto.UploaderRequest();
        return this.sendPost("/Document/Uploader",req,file).Reference;
    }
    public ArrayList<dto.FormDirect> getFormList()
    {
        dto.FormDirectRequest req=new dto.FormDirectRequest();
        return this.sendGet("/FormDirect/GetFormList",req);
    }
    public dto.FormDirect getSingleForm(String formReference)
    {
        dto.SingleFormDirectRequest req=new dto.SingleFormDirectRequest();
        req.FormReference=formReference;
        String path="/FormDirect/GetSingleForm/{FormReference}";
        path=path.replaceAll("\\{FormReference\\}",req.FormReference);
        dto.FormDirect result=this.sendGet(path,req);
        return result;
    }
    public ArrayList<dto.Document> sendForms(ArrayList<dto.FormDirect> forms,Date dueDate)
    {
        dto.SendFormDirectRequest req=new dto.SendFormDirectRequest();
        req.Forms=forms;
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        req.DueDate=df.format(dueDate);
        return this.sendPost("/FormDirect/SendForms",req);
    }
    public String getFormData(String formReference,String fileType,String separator)
    {
        dto.FormDataRequest req=new dto.FormDataRequest();
        req.DocumentReference=formReference;
        req.FormDataFileType=fileType;
        req.Separator=separator;
        String path="/FormDirect/GetFormData/{DocumentReference}/{FormDataFileType}?Separator={Separator}";
        path=path.replaceAll("\\{DocumentReference\\}",req.DocumentReference);
        path=path.replaceAll("\\{FormDataFileType\\}",req.FormDataFileType);
        path=path.replaceAll("\\{Separator\\}",req.Separator);
        return  this.sendGet(path,req).Url;
    }
    public dto.Signer getSignerLink(String documentReference,String signerEmail,String signerFirstName,String signerLastName)
    {
        dto.LinkRequest req=new dto.LinkRequest();
        req.DocumentReference=documentReference;
        req.Signer=new dto.Signer();
        req.Signer.FirstName=signerFirstName;
        req.Signer.Email=signerEmail;
        req.Signer.LastName=signerLastName;
        return this.sendPost("/FormDirect/GetSignerLink",req);
    }
    public ArrayList<dto.Document> sendSmartTagDocument(ArrayList<String> documentReferences,Boolean embedded,Date dueDate,String emailTemplateReference,String workflowReference,String returnUrl)
    {
        dto.SmartTagRequest req=new dto.SmartTagRequest();
        req.DocumentReferences=documentReferences;
        req.Embedded=embedded;
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        req.DueDate=df.format(dueDate);
        req.EmailTemplateReference=emailTemplateReference;
        req.WorkflowReference=workflowReference;
        req.ReturnUrl=returnUrl;
        return this.sendPost("/FormDirect/SendForms",req);
    }
    public dto.ProcessDocument sendMailMerge(String documentReference,Date dueDate,String emailTemplateReference,String mailMergeFileType,byte[] mailMergeListData,Boolean embedded,String returnUrl)
    {
        dto.MailMergeRequest req=new dto.MailMergeRequest();
        req.DocumentReference=documentReference;
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        req.DueDate=df.format(dueDate);
        req.EmailTemplateReference=emailTemplateReference;
        req.MailMergeListFileData=new String(Base64.encode(mailMergeListData));
        req.MailMergeListFileType=mailMergeFileType;
        req.Embedded=embedded;
        req.ReturnUrl=returnUrl;
        return this.sendPost("/SmartTag/MailMerge",req);
    }
    public dto.ProcessDocument getMailMergeDocuments(String processDocumentReference)
    {
        dto.ProcessDocumentRequest req=new dto.ProcessDocumentRequest();
        req.ProcessDocumentReference=processDocumentReference;
        String path="/SmartTag/MailMergeDocuments/{ProcessDocumentReference}";
        path=path.replaceAll("\\{ProcessDocumentReference\\}",req.ProcessDocumentReference);
        dto.ProcessDocument result=this.sendGet(path,req);
        return result;
    }
    public ArrayList<dto.EmailTemplate> getInvitationEmailTemplates()
    {
        dto.EmailTemplateRequest req=new dto.EmailTemplateRequest();

        return this.sendGet("/EmailTemplate/GetInvitationTemplates",req);
    }
}
