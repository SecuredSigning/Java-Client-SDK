/* Options:
Date: 2015-10-05 10:25:15
Version: 4.046
BaseUrl: https://api.dsx.co.nz/web/v1.3

Package: com.securedsigning.rest.client
GlobalNamespace: dto
//AddPropertyAccessors: True
//SettersReturnThis: True
//AddServiceStackTypes: True
//AddResponseStatus: False
//AddImplicitVersion: 
//IncludeTypes: 
//ExcludeTypes: 
//TreatTypesAsStrings: 
//DefaultImports: java.math.*,java.util.*,net.servicestack.client.*,com.google.gson.annotations.*,com.google.gson.reflect.*
*/

package com.securedsigning.rest.client;

import java.util.*;
import net.servicestack.client.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;

public class dto
{

    @Route(Path="/Download/GetDocumentData/{DocumentReference}", Verbs="GET")
    // @ApiResponse(404, "Document not found, may have been removed")
    // @ApiResponse(500, "Unhandled error: Please contact Secured Signing")
    // @ApiResponse(401, "Unauthorised: Check your api key")
    // @ApiResponse(200, "Request successful")
    public static class DownloadDocumentRequest implements IReturn<Object>
    {
        @ApiMember(ParameterType="path", Description="Document reference", DataType="string", IsRequired=true)
        public String DocumentReference = null;
        
        public String getDocumentReference() { return DocumentReference; }
        public DownloadDocumentRequest setDocumentReference(String value) { this.DocumentReference = value; return this; }
        private static Object responseType = Object.class;
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/Download/FormData/{DocumentReference}/{FormDataFileType}", Verbs="GET")
    public static class DownloadFormDataRequest implements IReturn<Object>
    {
        @ApiMember(Description="Document reference", ParameterType="path", DataType="string", IsRequired=true)
        public String DocumentReference = null;

        @ApiMember(Description="Form data file return type", ParameterType="path", DataType="string", IsRequired=true)
        public String FormDataFileType = null;
        
        public String getDocumentReference() { return DocumentReference; }
        public DownloadFormDataRequest setDocumentReference(String value) { this.DocumentReference = value; return this; }
        public String getFormDataFileType() { return FormDataFileType; }
        public DownloadFormDataRequest setFormDataFileType(String value) { this.FormDataFileType = value; return this; }
        private static Object responseType = Object.class;
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/EmailTemplate/GetInvitationTemplates", Verbs="GET")
    // @ApiResponse(500, "Unhandled error: Please contact Secured Signing")
    // @ApiResponse(401, "Unauthorised: Check your api key")
    // @ApiResponse(200, "Request successful")
    public static class EmailTemplateRequest implements IReturn<ArrayList<EmailTemplate>>
    {
        
        private static Object responseType = new TypeToken<ArrayList<EmailTemplate>>(){}.getType();
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/Document/Status/{DocumentReference}", Verbs="GET")
    // @ApiResponse(500, "Unhandled error: Please contact Secured Signing")
    // @ApiResponse(404, "Unable to find document, please check reference")
    // @ApiResponse(401, "Unauthorised: Check your api key")
    // @ApiResponse(200, "Request successful")
    public static class StatusRequest implements IReturn<Document>
    {
        @ApiMember(Description="Document reference", ParameterType="path", DataType="string", IsRequired=true)
        public String DocumentReference = null;
        
        public String getDocumentReference() { return DocumentReference; }
        public StatusRequest setDocumentReference(String value) { this.DocumentReference = value; return this; }
        private static Object responseType = Document.class;
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/Document/Log/{DocumentReference}", Verbs="GET")
    // @ApiResponse(404, "Unable to find document, please check reference")
    // @ApiResponse(500, "Unhandled error: Please contact Secured Signing")
    // @ApiResponse(200, "Request successful")
    // @ApiResponse(401, "Unauthorised: Check your api key")
    public static class LogRequest implements IReturn<ArrayList<DocumentLog>>
    {
        @ApiMember(Description="Document reference", ParameterType="path", DataType="string", IsRequired=true)
        public String DocumentReference = null;
        
        public String getDocumentReference() { return DocumentReference; }
        public LogRequest setDocumentReference(String value) { this.DocumentReference = value; return this; }
        private static Object responseType = new TypeToken<ArrayList<DocumentLog>>(){}.getType();
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/Document/UpdateSigner", Verbs="POST")
    // @ApiResponse(404, "Unable to find document, please check reference")
    // @ApiResponse(500, "Unhandled error: Please contact Secured Signing")
    // @ApiResponse(200, "Request successful")
    // @ApiResponse(401, "Unauthorised: Check your api key")
    public static class SignerRequest implements IReturn<Document>
    {
        @ApiMember(Description="Document reference", DataType="string", IsRequired=true)
        public String DocumentReference = null;

        @ApiMember(Description="New signer information", DataType="Signer", IsRequired=true, AllowMultiple=true)
        public ArrayList<Signer> Signers = null;
        
        public String getDocumentReference() { return DocumentReference; }
        public SignerRequest setDocumentReference(String value) { this.DocumentReference = value; return this; }
        public ArrayList<Signer> getSigners() { return Signers; }
        public SignerRequest setSigners(ArrayList<Signer> value) { this.Signers = value; return this; }
        private static Object responseType = Document.class;
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/Document/Extend", Verbs="POST")
    // @ApiResponse(200, "Request successful")
    // @ApiResponse(500, "Unhandled error: Please contact Secured Signing")
    // @ApiResponse(404, "Unable to find document, please check reference")
    // @ApiResponse(401, "Unauthorised: Check your api key")
    public static class ExtendRequest implements IReturn<Document>
    {
        @ApiMember(Description="Document reference", DataType="string", IsRequired=true)
        public String DocumentReference = null;

