<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="org.apache.commons.io.output.*" %>
<%
   File file;
   int maxFileSize = 5000 * 1024;
   int maxMemSize = 5000 * 1024;
   String filePath = "/home/iapereira/download/";
   String contentType = request.getContentType();
   if ((contentType.indexOf("multipart/form-data") >= 0)) {
      DiskFileItemFactory factory = new DiskFileItemFactory();
      factory.setSizeThreshold(maxMemSize);
      factory.setRepository(new File("/home/iapereira/tmp"));
      ServletFileUpload upload = new ServletFileUpload(factory);
      upload.setSizeMax(maxFileSize);
      try { 
         List fileItems = upload.parseRequest(request);
         Iterator i = fileItems.iterator();
         out.println("<html>");
         out.println("<body>");
         while (i.hasNext()) {
            FileItem fi = (FileItem)i.next();
            if (!fi.isFormField())  {
                String fieldName = fi.getFieldName();
                String fileName = fi.getName();
                boolean isInMemory = fi.isInMemory();
                long sizeInBytes = fi.getSize();
                //file = new File( filePath + "yourFileName") ;
                file = new File(filePath + fileName) ;
                fi.write(file) ;
                out.println("Upload do Arquivo " + filePath + fileName + " Realizado com sucesso...<br>");
            }
         }
         out.println("</body>");
         out.println("</html>");
      } catch(Exception ex) {
         System.out.println(ex);
      }
   }else {
      out.println("<html>");
      out.println("<body>");
      out.println("<p>Erro no Upload!!!</p>"); 
      out.println("</body>");
      out.println("</html>");
   }
%>