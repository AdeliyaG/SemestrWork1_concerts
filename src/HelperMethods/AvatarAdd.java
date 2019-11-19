package HelperMethods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

public class AvatarAdd {
    String UPLOADS = "media";

    public String addMedia(HttpServletRequest request, String file) throws IOException, ServletException {
        Part part = request.getPart(file);
        String applicationPath = request.getServletContext().getRealPath("/media");
        String uploadPath = applicationPath + File.separator;
        String fileName = getFileName(part);
        part.write(uploadPath + File.separator + fileName);
        return UPLOADS + File.separator + fileName;
    }

    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= " + contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length() - 1);
            }
        }
        return "";
    }
}