        @ApiMember(Description="Due date that document is to be signed by.", DataType="Date", IsRequired=true, Name="DueDate")
        public String DueDate = null;

        @ApiMember(Description="GMT Offset", DataType="string")
        public String GMT = null;
        
        public String getDocumentReference() { return DocumentReference; }
        public ExtendRequest setDocumentReference(String value) { this.DocumentReference = value; return this; }
        public String getDueDate() { return DueDate; }
        public ExtendRequest setDueDate(String value) { this.DueDate = value; return this; }
        public String getGmt() { return GMT; }
        public ExtendRequest setGmt(String value) { this.GMT = value; return this; }
        private static Object responseType = Document.class;
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/Document/UploadByUrl", Verbs="POST")
    // @ApiResponse(404, "Document not found, check uploaded file name matches file name in data")
    // @ApiResponse(500, "Unhandled error: Please contact Secured Signing")
    // @ApiResponse(200, "Request successful")
    // @ApiResponse(401, "Unauthorised: Check your api key")
    // @ApiResponse(426, "Not enough documents left in plan")
    // @ApiResponse(413, "File is too large")
    public static class UploadRequest implements IReturn<Document>
    {
        @ApiMember(Description="The file infomation", DataType="FileInfo", IsRequired=true, Name="File")
        public FileInfo File = null;
        
        public FileInfo getFile() { return File; }
        public UploadRequest setFile(FileInfo value) { this.File = value; return this; }
        private static Object responseType = Document.class;
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/Document/Uploader", Verbs="POST")
    // @ApiResponse(413, "File is too large")
    // @ApiResponse(404, "Document not found, check uploaded file name matches file name in data")
    // @ApiResponse(500, "Unhandled error: Please contact Secured Signing")
    // @ApiResponse(200, "Request successful")
    // @ApiResponse(401, "Unauthorised: Check your api key")
    // @ApiResponse(426, "Not enough documents left in plan")
    public static class UploaderRequest implements IReturn<Document>
    {
        @ApiMember(ParameterType="body", DataType="file", IsRequired=true, Name="body")
        public Object AnyThing = null;
        
        public Object getAnyThing() { return AnyThing; }
        public UploaderRequest setAnyThing(Object value) { this.AnyThing = value; return this; }
        private static Object responseType = Document.class;
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/Document/GetDocumentUrl/{DocumentReference}", Verbs="GET")
    // @ApiResponse(500, "Unhandled error: Please contact Secured Signing")
    // @ApiResponse(401, "Unauthorised: Check your api key")
    // @ApiResponse(200, "Request successful")
    // @ApiResponse(404, "Document not found, may have been removed")
    public static class DocumentRequest implements IReturn<DocumentResponse>
    {
        @ApiMember(Description="Document reference", ParameterType="path", DataType="string", IsRequired=true)
        public String DocumentReference = null;
        
        public String getDocumentReference() { return DocumentReference; }
        public DocumentRequest setDocumentReference(String value) { this.DocumentReference = value; return this; }
        private static Object responseType = DocumentResponse.class;
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/Document/GetActiveDocuments/{Folder}", Verbs="GET")
    // @ApiResponse(404, "Document not found, may have been removed")
    // @ApiResponse(401, "Unauthorised: Check your api key")
    // @ApiResponse(500, "Unhandled error: Please contact Secured Signing")
    // @ApiResponse(200, "Request successful")
    public static class GetActiveDocumentsRequest implements IReturn<ArrayList<Document>>
    {
        @ApiMember(ParameterType="path", DataType="string", IsRequired=true, Name="Folder")
        public String Folder = null;
        
        public String getFolder() { return Folder; }
        public GetActiveDocumentsRequest setFolder(String value) { this.Folder = value; return this; }
        private static Object responseType = new TypeToken<ArrayList<Document>>(){}.getType();
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/Document/Validation/{DocumentReference}", Verbs="GET")
    // @ApiResponse(404, "Document not found, may have been removed")
    // @ApiResponse(500, "Unhandled error: Please contact Secured Signing")
    // @ApiResponse(200, "Request successful")
    // @ApiResponse(401, "Unauthorised: Check your api key")
    public static class DocumentValidationRequest implements IReturn<DocumentValidationResponse>
    {
        @ApiMember(Description="Document reference", ParameterType="path", DataType="string", IsRequired=true)
        public String DocumentReference = null;
        
        public String getDocumentReference() { return DocumentReference; }
        public DocumentValidationRequest setDocumentReference(String value) { this.DocumentReference = value; return this; }
        private static Object responseType = DocumentValidationResponse.class;
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/Document/FileValidation", Verbs="POST")
    // @ApiResponse(500, "Unhandled error: Please contact Secured Signing")
    // @ApiResponse(401, "Unauthorised: Check your api key")
    // @ApiResponse(404, "Document not found, may have been removed")
    // @ApiResponse(200, "Request successful")
    public static class DocumentFileValidationRequest implements IReturn<DocumentValidationResponse>
    {
        @ApiMember(ParameterType="body", DataType="file", IsRequired=true, Name="body")
        public Object AnyThing = null;
        
        public Object getAnyThing() { return AnyThing; }
        public DocumentFileValidationRequest setAnyThing(Object value) { this.AnyThing = value; return this; }
        private static Object responseType = DocumentValidationResponse.class;
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/FormDirect/GetFormList", Verbs="GET")
    // @ApiResponse(500, "Unhandled error: Please contact Secured Signing")
    // @ApiResponse(401, "Unauthorised: Check your api key")
    public static class FormDirectRequest implements IReturn<ArrayList<FormDirect>>
    {
        
        private static Object responseType = new TypeToken<ArrayList<FormDirect>>(){}.getType();
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/FormDirect/GetSingleForm/{FormReference}", Verbs="GET")
    // @ApiResponse(404, "Form not found")
    // @ApiResponse(500, "Unhandled error: Please contact Secured Signing")
    // @ApiResponse(401, "Unauthorised: Check your api key")
    public static class SingleFormDirectRequest implements IReturn<FormDirect>
    {
        @ApiMember(Description="Form reference", ParameterType="path", DataType="string", IsRequired=true)
        public String FormReference = null;
        
        public String getFormReference() { return FormReference; }
        public SingleFormDirectRequest setFormReference(String value) { this.FormReference = value; return this; }
        private static Object responseType = FormDirect.class;
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/FormDirect/SendForms", Verbs="POST")
    // @ApiResponse(426, "Not enough documents left in plan")
    // @ApiResponse(402, "Account on hold, payment required")
    // @ApiResponse(500, "Unhandled error: Please contact Secured Signing")
    // @ApiResponse(401, "Unauthorised: Check your api key")
    // @ApiResponse(404, "Form not found")
    // @ApiResponse(200, "Forms sent successfully")
    public static class SendFormDirectRequest implements IReturn<ArrayList<Document>>
    {
        @ApiMember(Description="Collection of forms to be sent, if an account reference is not supplied for the forms, the forms will be associated with your api account.", DataType="FormDirect", IsRequired=true, AllowMultiple=true, Name="Forms")
        public ArrayList<FormDirect> Forms = null;

        @ApiMember(Description="Due date that forms are to be signed by. If not set, +14 days is the default", DataType="Date", Name="DueDate")
        public String DueDate = null;
        
        public ArrayList<FormDirect> getForms() { return Forms; }
        public SendFormDirectRequest setForms(ArrayList<FormDirect> value) { this.Forms = value; return this; }
        public String getDueDate() { return DueDate; }
        public SendFormDirectRequest setDueDate(String value) { this.DueDate = value; return this; }
        private static Object responseType = new TypeToken<ArrayList<Document>>(){}.getType();
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/FormDirect/GetFormData/{DocumentReference}/{FormDataFileType}", Verbs="GET")
    // @ApiResponse(500, "Unhandled error: Please contact Secured Signing")
    // @ApiResponse(404, "Form not found")
    // @ApiResponse(401, "Unauthorised: Check your api key")
    // @ApiResponse(200, "Successful")
    public static class FormDataRequest implements IReturn<FormDataResponse>
    {
        @ApiMember(Description="Document reference", ParameterType="path", DataType="string", IsRequired=true)
        public String DocumentReference = null;

        @ApiMember(Description="Form data file return type", ParameterType="path", DataType="string", IsRequired=true)
        public String FormDataFileType = null;

        @ApiMember(Description="Seperator of CSV file (Default - \t), can pass any visible character, e.g. A,#,@,~..., for invisible character, please use '0x' as the prefix for hexidecimal, e.g. 0x09, 0x0a, 0x0d", ParameterType="query", DataType="char")
        public String Separator = null;
        
        public String getDocumentReference() { return DocumentReference; }
        public FormDataRequest setDocumentReference(String value) { this.DocumentReference = value; return this; }
        public String getFormDataFileType() { return FormDataFileType; }
        public FormDataRequest setFormDataFileType(String value) { this.FormDataFileType = value; return this; }
        public String getSeparator() { return Separator; }
        public FormDataRequest setSeparator(String value) { this.Separator = value; return this; }
        private static Object responseType = FormDataResponse.class;
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/FormDirect/GetSignerLink", Verbs="POST")
    // @ApiResponse(500, "Unhandled error: Please contact Secured Signing")
    // @ApiResponse(404, "Not found")
    // @ApiResponse(200, "Successful")
    // @ApiResponse(401, "Unauthorised: Check your api key")
    public static class LinkRequest implements IReturn<Signer>
    {
        @ApiMember(Description="Document reference", DataType="string", IsRequired=true)
        public String DocumentReference = null;

        @ApiMember(Description="Form signer", DataType="Signer", IsRequired=true)
        public Signer Signer = null;
        
        public String getDocumentReference() { return DocumentReference; }
        public LinkRequest setDocumentReference(String value) { this.DocumentReference = value; return this; }
        public Signer getSigner() { return Signer; }
        public LinkRequest setSigner(Signer value) { this.Signer = value; return this; }
        private static Object responseType = Signer.class;
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/SmartTag/Send/", Verbs="POST")
    // @ApiResponse(404, "Unable to find document, please check reference")
    // @ApiResponse(401, "Unauthorised: Check your api key")
    // @ApiResponse(500, "Unhandled error: Please contact Secured Signing")
    // @ApiResponse(200, "Request successful")
    public static class SmartTagRequest implements IReturn<ArrayList<Document>>
    {
        @ApiMember(Description="Mail merge document reference", DataType="string", AllowMultiple=true)
        public ArrayList<String> DocumentReferences = null;

        @ApiMember(Description="Shows if embedded signing", DataType="boolean")
        public Boolean Embedded = null;

        @ApiMember(Description="Due date that document are to be signed by.", DataType="Date", IsRequired=true, Name="DueDate")
        public String DueDate = null;

        @ApiMember(Description="Email template reference", DataType="string")
        public String EmailTemplateReference = null;

        @ApiMember(Description="Workflow reference", DataType="string")
        public String WorkflowReference = null;

        @ApiMember(Description="Return Url", DataType="string")
        public String ReturnUrl = null;
        
        public ArrayList<String> getDocumentReferences() { return DocumentReferences; }
        public SmartTagRequest setDocumentReferences(ArrayList<String> value) { this.DocumentReferences = value; return this; }
        public Boolean isEmbedded() { return Embedded; }
        public SmartTagRequest setEmbedded(Boolean value) { this.Embedded = value; return this; }
        public String getDueDate() { return DueDate; }
        public SmartTagRequest setDueDate(String value) { this.DueDate = value; return this; }
        public String getEmailTemplateReference() { return EmailTemplateReference; }
        public SmartTagRequest setEmailTemplateReference(String value) { this.EmailTemplateReference = value; return this; }
        public String getWorkflowReference() { return WorkflowReference; }
        public SmartTagRequest setWorkflowReference(String value) { this.WorkflowReference = value; return this; }
        public String getReturnUrl() { return ReturnUrl; }
        public SmartTagRequest setReturnUrl(String value) { this.ReturnUrl = value; return this; }
        private static Object responseType = new TypeToken<ArrayList<Document>>(){}.getType();
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/SmartTag/MailMerge/", Verbs="POST")
    // @ApiResponse(401, "Unauthorised: Check your api key")
    // @ApiResponse(404, "Unable to find document, please check reference")
    // @ApiResponse(500, "Unhandled error: Please contact Secured Signing")
    // @ApiResponse(200, "Request successful")
    public static class MailMergeRequest implements IReturn<ProcessDocument>
    {
        @ApiMember(Description="Mail merge document reference", DataType="string", IsRequired=true)
        public String DocumentReference = null;

        @ApiMember(Description="File type of file", DataType="string", IsRequired=true)
        public String MailMergeListFileType = null;

        @ApiMember(Description="Base64 encoded mail merge list file for the document", DataType="string", IsRequired=true)
        public String MailMergeListFileData = null;

        @ApiMember(Description="Due date that document are to be signed by.", DataType="Date", IsRequired=true, Name="DueDate")
        public String DueDate = null;

        @ApiMember(Description="Email template reference", DataType="string")
        public String EmailTemplateReference = null;

        @ApiMember(Description="Shows if embedded signing", DataType="boolean")
        public Boolean Embedded = null;

        @ApiMember(Description="Url to return after document signed", DataType="string")
        public String ReturnUrl = null;
        
        public String getDocumentReference() { return DocumentReference; }
        public MailMergeRequest setDocumentReference(String value) { this.DocumentReference = value; return this; }
        public String getMailMergeListFileType() { return MailMergeListFileType; }
        public MailMergeRequest setMailMergeListFileType(String value) { this.MailMergeListFileType = value; return this; }
        public String getMailMergeListFileData() { return MailMergeListFileData; }
        public MailMergeRequest setMailMergeListFileData(String value) { this.MailMergeListFileData = value; return this; }
        public String getDueDate() { return DueDate; }
        public MailMergeRequest setDueDate(String value) { this.DueDate = value; return this; }
        public String getEmailTemplateReference() { return EmailTemplateReference; }
        public MailMergeRequest setEmailTemplateReference(String value) { this.EmailTemplateReference = value; return this; }
        public Boolean isEmbedded() { return Embedded; }
        public MailMergeRequest setEmbedded(Boolean value) { this.Embedded = value; return this; }
        public String getReturnUrl() { return ReturnUrl; }
        public MailMergeRequest setReturnUrl(String value) { this.ReturnUrl = value; return this; }
        private static Object responseType = ProcessDocument.class;
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/SmartTag/MailMergeDocuments/{ProcessDocumentReference}", Verbs="GET")
    // @ApiResponse(500, "Unhandled error: Please contact Secured Signing")
    // @ApiResponse(401, "Unauthorised: Check your api key")
    // @ApiResponse(404, "Unable to find document, please check reference")
    // @ApiResponse(200, "Request successful")
    public static class ProcessDocumentRequest implements IReturn<ProcessDocument>
    {
        @ApiMember(Description="Mail merge process document reference", ParameterType="path", DataType="string", IsRequired=true)
        public String ProcessDocumentReference = null;
        
        public String getProcessDocumentReference() { return ProcessDocumentReference; }
        public ProcessDocumentRequest setProcessDocumentReference(String value) { this.ProcessDocumentReference = value; return this; }
        private static Object responseType = ProcessDocument.class;
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/UI/Resource", Verbs="GET")
    public static class UIResourceRequest implements IReturn<HttpResult>
    {
        @ApiMember(Description="Resource type", ParameterType="query", DataType="int", IsRequired=true)
        public Integer ResourceType = null;
        
        public Integer getResourceType() { return ResourceType; }
        public UIResourceRequest setResourceType(Integer value) { this.ResourceType = value; return this; }
        private static Object responseType = HttpResult.class;
        public Object getResponseType() { return responseType; }
    }

    @Route(Path="/UI/Setup", Verbs="GET")
    public static class UISetupRequest implements IReturn<HttpResult>
    {
        
        private static Object responseType = HttpResult.class;
        public Object getResponseType() { return responseType; }
    }

    public static class Document
    {
        @ApiMember(Description="File Name", DataType="string", IsRequired=true)
        public String Name = null;

        @ApiMember(Description="Document reference, used for document access", DataType="string", IsRequired=true)
        public String Reference = null;

        @ApiMember(Description="File type of Smart tag", DataType="string")
        public String FileType = null;

        @ApiMember(Description="Form reference", DataType="string")
        public String FormDirectReference = null;

        @ApiMember(Description="List of signers", DataType="Signer", IsRequired=true, AllowMultiple=true)
        public ArrayList<Signer> Signers = null;

        @ApiMember(Description="Document signing status", DataType="string")
        public String Status = null;

        @ApiMember(Description="Purpose for document e.g. use for Smart tags", DataType="string")
        public String ServiceType = null;

        @ApiMember(Description="Due Date of document", DataType="Date")
        public Date DueDate = null;

        @ApiMember(Description="GMT Offset", DataType="string")
        public String GMT = null;
        
        public String getName() { return Name; }
        public Document setName(String value) { this.Name = value; return this; }
        public String getReference() { return Reference; }
        public Document setReference(String value) { this.Reference = value; return this; }
        public String getFileType() { return FileType; }
        public Document setFileType(String value) { this.FileType = value; return this; }
        public String getFormDirectReference() { return FormDirectReference; }
        public Document setFormDirectReference(String value) { this.FormDirectReference = value; return this; }
        public ArrayList<Signer> getSigners() { return Signers; }
        public Document setSigners(ArrayList<Signer> value) { this.Signers = value; return this; }
        public String getStatus() { return Status; }
        public Document setStatus(String value) { this.Status = value; return this; }
        public String getServiceType() { return ServiceType; }
        public Document setServiceType(String value) { this.ServiceType = value; return this; }
        public Date getDueDate() { return DueDate; }
        public Document setDueDate(Date value) { this.DueDate = value; return this; }
        public String getGmt() { return GMT; }
        public Document setGmt(String value) { this.GMT = value; return this; }
    }

    public static class DocumentResponse
    {
        @ApiMember(Description="Url which file content will be downloaded", DataType="string")
        public String Url = null;
        
        public String getUrl() { return Url; }
        public DocumentResponse setUrl(String value) { this.Url = value; return this; }
    }

    public static class DocumentValidationResponse
    {
        public ArrayList<VerifySignature> Signatures = null;
        public String DocumentURL = null;
        public String DocumentName = null;
        
        public ArrayList<VerifySignature> getSignatures() { return Signatures; }
        public DocumentValidationResponse setSignatures(ArrayList<VerifySignature> value) { this.Signatures = value; return this; }
        public String getDocumentURL() { return DocumentURL; }
        public DocumentValidationResponse setDocumentURL(String value) { this.DocumentURL = value; return this; }
        public String getDocumentName() { return DocumentName; }
        public DocumentValidationResponse setDocumentName(String value) { this.DocumentName = value; return this; }
    }

    public static class FormDirect
    {
        @ApiMember(Description="Form name", DataType="string", IsRequired=true)
        public String Name = null;

        @ApiMember(Description="Identifier", DataType="string", IsRequired=true)
        public String Reference = null;

        @ApiMember(Description="List of signers required for the form", DataType="Signer", IsRequired=true, AllowMultiple=true)
        public ArrayList<Signer> Signers = null;

        @ApiMember(Description="If true, the signing links will be used in an iFrame to access the forms", DataType="boolean", IsRequired=true)
        public Boolean EmbedForm = null;

        @ApiMember(Description="After signing a form, the page will redirect to the specified url", DataType="string")
        public String ReturnUrl = null;

        @ApiMember(Description="Auto fill data for the form. It is an XML document converted to a string. Secured Signing creates the template for the data.", DataType="string")
        public String XMLData = null;
        
        public String getName() { return Name; }
        public FormDirect setName(String value) { this.Name = value; return this; }
        public String getReference() { return Reference; }
        public FormDirect setReference(String value) { this.Reference = value; return this; }
        public ArrayList<Signer> getSigners() { return Signers; }
        public FormDirect setSigners(ArrayList<Signer> value) { this.Signers = value; return this; }
        public Boolean isEmbedForm() { return EmbedForm; }
        public FormDirect setEmbedForm(Boolean value) { this.EmbedForm = value; return this; }
        public String getReturnUrl() { return ReturnUrl; }
        public FormDirect setReturnUrl(String value) { this.ReturnUrl = value; return this; }
        public String getXmlData() { return XMLData; }
        public FormDirect setXmlData(String value) { this.XMLData = value; return this; }
    }

    public static class FormDataResponse
    {
        @ApiMember(Description="Url which file content will be downloaded", DataType="string")
        public String Url = null;
        
        public String getUrl() { return Url; }
        public FormDataResponse setUrl(String value) { this.Url = value; return this; }
    }

    public static class Signer
    {
        @ApiMember(Description="Signer reference", DataType="string")
        public String SignerReference = null;

        @ApiMember(Description="First name of user", DataType="string", IsRequired=true)
        public String FirstName = null;

        @ApiMember(Description="Last name of user", DataType="string", IsRequired=true)
        public String LastName = null;

        @ApiMember(Description="Email address of user", DataType="string", IsRequired=true)
        public String Email = null;

        @ApiMember(Description="Role of signer in signing process", DataType="string")
        public String SignerType = null;

        @ApiMember(Description="Mobile number of signer, for SMS secured forms. Must include the mobile carrier code e.g. Australia 04, New Zealand 027 or 021 etc", DataType="string")
        public String MobileNumber = null;

        @ApiMember(Description="Mobile Country code for phone number e.g. Australia 61, New Zealand 64 etc", DataType="string")
        public String MobileCountry = null;

        @ApiMember(Description="Key for access to signing", DataType="string")
        public String SigningKey = null;

        @ApiMember(Description="User signing status", DataType="boolean")
        public Boolean HasSigned = null;

        @ApiMember(Description="When the use of a mobile phone is required for authencation but is not available, enable this option to use known data about the signer they have to use to ID themselves", DataType="boolean")
        public Boolean UseIDData = null;

        @ApiMember(Description="Data required for identifying signers with no access to mobile phones", DataType="AuthInfo")
        public ArrayList<AuthInfo> IDData = null;

        @ApiMember(Description="signer name and email can be updated", DataType="boolean")
        public Boolean Editable = null;

        public String Title = null;
        public String Reason = null;
        public String Company = null;
        
        public String getSignerReference() { return SignerReference; }
        public Signer setSignerReference(String value) { this.SignerReference = value; return this; }
        public String getFirstName() { return FirstName; }
        public Signer setFirstName(String value) { this.FirstName = value; return this; }
        public String getLastName() { return LastName; }
        public Signer setLastName(String value) { this.LastName = value; return this; }
        public String getEmail() { return Email; }
        public Signer setEmail(String value) { this.Email = value; return this; }
        public String getSignerType() { return SignerType; }
        public Signer setSignerType(String value) { this.SignerType = value; return this; }
        public String getMobileNumber() { return MobileNumber; }
        public Signer setMobileNumber(String value) { this.MobileNumber = value; return this; }
        public String getMobileCountry() { return MobileCountry; }
        public Signer setMobileCountry(String value) { this.MobileCountry = value; return this; }
        public String getSigningKey() { return SigningKey; }
        public Signer setSigningKey(String value) { this.SigningKey = value; return this; }
        public Boolean isHasSigned() { return HasSigned; }
        public Signer setHasSigned(Boolean value) { this.HasSigned = value; return this; }
        public Boolean isUseIDData() { return UseIDData; }
        public Signer setUseIDData(Boolean value) { this.UseIDData = value; return this; }
        public ArrayList<AuthInfo> getIdData() { return IDData; }
        public Signer setIdData(ArrayList<AuthInfo> value) { this.IDData = value; return this; }
        public Boolean isEditable() { return Editable; }
        public Signer setEditable(Boolean value) { this.Editable = value; return this; }
        public String getTitle() { return Title; }
        public Signer setTitle(String value) { this.Title = value; return this; }
        public String getReason() { return Reason; }
        public Signer setReason(String value) { this.Reason = value; return this; }
        public String getCompany() { return Company; }
        public Signer setCompany(String value) { this.Company = value; return this; }
    }

    public static class ProcessDocument
    {
        @ApiMember(Description="Document reference, used for document access", DataType="string", IsRequired=true)
        public String Reference = null;

        @ApiMember(Description="Processing status of mail merge", DataType="string", IsRequired=true)
        public String ProcessingStatus = null;

        @ApiMember(Description="List of documents for mail merge process", DataType="Document", IsRequired=true, AllowMultiple=true)
        public ArrayList<Document> Documents = null;
        
        public String getReference() { return Reference; }
        public ProcessDocument setReference(String value) { this.Reference = value; return this; }
        public String getProcessingStatus() { return ProcessingStatus; }
        public ProcessDocument setProcessingStatus(String value) { this.ProcessingStatus = value; return this; }
        public ArrayList<Document> getDocuments() { return Documents; }
        public ProcessDocument setDocuments(ArrayList<Document> value) { this.Documents = value; return this; }
    }

    public static class HttpResult
    {
        public String ResponseText = null;
        public FileInfo FileInfo = null;
        public String ContentType = null;
        public HashMap<String,String> Headers = null;
        public Boolean AllowsPartialResponse = null;
        public HashMap<String,String> Options = null;
        public Integer Status = null;

        public String StatusDescription = null;
        public Object Response = null;
        public IContentTypeWriter ResponseFilter = null;
        public IRequest RequestContext = null;
        public String View = null;
        public String Template = null;
        public Integer PaddingLength = null;
        public Boolean IsPartialRequest = null;
        
        public String getResponseText() { return ResponseText; }
        public HttpResult setResponseText(String value) { this.ResponseText = value; return this; }
        public FileInfo getFileInfo() { return FileInfo; }
        public HttpResult setFileInfo(FileInfo value) { this.FileInfo = value; return this; }
        public String getContentType() { return ContentType; }
        public HttpResult setContentType(String value) { this.ContentType = value; return this; }
        public HashMap<String,String> getHeaders() { return Headers; }
        public HttpResult setHeaders(HashMap<String,String> value) { this.Headers = value; return this; }
        public Boolean isAllowsPartialResponse() { return AllowsPartialResponse; }
        public HttpResult setAllowsPartialResponse(Boolean value) { this.AllowsPartialResponse = value; return this; }
        public HashMap<String,String> getOptions() { return Options; }
        public HttpResult setOptions(HashMap<String,String> value) { this.Options = value; return this; }
        public Integer getStatus() { return Status; }
        public HttpResult setStatus(Integer value) { this.Status = value; return this; }

        public String getStatusDescription() { return StatusDescription; }
        public HttpResult setStatusDescription(String value) { this.StatusDescription = value; return this; }
        public Object getResponse() { return Response; }
        public HttpResult setResponse(Object value) { this.Response = value; return this; }
        public IContentTypeWriter getResponseFilter() { return ResponseFilter; }
        public HttpResult setResponseFilter(IContentTypeWriter value) { this.ResponseFilter = value; return this; }
        public IRequest getRequestContext() { return RequestContext; }
        public HttpResult setRequestContext(IRequest value) { this.RequestContext = value; return this; }
        public String getView() { return View; }
        public HttpResult setView(String value) { this.View = value; return this; }
        public String getTemplate() { return Template; }
        public HttpResult setTemplate(String value) { this.Template = value; return this; }
        public Integer getPaddingLength() { return PaddingLength; }
        public HttpResult setPaddingLength(Integer value) { this.PaddingLength = value; return this; }
        public Boolean getIsPartialRequest() { return IsPartialRequest; }
        public HttpResult setIsPartialRequest(Boolean value) { this.IsPartialRequest = value; return this; }
    }

    public static class EmailTemplate
    {
        @ApiMember(Description="Email template's reference.", DataType="string", IsRequired=true)
        public String Reference = null;

        @ApiMember(Description="Email template's name.", DataType="string", IsRequired=true)
        public String Name = null;
        
        public String getReference() { return Reference; }
        public EmailTemplate setReference(String value) { this.Reference = value; return this; }
        public String getName() { return Name; }
        public EmailTemplate setName(String value) { this.Name = value; return this; }
    }

    public static class DocumentLog
    {
        @ApiMember(Description="Name of user responsible for action", DataType="string")
        public String Name = null;

        @ApiMember(Description="Email of user responsible for action", DataType="string")
        public String Email = null;

        @ApiMember(Description="Log entry", DataType="string")
        public String Action = null;

        @ApiMember(Description="Date of log entry", DataType="date")
        public Date Date = null;

        @ApiMember(Description="GMT Offset", DataType="string")
        public String GMT = null;
        
        public String getName() { return Name; }
        public DocumentLog setName(String value) { this.Name = value; return this; }
        public String getEmail() { return Email; }
        public DocumentLog setEmail(String value) { this.Email = value; return this; }
        public String getAction() { return Action; }
        public DocumentLog setAction(String value) { this.Action = value; return this; }
        public Date getDate() { return Date; }
        public DocumentLog setDate(Date value) { this.Date = value; return this; }
        public String getGmt() { return GMT; }
        public DocumentLog setGmt(String value) { this.GMT = value; return this; }
    }

    public static class FileInfo
    {
        @ApiMember(Description="File Name", DataType="string", IsRequired=true)
        public String Name = null;

        @ApiMember(Description="File type of file", DataType="string", IsRequired=true)
        public String FileType = null;

        @ApiMember(Description="Url to download retrieve file data", DataType="string", IsRequired=true)
        public String FileUrl = null;
        
        public String getName() { return Name; }
        public FileInfo setName(String value) { this.Name = value; return this; }
        public String getFileType() { return FileType; }
        public FileInfo setFileType(String value) { this.FileType = value; return this; }
        public String getFileUrl() { return FileUrl; }
        public FileInfo setFileUrl(String value) { this.FileUrl = value; return this; }
    }

    public static class VerifySignature
    {
        public Boolean isValid = null;
        public String SignatureTime = null;
        public String User = null;
        public SignerResponse Signer = null;
        
        public Boolean getIsValid() { return isValid; }
        public VerifySignature setIsValid(Boolean value) { this.isValid = value; return this; }
        public String getSignatureTime() { return SignatureTime; }
        public VerifySignature setSignatureTime(String value) { this.SignatureTime = value; return this; }
        public String getUser() { return User; }
        public VerifySignature setUser(String value) { this.User = value; return this; }
        public SignerResponse getSigner() { return Signer; }
        public VerifySignature setSigner(SignerResponse value) { this.Signer = value; return this; }
    }

    public static class AuthInfo
    {
        @ApiMember(Description="Description of the information required", DataType="string", IsRequired=true)
        public String Label = null;

        @ApiMember(Description="Value to be matched by invitee", DataType="string", IsRequired=true)
        public String Value = null;

        @ApiMember(Description="Data type", DataType="string", IsRequired=true)
        public String DataType = null;
        
        public String getLabel() { return Label; }
        public AuthInfo setLabel(String value) { this.Label = value; return this; }
        public String getValue() { return Value; }
        public AuthInfo setValue(String value) { this.Value = value; return this; }
        public String getDataType() { return DataType; }
        public AuthInfo setDataType(String value) { this.DataType = value; return this; }
    }

    public static interface IContentTypeWriter
    {
    }

    public static interface IRequest
    {
        public Object OriginalRequest = null;
        public IResponse Response = null;
        public String OperationName = null;
        public String Verb = null;
        public RequestAttributes RequestAttributes = null;
        public IRequestPreferences RequestPreferences = null;
        public Object Dto = null;
        public String ContentType = null;
        public Boolean IsLocal = null;
        public String UserAgent = null;

        public String ResponseContentType = null;
        public Boolean HasExplicitResponseContentType = null;
        public HashMap<String,Object> Items = null;
        public INameValueCollection Headers = null;
        public INameValueCollection QueryString = null;
        public INameValueCollection FormData = null;
        public Boolean UseBufferedStream = null;
        public String RawUrl = null;
        public String AbsoluteUri = null;
        public String UserHostAddress = null;
        public String RemoteIp = null;
        public Boolean IsSecureConnection = null;
        public ArrayList<String> AcceptTypes = null;
        public String PathInfo = null;
        public Long ContentLength = null;
        public ArrayList<IHttpFile> Files = null;

    }

    public static class SignerResponse
    {
        @ApiMember(Description="First name of user", DataType="string", IsRequired=true)
        public String FirstName = null;

        @ApiMember(Description="Last name of user", DataType="string", IsRequired=true)
        public String LastName = null;

        @ApiMember(Description="Email address of user", DataType="string", IsRequired=true)
        public String Email = null;

        @ApiMember(Description="Role of signer in signing process", DataType="string")
        public String SignerType = null;

        @ApiMember(Description="Mobile number of signer, for SMS secured forms. Must include the mobile carrier code e.g. Australia 04, New Zealand 027 or 021 etc", DataType="string")
        public String MobileNumber = null;

        @ApiMember(Description="Mobile Country code for phone number e.g. Australia 61, New Zealand 64 etc", DataType="string")
        public String MobileCountry = null;

        @ApiMember(Description="User signing status", DataType="boolean")
        public Boolean HasSigned = null;

        public String Title = null;
        public String Reason = null;
        public String Company = null;
        
        public String getFirstName() { return FirstName; }
        public SignerResponse setFirstName(String value) { this.FirstName = value; return this; }
        public String getLastName() { return LastName; }
        public SignerResponse setLastName(String value) { this.LastName = value; return this; }
        public String getEmail() { return Email; }
        public SignerResponse setEmail(String value) { this.Email = value; return this; }
        public String getSignerType() { return SignerType; }
        public SignerResponse setSignerType(String value) { this.SignerType = value; return this; }
        public String getMobileNumber() { return MobileNumber; }
        public SignerResponse setMobileNumber(String value) { this.MobileNumber = value; return this; }
        public String getMobileCountry() { return MobileCountry; }
        public SignerResponse setMobileCountry(String value) { this.MobileCountry = value; return this; }
        public Boolean isHasSigned() { return HasSigned; }
        public SignerResponse setHasSigned(Boolean value) { this.HasSigned = value; return this; }
        public String getTitle() { return Title; }
        public SignerResponse setTitle(String value) { this.Title = value; return this; }
        public String getReason() { return Reason; }
        public SignerResponse setReason(String value) { this.Reason = value; return this; }
        public String getCompany() { return Company; }
        public SignerResponse setCompany(String value) { this.Company = value; return this; }
    }

    public static interface IResponse
    {
        public Object OriginalResponse = null;
        public IRequest Request = null;
        public Integer StatusCode = null;
        public String StatusDescription = null;
        public String ContentType = null;
        public Object Dto = null;
        public Boolean UseBufferedStream = null;
        public Boolean IsClosed = null;
        public Boolean KeepAlive = null;
        public HashMap<String,Object> Items = null;
    }

    @Flags()
    public static enum RequestAttributes
    {
        @SerializedName("0") None(0),
        @SerializedName("1") Localhost(1),
        @SerializedName("2") LocalSubnet(2),
        @SerializedName("3") InternalNetworkAccess(3),
        @SerializedName("4") External(4),
        @SerializedName("7") AnyNetworkAccessType(7),
        @SerializedName("8") Secure(8),
        @SerializedName("16") InSecure(16),
        @SerializedName("24") AnySecurityMode(24),
        @SerializedName("32") HttpHead(32),
        @SerializedName("64") HttpGet(64),
        @SerializedName("128") HttpPost(128),
        @SerializedName("256") HttpPut(256),
        @SerializedName("512") HttpDelete(512),
        @SerializedName("1024") HttpPatch(1024),
        @SerializedName("2048") HttpOptions(2048),
        @SerializedName("4096") HttpOther(4096),
        @SerializedName("8160") AnyHttpMethod(8160),
        @SerializedName("8192") OneWay(8192),
        @SerializedName("16384") Reply(16384),
        @SerializedName("24576") AnyCallStyle(24576),
        @SerializedName("32768") Soap11(32768),
        @SerializedName("65536") Soap12(65536),
        @SerializedName("131072") Xml(131072),
        @SerializedName("262144") Json(262144),
        @SerializedName("524288") Jsv(524288),
        @SerializedName("1048576") ProtoBuf(1048576),
        @SerializedName("2097152") Csv(2097152),
        @SerializedName("4194304") Html(4194304),
        @SerializedName("8388608") Yaml(8388608),
        @SerializedName("16777216") MsgPack(16777216),
        @SerializedName("33554432") FormatOther(33554432),
        @SerializedName("67076096") AnyFormat(67076096),
        @SerializedName("67108863") Any(67108863),
        @SerializedName("67108864") Http(67108864),
        @SerializedName("134217728") MessageQueue(134217728),
        @SerializedName("268435456") Tcp(268435456),
        @SerializedName("536870912") EndpointOther(536870912),
        @SerializedName("1006632960") AnyEndpoint(1006632960),
        @SerializedName("1073741824") InProcess(1073741824);

        private final int value;
        RequestAttributes(final int intValue) { value = intValue; }
        public int getValue() { return value; }
    }

    public static interface IRequestPreferences
    {
        public Boolean AcceptsGzip = null;
        public Boolean AcceptsDeflate = null;
    }

    public static interface INameValueCollection
    {
        public Object Original = null;
        public ArrayList<String> AllKeys = null;
    }

    public static interface IHttpFile
    {
        public String FileName = null;
        public Long ContentLength = null;
        public String ContentType = null;
    }

}
